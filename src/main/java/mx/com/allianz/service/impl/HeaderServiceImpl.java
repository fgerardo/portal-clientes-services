package mx.com.allianz.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.allianz.cipher.service.Decrypt;
import mx.com.allianz.cipher.service.DecryptResponse;
import mx.com.allianz.client.SoapClient;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.config.ProductosConfiguration;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.ContenidoModel.TipoCliente;
import mx.com.allianz.model.Contratante;
import mx.com.allianz.model.GeneralesModel;
import mx.com.allianz.model.LDAPResponse;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.Poliza;
import mx.com.allianz.model.ResponseGenerica;
import mx.com.allianz.model.ResponseHeaderModel;
import mx.com.allianz.model.ResponsePolizaModel;
import mx.com.allianz.model.Root;
import mx.com.allianz.model.Row;
import mx.com.allianz.service.IHeaderService;
import mx.com.allianz.util.FormatosUtil;
import mx.com.allianz.util.ImagenPerfilUtil;

@Service
public class HeaderServiceImpl implements IHeaderService {
	private static final Logger log = LoggerFactory.getLogger(SiniestroServiceImpl.class);

	@Autowired
	private ServicesConfiguration servicesConfiguration;
	
	@Autowired
	private ProductosConfiguration productosConfiguration;

	@Autowired
	private SoapClient soapClient;
	@Autowired
	private ImagenPerfilUtil imagenPerfilUtil;

	/**
	 * Instancia de manejo de codigos de respuesta
	 */
	@Autowired
	private Codes codes;

	private final RestTemplate restTemplate;

	public HeaderServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public RespuestaGenerica procesarHeader(ParametroRequestModel request) throws BusinessException {
		ResponseHeaderModel responseHeader = new ResponseHeaderModel();
		try {
			String idUsuario = "";
			String codeSend = "";
			// Desencriptar parámetros recibidos
			String urlDecript = decryptRequest(request.getParametro());

			// Extraer parámetros de la URL desencriptada
			String[] parametrosArreglo = extractParameters(urlDecript);
			String parValor = parametrosArreglo[0];
			int separador = parValor.lastIndexOf("=");

			if (separador > 0) {
				idUsuario = parValor.substring(3);

			}

			String emailURL = parametrosArreglo[3].split("=")[1];

			List<LDAPResponse> ldapClientes = isLDAPClientes(emailURL);
			log.info("ldapClientes " + ldapClientes);

			String exitsLDAPClientes = exitsLDAPClientes(ldapClientes);

			String codCliente = exitsLDAPClientes != null ? exitsLDAPClientes : idUsuario;

			Map<String, String> clienteInfo = isContratante(codCliente);

			String isContratante = clienteInfo.get("isContratante");
			String codCliIntegrador = clienteInfo.get("codCliIntegrador");

			responseHeader.setIsContratante(isContratante.equalsIgnoreCase("s"));

			String idAgente = null;
			if (urlDecript.contains("idAgente")) {
				String claveAgentePar = parametrosArreglo[5];
				idAgente = claveAgentePar.split("=")[1];
			}

			if (!(codCliIntegrador.isEmpty())) {
				codeSend = codCliIntegrador;
			} else {
				codeSend = codCliente;
			}
			responseHeader.setCodCliIntegrador(codeSend);
			String polizas = getPolizas(codeSend, idAgente, isContratante, emailURL);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<LDAPResponse> isLDAPClientes(String correoCliente) {
		List<LDAPResponse> responseList = null;
		try {
			HttpHeaders headers = createHeaders();

			String urlServicio = String.format(servicesConfiguration.getConsultarServicioUsuarioEmail(), correoCliente);
			log.info("Url Servicio --> {}", urlServicio);

			// Configuración de la solicitud con los headers
			HttpEntity<String> entity = new HttpEntity<>(headers);

			// Llamar al servicio y mapear la respuesta directamente a una lista de objetos
			// LDAPResponse
			ResponseEntity<List<LDAPResponse>> responseEntity = restTemplate.exchange(urlServicio, HttpMethod.GET,
					entity, new ParameterizedTypeReference<List<LDAPResponse>>() {
					});

			// Obtener la respuesta como lista de objetos
			responseList = responseEntity.getBody();

			// Log de la respuesta
			log.info("Respuesta del servicio LDAP: {}", responseList);

		} catch (Exception e) {
			log.error("Error al consultar el servicio: {}", e.getMessage());
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}
		return responseList;
	}

	private String exitsLDAPClientes(List<LDAPResponse> ldapClientes) {
		// Asegúrate de que la lista no sea nula y tenga al menos un elemento
		if (ldapClientes == null || ldapClientes.isEmpty()) {
			return null;
		}

		// Verifica si el primer elemento tiene un cveCliente no vacío
		String cveCliente = ldapClientes.get(0).getCveCliente();
		return (cveCliente != null && !cveCliente.isEmpty()) ? cveCliente : null;
	}

	public Map<String, String> isContratante(String idCliente) {
		log.info("Metodo isContratante");

		// Mapa de respuesta
		Map<String, String> responseMap = new HashMap<>();

		// Variables locales
		String esContratante = "N"; // Valor por defecto
		String codCliIntegrador = ""; // Inicializar con valor vacío

		try {
			// Crear los encabezados para la solicitud
			HttpHeaders headers = createHeaders();

			// Construir la URL con el idCliente
			String urlServicio = String.format(servicesConfiguration.getSecurityLoginContratante(), idCliente);
			log.info("Url Servicio --> {}", urlServicio);

			// Configuración de la solicitud con los headers
			HttpEntity<String> entity = new HttpEntity<>(headers);

			// Llamar al servicio y mapear la respuesta a ResponseGenerica
			ResponseEntity<ResponseGenerica> responseEntity = restTemplate.exchange(urlServicio, HttpMethod.GET, entity,
					ResponseGenerica.class);

			// Obtener la respuesta y acceder a "esContratante"
			ResponseGenerica respuestaGenerica = responseEntity.getBody();

			if (respuestaGenerica != null && respuestaGenerica.isExitoso()) {
				// Verificar si el objeto tipoCliente no es null y tiene datos
				TipoCliente tipoCliente = respuestaGenerica.getContenido().getTipoCliente();

				if (tipoCliente != null) {
					// Obtener el valor de esContratante
					esContratante = tipoCliente.getEsContratante();

					// Según el valor de esContratante, asignamos el codCli correspondiente
					if ("N".equalsIgnoreCase(esContratante)) {
						codCliIntegrador = tipoCliente.getCodCli();
					} else {
						codCliIntegrador = tipoCliente.getCodCliIntegrador();
					}

					// Log de la respuesta exitosa
					log.info("Respuesta del servicio isContratante: esContratante={}, codCliIntegrador={}",
							esContratante, codCliIntegrador);
				} else {
					log.warn("El objeto tipoCliente está vacío o no contiene datos.");
				}
			} else {
				log.warn("Respuesta no exitosa del servicio isContratante.");
			}

			// Almacenamos los valores en el mapa
			responseMap.put("isContratante", esContratante);
			responseMap.put("codCliIntegrador", codCliIntegrador);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			// Manejo de excepciones específicas de HTTP
			log.error("Error al realizar la solicitud HTTP: {}", e.getMessage());
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		} catch (Exception e) {
			// Manejo de otras excepciones
			log.error("Error inesperado al consultar el servicio: {}", e.getMessage());
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}

		// Retornamos el mapa con los valores
		return responseMap;
	}

	private HttpHeaders createHeaders() {
		log.info("Metodo createHeaders");
		String encodedAuth = encodedAuth();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + encodedAuth);
		return headers;
	}

	private String encodedAuth() {
		log.info("Metodo encodedAuth");
		String usuarioAuthorizationServices = servicesConfiguration.getUsuarioAuthorizationServices();
		String passworAuthorizationServices = servicesConfiguration.getPassworAuthorizationServices();
		String authString = usuarioAuthorizationServices + ":" + passworAuthorizationServices;
		return Base64.getEncoder().encodeToString(authString.getBytes());
	}

	private String decryptRequest(String encryptedText) {
		log.info("Metodo decryptRequest");
		Decrypt requestDecrypt = new Decrypt();
		requestDecrypt.setInCryptText(encryptedText);
		DecryptResponse decrypt = soapClient.getDecrypt(requestDecrypt);
		return decrypt.getOutPlainText();
	}

	private String[] extractParameters(String urlDecript) {
		log.info("Metodo extractParameters");
		int prueba = urlDecript.lastIndexOf("?");
		String parametrosJuntos = urlDecript.substring(prueba + 1);
		return parametrosJuntos.split("&");
	}

	private String getPolizas(String idCliente, String idAgente, String isContratante, String mail) {
		try {
			String servicioWebBase = servicesConfiguration.getServicioPolizas();
			String servicioWeb = "";
			boolean isContra = false;

			// Comprobamos que isContratante no sea nulo ni vacío
			// Verificamos si isContratante no es null ni vacío

			if (isContratante != null && !isContratante.isEmpty()) {
				if (isContratante.equalsIgnoreCase("n")) {
					// Si es Contratante "N", usamos el correo (mail) para la consulta
					if (mail.equalsIgnoreCase("USER")) {
						// Cuando es "USER", usamos idCliente en la consulta
						servicioWeb = String.format(servicioWebBase, "$text", "$search\":\"" + idCliente + "\"");
					} else {
						// Usamos el correo cuando no es "USER"
						servicioWeb = String.format(servicioWebBase, "\"Contratante.UsApp\"", "\"" + mail + "\"");
					}
				} else if (isContratante.equalsIgnoreCase("s")) {
					// Si es Contratante "S", usamos idCliente para la búsqueda
					isContra = true;
					servicioWeb = String.format(servicioWebBase, "$text", "$search\":\"" + idCliente + "\"");
				}
			} else {
				// Caso cuando isContratante es null o vacío
				if (mail.equalsIgnoreCase("USER")) {
					// Cuando es "USER", usamos idCliente
					servicioWeb = String.format(servicioWebBase, "$text", "$search\":\"" + idCliente + "\"");
				} else {
					// Usamos el correo cuando no es "USER"
					servicioWeb = String.format(servicioWebBase, "\"Contratante.UsApp\"", "\"" + mail + "\"");
				}
			}

			if (isContratante != null && !isContratante.isEmpty()) {
				if (isContratante.equalsIgnoreCase("n")) {
					// Si es Contratante "N", usamos el correo (mail) para la consulta
					servicioWeb = String.format(servicioWebBase,
							mail.equalsIgnoreCase("USER") ? "$text" : "\"Contratante.UsApp\"", // Primer %s con comillas
																								// escapadas
							mail.equalsIgnoreCase("USER") ? "$search\":\"" + idCliente + "\"" : "\"" + mail + "\"");
				} else if (isContratante.equalsIgnoreCase("s")) {
					// Si es Contratante "S", usamos idCliente para la búsqueda
					isContra = true;
					servicioWeb = String.format(servicioWebBase, "\"$text\"", // Primer %s con comillas escapadas
							"\"$search\":\"" + idCliente + "\""); // Segundo %s con comillas escapadas
				}
			} else {
				// Caso cuando isContratante es null o vacío
				servicioWeb = String.format(servicioWebBase,
						mail.equalsIgnoreCase("USER") ? "$text" : "\"Contratante.UsApp\"",
						mail.equalsIgnoreCase("USER") ? "$search\":\"" + idCliente + "\"" : "\"" + mail + "\"");
			}

			Root servicesAllianzPoliza = getServicesAllianzPoliza(servicioWeb);
			resultadoPolizas(servicesAllianzPoliza.getRows(), isContra);
			log.info("Response {}", servicesAllianzPoliza);
		} catch (Exception e) {
			log.error("Exception {}", e);
		}
		return null;
	}

	public Root getServicesAllianzPoliza(String url) {
		Root res = null;
		try {
			String encodedAuth = encodedAuth();
			// Crear la URL de conexión
			URL urlWeb = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlWeb.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + encodedAuth);

			// Verificar el código de estado HTTP
			int status = urlConnection.getResponseCode();
			if (status == HttpURLConnection.HTTP_OK) {
				// Leer la respuesta si el código de estado es 200 OK
				try (InputStream is = urlConnection.getInputStream()) {
					// Deserializar directamente desde el InputStream
					ObjectMapper mapper = new ObjectMapper();
					res = mapper.readValue(is, Root.class);
				} catch (IOException e) {
					log.error("Error al leer la respuesta: {}", e.getMessage());
				}
			} else {
				// Manejar el caso de error en la solicitud
				log.error("Error en la solicitud. Código de estado: {}", status);
			}
		} catch (IOException e) {
			log.error("Error al realizar la solicitud: {}", e.getMessage());
		}
		return res; // Regresar el objeto Root deserializado
	}

	private void resultadoPolizas(ArrayList<Row> rows, boolean isContra) {
		if (rows != null && rows.size() > 0) {
			ArrayList<Poliza> dataService = null;
			Poliza resultadoPoliza = new Poliza();

			// Iterar a través de la lista solo hasta encontrar el primer Contratante válido
			for (int y = 0; y < rows.size(); y++) {
				Row row = rows.get(y); // Mejorar la legibilidad al obtener el objeto Row
				Contratante contra = row.getContratante(); // Obtener el Contratante
				String validaContratante = contra != null ? contra.getEsContratante() : null;
				log.info("validaContratante: " + validaContratante);

				if ("S".equalsIgnoreCase(validaContratante)) { // Usar equalsIgnoreCase para evitar NullPointerException
					dataService = row.getPolizas(); // Suponiendo que getData() devuelve un JSONObject
					break; // Salir del loop una vez que encontramos el primer Contratante válido
				}
			}

			// Si no se encuentra un Contratante válido, puedes manejar el caso aquí
			if (dataService != null) {
				// Procesar el JSONObject
				log.info("dataService encontrado: " + dataService.toString());
				resultadoPoliza = dataService.get(0);
				procesarPolizas(rows, isContra);
			} else {
				log.warn("No se encontró un Contratante válido.");
			}
		} else {
			log.warn("La lista de rows está vacía o es nula.");
		}
	}

	public ResponsePolizaModel procesarPolizas(ArrayList<Row> rows, boolean isContra) {
		ResponsePolizaModel response = new ResponsePolizaModel();
		List<Poliza> polizas = new ArrayList<>();

		if (rows == null || rows.isEmpty()) {
			response.setEstatus(false);
			response.setMensaje("No se encontraron datos.");
			return response;
		}

		// Buscar contratante con EsContratante = "S" o usar el primero
		Row dataService = rows.stream().filter(row -> row.getContratante() != null)
				.filter(row -> "S".equalsIgnoreCase(row.getContratante().getEsContratante())).findFirst()
				.orElse(rows.get(0));

		Contratante contratante = dataService.getContratante();
		if (contratante == null) {
			response.setEstatus(false);
			response.setMensaje("No se encontró información del contratante.");
			return response;
		}

		// Datos básicos del contratante
		String idClientePoliza = contratante.getIdCliente();
		String rfc = contratante.getrFC();
		response.setEstatus(true);
		response.setMensaje("JSON Consumido correctamente");
		response.setIdClientePoliza(idClientePoliza);
		response.setRfc(rfc);

		String nombre = Optional.ofNullable(contratante.getNombre()).orElse(contratante.getNombreCompleto());
		String tipoPersona = contratante.getTipoPersona();
		response.setNombre(nombre);
		response.setTipoPersona(tipoPersona);

		String apellidoP = "";
		String apellidoM = "";

		if ("FISICA".equalsIgnoreCase(tipoPersona)) {
			apellidoP = contratante.getApellidoPaterno();
			apellidoM = contratante.getApellidoMaterno();
		}

		response.setApellidoP(apellidoP);
		response.setApellidoM(apellidoM);

		GeneralesModel procesaModelGeneral = procesaModelGeneral(contratante, nombre, apellidoP, apellidoM, isContra);
		
		polizas.addAll(dataService.getPolizas());
		
		if (dataService.getPolizasGMMAsegurado() != null) {
	        for (Object o : dataService.getPolizasGMMAsegurado()) {
	            if (o instanceof Poliza) {
	                polizas.add((Poliza) o);
	            }
	        }
	    }
		
		// Establecer generales si tu response lo soporta
		response.setGenerales(procesaModelGeneral); // ← Este método debe existir en ResponsePolizaModel

		return response;
	}

	private GeneralesModel procesaModelGeneral(Contratante contratante, String nombre, String apellidoP,
			String apellidoM, boolean isContra) {

		// GeneralesModel para nombreCliente
		GeneralesModel generales = new GeneralesModel();
		if (contratante.getNombreCompleto() == null || contratante.getNombreCompleto().isEmpty()) {
			String nombreCliente = Stream.of(nombre, apellidoP, apellidoM).filter(Objects::nonNull).map(String::trim)
					.filter(s -> !s.isEmpty()).collect(Collectors.joining(" "));
			generales.setNombreCliente(nombreCliente);
		} else {
			generales.setNombreCliente(contratante.getNombreCompleto());
		}

		generales.setClienteDesde(FormatosUtil.dateFormat(contratante.getFechaAntiguedad()));
		generales.setIdCliente(contratante.getIdCliente());
		generales.setEmail(contratante.getEmail().equalsIgnoreCase("") && !(isContra) ? contratante.getUsApp()
				: contratante.getEmail());
		generales.setFotoCliente("data:image/jpeg;base64," + imagenPerfilUtil.obtenerImagenPerfilUsuario(
				contratante.getEmail() != null && contratante.getEmail() != "" ? contratante.getEmail()
						: contratante.getUsApp()));

		String fechaActualizacion = contratante.getFechaUltimaActualizacion();
		if (fechaActualizacion != null && fechaActualizacion.length() >= 10) {
			fechaActualizacion = fechaActualizacion.substring(0, 10);
		}
		generales.setFechaUltimaActualizacion(fechaActualizacion);
		generales.setTipoPersona(contratante.getTipoPersona());
		generales.setRfc(contratante.getrFC());
		return generales;
	}
	
	private void searhPolizas(Row dataService, List<Poliza> polizas, String idClientePoliza, String idAgente) {
		String productosVisiblesPortal = productosConfiguration.getProductosVisiblesPortal();
		
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

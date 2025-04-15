package mx.com.allianz.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
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
import com.google.gson.Gson;

import mx.com.allianz.cipher.service.Decrypt;
import mx.com.allianz.cipher.service.DecryptResponse;
import mx.com.allianz.client.SoapClient;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.config.ProductosConfiguration;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.exception.DataAccessException;
import mx.com.allianz.model.Asegurado;
import mx.com.allianz.model.BienAsegurado;
import mx.com.allianz.model.CoberturaAsegurado;
import mx.com.allianz.model.CoberturaBien;
import mx.com.allianz.model.CoberturaInmueble;
import mx.com.allianz.model.Coberturas;
import mx.com.allianz.model.CoberturasModel;
import mx.com.allianz.model.ContenidoModel.TipoCliente;
import mx.com.allianz.model.Contratante;
import mx.com.allianz.model.DatosPago;
import mx.com.allianz.model.GeneralesEmpresarialModel;
import mx.com.allianz.model.GeneralesModel;
import mx.com.allianz.model.InformacionPersonalModel;
import mx.com.allianz.model.InmuebleAsegurado;
import mx.com.allianz.model.InmuebleAseguradoDestino;
import mx.com.allianz.model.Intermediario;
import mx.com.allianz.model.LDAPResponse;
import mx.com.allianz.model.LeyendaMosaico;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.Poliza;
import mx.com.allianz.model.PolizaLimpiaModel;
import mx.com.allianz.model.Producto;
import mx.com.allianz.model.ProductosConfiguracionModel;
import mx.com.allianz.model.ResponsablePago;
import mx.com.allianz.model.ResponseGenerica;
import mx.com.allianz.model.ResponseHeaderModel;
import mx.com.allianz.model.ResponsePolizaModel;
import mx.com.allianz.model.RespuestaPolizaModel;
import mx.com.allianz.model.Root;
import mx.com.allianz.model.Row;
import mx.com.allianz.service.IHeaderService;
import mx.com.allianz.util.DetalleDeSaldo;
import mx.com.allianz.util.FolletoProductoUtil;
import mx.com.allianz.util.FormatosUtil;
import mx.com.allianz.util.GrupoDePolizasHardCode;
import mx.com.allianz.util.ImagenPerfilUtil;
import mx.com.allianz.util.JSONFactoryUtil;

@Service
public class HeaderServiceImpl implements IHeaderService {
	private static final Logger log = LoggerFactory.getLogger(SiniestroServiceImpl.class);

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	@Autowired
	private ProductosConfiguration productosConfiguration;

	@Autowired
	private GrupoDePolizasHardCode grupoDePolizasHardCode;

	@Autowired
	private FolletoProductoUtil folletoProductoUtil;

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
		encryptedText = encryptedText.replace(' ', '+');
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

			Root servicesAllianzPoliza = getServicesAllianzPoliza(servicioWeb);
			resultadoPolizas(servicesAllianzPoliza.getRows(), isContra, idAgente);
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

	private void resultadoPolizas(ArrayList<Row> rows, boolean isContra, String idAgente) {
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
				procesarPolizas(rows, isContra, idAgente);
			} else {
				log.warn("No se encontró un Contratante válido.");
			}
		} else {
			log.warn("La lista de rows está vacía o es nula.");
		}
	}

	public ResponsePolizaModel procesarPolizas(ArrayList<Row> rows, boolean isContra, String idAgente) {
		ResponsePolizaModel response = new ResponsePolizaModel();
		RespuestaPolizaModel respuesta = new RespuestaPolizaModel();

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

		GeneralesModel procesaModelGeneral = procesaModelGeneral(contratante, nombre, apellidoP, apellidoM, isContra,
				dataService);

		searhPolizas(dataService, idClientePoliza, contratante, idAgente, respuesta, procesaModelGeneral);
//		polizas.addAll(dataService.getPolizas());

//		if (dataService.getPolizasGMMAsegurado() != null) {
//			for (Object o : dataService.getPolizasGMMAsegurado()) {
//				if (o instanceof Poliza) {
//					polizas.add((Poliza) o);
//				}
//			}
//		}

		// Establecer generales si tu response lo soporta
		response.setGenerales(procesaModelGeneral); // ← Este método debe existir en ResponsePolizaModel

		return response;
	}

	private GeneralesModel procesaModelGeneral(Contratante contratante, String nombre, String apellidoP,
			String apellidoM, boolean isContra, Row dataService) {

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

	private void searhPolizas(Row rows, String idClientePoliza, Contratante contratante, String idAgente,
			RespuestaPolizaModel respuesta, GeneralesModel generales) {
		String productosVisiblesPortal = productosConfiguration.getProductosVisiblesPortal();
		Contratante contratanteL = new Contratante();
		String[] polInhabilesArray = null;
		PolizaLimpiaModel polizaLimpia = new PolizaLimpiaModel();
		try {
			if (rows == null) {
				throw new DataAccessException(codes.getResponseCode("IGBL004"));
			}
			ArrayList<Poliza> polizas = rows.getPolizas();

			for (int i = 0; i < polizas.size(); i++) {

				if (rows.getPolizasGMMAsegurado() != null) {
					for (Object o : rows.getPolizasGMMAsegurado()) {
						if (o instanceof Poliza) {
							polizas.add((Poliza) o);
						}
					}
				}
				if (productosVisiblesPortal.length() != 0 && productosVisiblesPortal != "") {
					polInhabilesArray = productosVisiblesPortal.split(",");
				}

				if (polInhabilesArray != null) {
					List<String> polInhabilesArray2 = new ArrayList<>(Arrays.asList(polInhabilesArray));
					String emisor = polizas.get(i).getEmisor();
					if (polInhabilesArray2.contains(emisor)) {
						procesarGeneralesEmpresarial(respuesta, polizas.get(i), contratante, generales);

						// Process the product data
						procesarDatosProductos(generales, polizas.get(i));

						// Set poliza general data
						polizaLimpia.setCodCondGen(polizas.get(i).getCodCondGen());

						// Handle leyenda mosaico and fondos
						procesarLeyendaMosaico(generales, polizas.get(i));
						responsablePago(polizas.get(i), generales);

						// Process fondos data if available
						if (polizas.get(i).getFondo() != null && !polizas.get(i).getFondo().isEmpty()) {
							armarDetalleDeSaldo(polizas.get(i));
						}

						if (!polizas.get(i).getVehiculo().isEmpty()) {
							polizaLimpia.setVehiculo(polizas.get(i).getVehiculo());
						}

						generales.setFamiliaPoliza(emisor);
						generales.setCodMoneda(polizas.get(i).getCodMoneda());
						generales.setFechaTerminoVigencia(FormatosUtil.dateFormat(polizas.get(i).getFecIniVig()));
						generales.setCaratulaPoliza(
								"https://projects.invisionapp.com/share/3E9AVYBV9#/screens/204561721");
						generales.setIDEPOL(polizas.get(i).getiDEPOL() != null ? polizas.get(i).getiDEPOL() : "");

						InformacionPersonalModel informacionPersona = new InformacionPersonalModel();
						String nombre = "", apellidoP = "", apellidoM = "";
						if (!polizas.get(i).getContratante().isEmpty() || polizas.get(i).contratante.size() != 0) {
							Contratante contratanteService = polizas.get(i).getContratante().get(0).getContratante();

							nombre = contratanteService.getNombre();
							String tipoPersona = contratanteService.getTipoPersona();
							if (tipoPersona.equalsIgnoreCase("FISICA")) {
								apellidoP = contratanteService.getApellidoPaterno();
								apellidoM = contratanteService.getApellidoMaterno();
							}
							contratanteL.setNombreCompleto(nombre + " " + apellidoP + " " + apellidoM);
							String domicilioCompleto = contratanteService.getDomicilioCompleto().replace("\"", "&#34;")
									.replace("\'", "&#39;");
							contratanteL.setDomicilioCompleto(domicilioCompleto);
							contratanteL.setTelParticular(contratanteService.getTelParticular());
							contratanteL.setEmail(contratanteService.getEmail());
							contratanteL.setrFC(contratanteService.getrFC());
							contratanteL.setApellidos(apellidoP + " " + apellidoM);
							contratanteL.setNombre(nombre);

							polizaLimpia.setContratante(contratanteL);

							informacionPersona
									.setClienteDesde(FormatosUtil.dateFormat(contratanteService.getFechaAntiguedad()));
							informacionPersona.setNotificaciones("");
							informacionPersona.setNombreCliente(nombre + " " + apellidoP + " " + apellidoM);
						} else {
							nombre = contratante.getNombre();

							if (contratante.getTipoPersona().equalsIgnoreCase("FISICA")) {
								apellidoP = contratante.getApellidoPaterno();
								apellidoM = contratante.getApellidoMaterno();
							}
							String domicilioCompleto = contratante.getDomicilioCompleto().replace("\"", "&#34;")
									.replace("\'", "&#39;");
							contratanteL.setNombre(nombre + " " + apellidoP + " " + apellidoM);
							contratanteL.setDomicilioCompleto(domicilioCompleto);
							contratanteL.setTelParticular(contratante.getTelParticular());
							contratanteL.setEmail(contratante.getEmail());
							contratanteL.setrFC(contratante.getrFC());
							contratanteL.setApellidos(apellidoP + " " + apellidoM);
							contratanteL.setNombre(nombre);

							polizaLimpia.setContratante(contratanteL);

							informacionPersona
									.setClienteDesde(FormatosUtil.dateFormat(contratante.getFechaAntiguedad()));
							informacionPersona.setNotificaciones("");
							informacionPersona.setNombreCliente(nombre + " " + apellidoP + " " + apellidoM);

						}

						List<Producto> obtenerTodosLosProductos = obtenerTodosLosProductos();
						polizaLimpia.setInformacionPersonal(informacionPersona);
						String familia = grupoDePolizasHardCode.setFamilia(emisor, obtenerTodosLosProductos);
						polizaLimpia.setFamiliaColor(familia);
						polizaLimpia.setGenerales(generales);

						if ((emisor != "ACTD" || (emisor != "ACTM"))) {
							polizaLimpia.setAsegurados(getAsegurados(polizas.get(i)));
							getCoberturas(polizas.get(i), polizaLimpia);
							getIntermediario(null, polizaLimpia, emisor);
							polizaLimpia.setBienesAsegurado(getBienesAsegurado(polizas.get(i).getBienAsegurado()));
							List<InmuebleAseguradoDestino> inmueblesasegurado = getInmueblesasegurado(polizas.get(i).getInmuebleAsegurado());
							polizaLimpia.setInmueblesAsegurado(inmueblesasegurado);
						}

					}

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private List<Producto> obtenerTodosLosProductos() {
		ProductosConfiguracionModel productos = new ProductosConfiguracionModel();
		productos.setFamiliasHogar(productosConfiguration.getProductosHogar());
		productos.setFamiliasSalud(productosConfiguration.getProductosSalud());
		productos.setFamiliasProteccion(productosConfiguration.getProductosProteccion());
		productos.setFamiliasAhorro(productosConfiguration.getProductosAhorro());
		productos.setFamiliasInversion(productosConfiguration.getProductosInversion());
		productos.setFamiliasAuto(productosConfiguration.getProductosAuto());
		return grupoDePolizasHardCode.obtenerTodosLosProductos(productos);
	}

	private void procesarDatosProductos(GeneralesModel generales, Poliza polizas) {
		boolean mostrarPoliza = polizas.getMostrarPolizaAgente().equals("S") ? true : false;
		generales.setEsContratante(
				polizas.getEsContratante() != null && polizas.getEsContratante().equals("S") ? true : false);
		generales.setFolletoProducto("https://projects.invisionapp.com/share/3E9AVYBV9#/screens/204561721");
		generales.setNumeroPoliza(polizas.getEmisor() + "-" + polizas.getNumPoliza() + "-" + polizas.getIdRenovacion());
		generales.setEstatus(polizas.getEstatusPoliza());
		generales.setTipoPoliza(polizas.getEmisor() + polizas.getNumPoliza());
		generales.setFechaInicioVigencia(FormatosUtil.dateFormat(polizas.getFecFinVig()));
		generales.setFechaEmision(FormatosUtil.dateFormat(polizas.getFechaEmision()));

	}

	private void procesarGeneralesEmpresarial(RespuestaPolizaModel respuesta, Poliza polizas, Contratante contratante,
			GeneralesModel generales) {

		// Check if the emitter is GMMC or GMMM
		if (isEmisorGMMCOrGMMM(polizas)) {
			GeneralesEmpresarialModel generalesEmpresarial = obtenerGeneralesEmpresariales(polizas);
			respuesta.setGeneralesEmpresarial(generalesEmpresarial);
		}

	}

	private boolean isEmisorGMMCOrGMMM(Poliza polizas) {
		return polizas.getEmisor().equalsIgnoreCase("GMMC") || polizas.getEmisor().equalsIgnoreCase("GMMM");
	}

	private GeneralesEmpresarialModel obtenerGeneralesEmpresariales(Poliza polizas) {
		List<Contratante> contratantes = polizas.getContratante();
		GeneralesEmpresarialModel generalesEmpresarial = new GeneralesEmpresarialModel();

		if (contratantes != null && !contratantes.isEmpty()) {
			Contratante contratante = contratantes.get(0).getContratante();
			generalesEmpresarial.setDireccionE(obtenerValorNoNulo(contratante.getDomicilioCompleto()));
			generalesEmpresarial.setRfcE(obtenerValorNoNulo(contratante.getrFC()));
			generalesEmpresarial.setEmailE(obtenerValorNoNulo(contratante.getEmail()));
			generalesEmpresarial.setTelefonoE(obtenerValorNoNulo(contratante.getTelParticular()));
			generalesEmpresarial.setNombreE(obtenerValorNoNulo(contratante.getNombre()));
		} else {
			generalesEmpresarial.setDireccionE("ND");
			generalesEmpresarial.setRfcE("ND");
			generalesEmpresarial.setEmailE("ND");
			generalesEmpresarial.setTelefonoE("ND");
			generalesEmpresarial.setNombreE("ND");
		}

		return generalesEmpresarial;
	}

	private String obtenerValorNoNulo(String valor) {
		return valor != null ? valor : "ND";
	}

	private void procesarLeyendaMosaico(GeneralesModel generales, Poliza polizas) {
		List<LeyendaMosaico> leyendaMosaico = polizas.getLeyendaMosaico();
		if (leyendaMosaico.isEmpty()) {
			if (polizas.getEmisor().equalsIgnoreCase("GMMC")) {
				generales.setEtiqueta(null);
				generales.setSumaAsegurada(null);
				generales.setSaldo(null);
			} else {
				generales.setEtiqueta("Saldo");
				generales.setSumaAsegurada("No disponible");
				generales.setSaldo("No disponible");
			}
		} else {
			String valorSaldo = leyendaMosaico.get(0).getValor();
			String etiqueta = leyendaMosaico.get(0).getEtiqueta();

			generales.setEtiqueta(etiqueta);
			if (valorSaldo == null || valorSaldo.equals("0") || valorSaldo.isEmpty()) {
				generales.setSumaAsegurada("$0.00");
				generales.setSaldo("$0.00");
			} else {
				String concat = "$" + valorSaldo + ".00";
				generales.setSumaAsegurada(concat);
				generales.setSaldo(concat);
			}
		}
	}

	private void armarDetalleDeSaldo(Poliza polizas) {
		DetalleDeSaldo detalleDeSaldoObj = new DetalleDeSaldo();
		detalleDeSaldoObj.armarGraficas(polizas.getFondo(),
				polizas.getEmisor() + "-" + polizas.getNumPoliza() + "-" + polizas.getIdRenovacion());
	}

	private void responsablePago(Poliza datosService, GeneralesModel generales) {
		ArrayList<ResponsablePago> responsablePago = datosService.getResponsablePago();

		if (responsablePago.isEmpty()) {
			generales.setFormaPago("No disponible");
		}

		ArrayList<DatosPago> arrResponsablePago = responsablePago.get(0).getDatosPago();
		if (arrResponsablePago.isEmpty()) {
			generales.setFormaPago("No disponible");
		} else {
			generales.setFormaPago(arrResponsablePago.get(0).getFormapago());
		}
	}

	private ArrayList<Asegurado> getAsegurados(Poliza poliza) {
		if (poliza != null) {
			ArrayList<Asegurado> asegurados = poliza.getAsegurado();
			ArrayList<Asegurado> arreglo = new ArrayList<>();

			for (int i = 0; i < asegurados.size(); i++) {
				Asegurado contenedor = new Asegurado();
				Asegurado aseguradosService = asegurados.get(i);
				String parentesco = aseguradosService.getParentesco();
				contenedor.setParentesco(parentesco);
				contenedor.setNombreAsegurado(aseguradosService.getNombreAsegurado());
				contenedor.setFechaFinVig(FormatosUtil.dateFormat(aseguradosService.getFechaFinVig()));
				contenedor.setFechaNacimiento(FormatosUtil.dateFormat(aseguradosService.getFechaNacimiento()));
				contenedor.setFechaAntiguedad(FormatosUtil.dateFormat(aseguradosService.getFechaAntiguedad()));
				contenedor.setMembresiaVRIM(aseguradosService.getMembresiaVRIM());
				contenedor.setTelemedicina(aseguradosService.getTelemedicina());
				contenedor.setSexoAsegurado(aseguradosService.getSexoAsegurado());

				boolean has = aseguradosService.getUsApp() != null;

				if (has) {
					if (parentesco.equals("TITULAR FEMENINO") || parentesco.equals("TITULAR MASCULINO")) {
						contenedor.setUsApp(aseguradosService.getUsApp());
					}
				}

				ArrayList<CoberturaAsegurado> coberturaAsegService = aseguradosService.getCoberturaAsegurado();
				ArrayList<CoberturaAsegurado> coberturaPorAsegurado = new ArrayList<>();

				if (coberturaAsegService.size() == 0) {
					contenedor.setCoberturaAsegurado(null);
				} else {
					for (int y = 0; y < coberturaAsegService.size(); y++) {

						CoberturaAsegurado datosCobAsegService = coberturaAsegService.get(y);
						CoberturaAsegurado coberturaNuevo = new CoberturaAsegurado();
						coberturaNuevo.setSumaAsegCob(datosCobAsegService.getSumaAsegCob());
						coberturaNuevo.setSumaAsegCobDesc(datosCobAsegService.getSumaAsegCobDesc());
						coberturaNuevo.setFechaFinVig(FormatosUtil.dateFormat(datosCobAsegService.getFechaFinVig()));
						coberturaNuevo.setDescCobertura(datosCobAsegService.getDescCobertura());
						coberturaNuevo.setFechaIniVig(FormatosUtil.dateFormat(datosCobAsegService.getFechaIniVig()));
//							coberturaNuevo.put("CodigoZona", datosCobAsegService.get("CodZona"));

						coberturaPorAsegurado.add(coberturaNuevo);
						contenedor.setCoberturaAsegurado(coberturaAsegService);
					}
				}

				arreglo.add(contenedor);
			}
			return arreglo;
		}
		return null;
	}

	private void getCoberturas(Poliza polizas, PolizaLimpiaModel polizaLimpia) {
		List<CoberturasModel> coberturas = new ArrayList<>();
		List<Coberturas> coberturasDePoliza = obtenerCoberturasDePoliza(polizas);
		List<CoberturasModel> coberturasAgrupadas = new ArrayList<>();

		if (!coberturasDePoliza.isEmpty()) {

			for (Coberturas coberturaActual : coberturasDePoliza) {
				int indice = obtenerIndiceZona(coberturasAgrupadas, coberturaActual.getDesGua());

				if (indice != -1) {
					coberturasAgrupadas.get(indice).getCoberturas().add(coberturaActual.getDesCobertura());
				} else {
					CoberturasModel nuevaZona = new CoberturasModel();
					nuevaZona.setNombreZona(coberturaActual.getDesGua());

					ArrayList<String> descripciones = new ArrayList<>();
					descripciones.add(coberturaActual.getDesCobertura());
					nuevaZona.setCoberturas(descripciones);

					coberturasAgrupadas.add(nuevaZona);
				}
			}

			// Eliminar duplicados en las coberturas por zona
			for (CoberturasModel zona : coberturasAgrupadas) {
				Set<String> sinDuplicados = new LinkedHashSet<>(zona.getCoberturas());
				zona.setCoberturas(new ArrayList<>(sinDuplicados));
				coberturas.add(zona); // Agregamos al resultado final
			}

			polizaLimpia.setCoberturas(coberturas);
			Gson gson = new Gson();
			String json = gson.toJson(polizaLimpia);
			log.info("PolizaLimpi {}", json);
		}
	}

	private ArrayList<Coberturas> obtenerCoberturasDePoliza(Poliza poliza) {
		if (poliza != null) {
			ArrayList<Coberturas> coberturas = poliza.getCobertura();
			return coberturas;
		}
		return null;
	}

	private int obtenerIndiceZona(List<CoberturasModel> coberturas, String zona) {
		for (int numeroZona = 0; numeroZona < coberturas.size(); numeroZona++) {
			if (coberturas.get(numeroZona).getNombreCobertura().equalsIgnoreCase(zona)) {
				return numeroZona;
			}
		}
		return -1;
	}

	private void getIntermediario(Poliza polizas, PolizaLimpiaModel polizaLimpia, String emisor) {
		List<Intermediario> intermediario = polizas.getIntermediario();

		if (intermediario != null && intermediario.size() > 0) {
			Intermediario intermediario0 = intermediario.get(0);
			if (intermediario0 != null) {
				polizaLimpia.setClaveAgente(intermediario0.getIdIntermediario());
			}
		}
		String urlFolleto = folletoProductoUtil.obtenerUrlFolleto(emisor);
		polizaLimpia.setUrlFolleto(urlFolleto);
	}

	private List<BienAsegurado> getBienesAsegurado(List<BienAsegurado> bienesAseguradoOrigen) {

		Map<String, List<CoberturaBien>> bienesAseguradosMap = new HashMap<>();
		List<BienAsegurado> bienesAseguradoDestino = new ArrayList<>();

		try {
			for (BienAsegurado bienAseguradoOrigen : bienesAseguradoOrigen) {
				String descripcion = bienAseguradoOrigen.getDescripcion();
				List<CoberturaBien> coberturasOrigen = new ArrayList<>();
				List<CoberturaBien> coberturas = new ArrayList<>();

				// Si ya existe el bien con esta descripción, solo agregamos la cobertura
				if (bienesAseguradosMap.containsKey(descripcion)) {
					coberturasOrigen = bienAseguradoOrigen.getCoberturaBien();
					coberturas = bienesAseguradosMap.get(descripcion);
				} else {
					coberturasOrigen = bienAseguradoOrigen.getCoberturaBien();
				}

				for (CoberturaBien coberturaOrigen : coberturasOrigen) {
					CoberturaBien coberturaDestino = new CoberturaBien();
					coberturaDestino.setDescCobert(coberturaOrigen.getDescCobert());
					coberturaDestino.setSumaAsegDesc(coberturaOrigen.getSumaAsegDesc());
					coberturaDestino.setFecIniValid(coberturaOrigen.getFecIniValid());
					coberturaDestino.setFecFinValid(coberturaOrigen.getFecFinValid());

					coberturas.add(coberturaDestino);

				}
			}

			// Convertimos el mapa en lista
			bienesAseguradosMap.forEach((descripcion, coberturas) -> {
				BienAsegurado bien = new BienAsegurado();
				bien.setDescripcion(descripcion);
				bien.setCoberturaBien(coberturas); // Asegúrate de que este setter acepte una lista
				bienesAseguradoDestino.add(bien);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bienesAseguradoDestino;
	}

	private List<InmuebleAseguradoDestino> getInmueblesasegurado(List<InmuebleAsegurado> inmueblesAseguradoOrigen) {
		List<InmuebleAseguradoDestino> inmueblesAseguradoDestino = new ArrayList<>();
		for (InmuebleAsegurado inmuebleAseguradoOrigen : inmueblesAseguradoOrigen) {
			InmuebleAseguradoDestino inmuebleAseguradoDestino = new InmuebleAseguradoDestino();
			if (inmuebleAseguradoOrigen != null) {
				String calle = inmuebleAseguradoOrigen.getCalle().toString();
				String numero = inmuebleAseguradoOrigen.getNumero().toString();
				String colonia = inmuebleAseguradoOrigen.getColonia().toString();
				String municipio = inmuebleAseguradoOrigen.getMunicipio().toString();
				String estado = inmuebleAseguradoOrigen.getEstado().toString();
				String codigoPostal = inmuebleAseguradoOrigen.getCodigoPostal().toString();

				String domicilio = String.format("%s, %s,  %s,  %s, %s, C.P. %s", calle, numero, colonia, municipio,
						estado, codigoPostal);

				inmuebleAseguradoDestino.setDomicilio(domicilio);
				List<CoberturaInmueble> coberturasDestino = new ArrayList<>();

				for (CoberturaInmueble coberturaOrigen : inmuebleAseguradoOrigen.getCoberturaInmueble()) {
					CoberturaInmueble coberturaDestino = new CoberturaInmueble();
					coberturaDestino.setDescCobert(coberturaOrigen.getDescCobert());
					coberturaDestino.setSumaAsegCobDesc(coberturaOrigen.getSumaAsegCobDesc());
					coberturaDestino.setFechaIniVig(FormatosUtil.dateFormat(coberturaOrigen.getFechaIniVig()));
					coberturaDestino.setFechaFinVig(FormatosUtil.dateFormat(coberturaOrigen.getFechaFinVig()));

					coberturasDestino.add(coberturaDestino);
				}

				inmuebleAseguradoDestino.setCoberturas(coberturasDestino);
				inmueblesAseguradoDestino.add(inmuebleAseguradoDestino);
			}
		}
		return inmueblesAseguradoDestino;
	}

}

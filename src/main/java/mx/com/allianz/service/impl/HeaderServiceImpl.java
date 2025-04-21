package mx.com.allianz.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

import io.micrometer.common.util.StringUtils;
import mx.com.allianz.cipher.service.Decrypt;
import mx.com.allianz.cipher.service.DecryptResponse;
import mx.com.allianz.client.SoapClient;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.config.ProductosConfiguration;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.config.WhatsappConfiguracion;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.exception.DataAccessException;
import mx.com.allianz.model.AlertasModel;
import mx.com.allianz.model.Asegurado;
import mx.com.allianz.model.Beneficiario;
import mx.com.allianz.model.BienAsegurado;
import mx.com.allianz.model.CoberturaAsegurado;
import mx.com.allianz.model.CoberturaBien;
import mx.com.allianz.model.CoberturaInmueble;
import mx.com.allianz.model.Coberturas;
import mx.com.allianz.model.CoberturasModel;
import mx.com.allianz.model.ContenidoModel;
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
import mx.com.allianz.model.NotificacionModel;
import mx.com.allianz.model.Pago;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.Poliza;
import mx.com.allianz.model.PolizaLimpiaModel;
import mx.com.allianz.model.PolizaModel;
import mx.com.allianz.model.Producto;
import mx.com.allianz.model.ProductosConfiguracionModel;
import mx.com.allianz.model.ProximosPagos;
import mx.com.allianz.model.ResponsablePago;
import mx.com.allianz.model.ResponseGenerica;
import mx.com.allianz.model.ResponseHeaderModel;
import mx.com.allianz.model.ResponsePolizaModel;
import mx.com.allianz.model.RespuestaPolizaModel;
import mx.com.allianz.model.Root;
import mx.com.allianz.model.Row;
import mx.com.allianz.model.TramitesObjecto;
import mx.com.allianz.model.Vigencias;
import mx.com.allianz.service.IHeaderService;
import mx.com.allianz.util.DetalleDeSaldo;
import mx.com.allianz.util.FiltradoAgenteUtil;
import mx.com.allianz.util.FolletoProductoUtil;
import mx.com.allianz.util.FormatosUtil;
import mx.com.allianz.util.GrupoDePolizasHardCode;
import mx.com.allianz.util.ImagenPerfilUtil;
import mx.com.allianz.util.NotificacionesImpl;
import mx.com.allianz.util.tramites.TramiteEntity;
import mx.com.allianz.util.tramites.TramitesDAO;
import mx.com.allianz.util.tramites.TramitesJSON;
import mx.com.allianz.util.tramites.TramitesUtility;
import mx.com.allianz.util.whatsapp.InformacionWhatsApp;
import mx.com.allianz.util.whatsapp.RespuestaWhatsApp;
import mx.com.allianz.util.whatsapp.ValidadorWhatsApp;
import mx.com.allianz.whatsap.model.WhatsapModel;

@Service
public class HeaderServiceImpl implements IHeaderService {
	private static final Logger log = LoggerFactory.getLogger(SiniestroServiceImpl.class);

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	@Autowired
	private WhatsappConfiguracion whatsappConfiguracion;

	@Autowired
	private ProductosConfiguration productosConfiguration;

	@Autowired
	private GrupoDePolizasHardCode grupoDePolizasHardCode;

	@Autowired
	private FolletoProductoUtil folletoProductoUtil;

	@Autowired
	private NotificacionesImpl notificacionImpl;

	@Autowired
	private FiltradoAgenteUtil filtradoUtil;

	@Autowired
	private DetalleDeSaldo detalleDeSaldoObj;

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
	public ResponsePolizaModel procesarHeader(ParametroRequestModel request) throws BusinessException {
		log.info("Entro metodo procesarHeader");
		ResponseHeaderModel responseHeader = new ResponseHeaderModel();
		try {
			String urlDecript = decryptRequest(request.getParametro());
			String[] parametrosArreglo = extractParameters(urlDecript);

			String idUsuario = extractIdUsuario(parametrosArreglo[0]);
			String emailURL = extractParameterValue(parametrosArreglo, 3);

			// Extraer parámetros de la URL desencriptada

			String parValor = parametrosArreglo[0];
			int separador = parValor.lastIndexOf("=");

			if (separador > 0) {
				idUsuario = parValor.substring(3);
			}

			List<LDAPResponse> ldapClientes = isLDAPClientes(emailURL);
			log.info("ldapClientes " + ldapClientes);
			String codCliente = Optional.ofNullable(exitsLDAPClientes(ldapClientes)).orElse(idUsuario);

			Map<String, String> clienteInfo = isContratante(codCliente);
			boolean isContratante = "s".equalsIgnoreCase(clienteInfo.get("isContratante"));
			String codCliIntegrador = clienteInfo.get("codCliIntegrador");

			String idAgente = urlDecript.contains("idAgente") ? extractParameterValue(parametrosArreglo, 5) : null;
			String codeSend = codCliIntegrador != null && !codCliIntegrador.isEmpty() ? codCliIntegrador : codCliente;

			responseHeader.setCodCliIntegrador(codeSend);
			responseHeader.setIsContratante(isContratante);
			return getPolizas(codeSend, idAgente, isContratante, emailURL);

//			return new RespuestaGenerica(true, "OK", responseHeader);
		} catch (Exception e) {
			log.error("Error al procesar el header: {}", e.getMessage(), e);
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}
	}

	private String extractIdUsuario(String parametro) {
		log.info("Entro metodo extractIdUsuario");
		int separador = parametro.lastIndexOf("=");
		return separador > 0 ? parametro.substring(3) : "";
	}

	private String extractParameterValue(String[] parametros, int index) {
		log.info("Entro metodo extractParameterValue");
		if (index < parametros.length && parametros[index].contains("=")) {
			return parametros[index].split("=")[1];
		}
		return "";
	}

	public List<LDAPResponse> isLDAPClientes(String correoCliente) {
		log.info("Entro metodo isLDAPClientes {}", correoCliente);
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
		log.info("Entro metodo exitsLDAPClientes {}", ldapClientes.get(0).getEmail());
		// Asegúrate de que la lista no sea nula y tenga al menos un elemento
		if (ldapClientes == null || ldapClientes.isEmpty()) {
			return null;
		}

		// Verifica si el primer elemento tiene un cveCliente no vacío
		String cveCliente = ldapClientes.get(0).getCveCliente();
		return (cveCliente != null && !cveCliente.isEmpty()) ? cveCliente : null;
	}

	public Map<String, String> isContratante(String idCliente) {
		log.info("Método isContratante llamado con idCliente: {}", idCliente);

		// Mapa de respuesta
		Map<String, String> responseMap = new HashMap<>();

		// Variables locales
		String esContratante = "N"; // Valor por defecto
		String codCliIntegrador = ""; // Inicializar con valor vacío

		try {

			// Construir la URL con el idCliente
			String urlServicio = String.format(servicesConfiguration.getSecurityLoginContratante(), idCliente);
			log.info("Invocando servicio: {}", urlServicio);

			// Crear los encabezados para la solicitud
			HttpHeaders headers = createHeaders();
			// Configuración de la solicitud con los headers
			HttpEntity<String> entity = new HttpEntity<>(headers);

			// Llamar al servicio y mapear la respuesta a ResponseGenerica
			ResponseEntity<ResponseGenerica> responseEntity = restTemplate.exchange(urlServicio, HttpMethod.GET, entity,
					ResponseGenerica.class);

			// Obtener la respuesta y acceder a "esContratante"
			ResponseGenerica respuestaGenerica = responseEntity.getBody();

			if (respuestaGenerica == null || !respuestaGenerica.isExitoso()) {
				log.warn("Respuesta del servicio es nula o no exitosa.");
				putResponseDefaults(responseMap, esContratante, codCliIntegrador);
				return responseMap;
			}

			TipoCliente tipoCliente = Optional.ofNullable(respuestaGenerica.getContenido())
					.map(ContenidoModel::getTipoCliente).orElse(null);

			if (tipoCliente == null) {
				log.warn("El objeto tipoCliente está vacío.");
				putResponseDefaults(responseMap, esContratante, codCliIntegrador);
				return responseMap;
			}

			esContratante = Optional.ofNullable(tipoCliente.getEsContratante()).orElse("N");
			codCliIntegrador = "N".equalsIgnoreCase(esContratante) ? tipoCliente.getCodCli()
					: tipoCliente.getCodCliIntegrador();

			log.info("Resultado del servicio isContratante -> esContratante: {}, codCliIntegrador: {}", esContratante,
					codCliIntegrador);

		} catch (HttpClientErrorException | HttpServerErrorException httpEx) {
			log.error("Error HTTP al invocar el servicio isContratante: {}", httpEx.getMessage(), httpEx);
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		} catch (Exception ex) {
			log.error("Error inesperado al procesar isContratante: {}", ex.getMessage(), ex);
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}

		putResponseDefaults(responseMap, esContratante, codCliIntegrador);
		return responseMap;
	}

	private void putResponseDefaults(Map<String, String> responseMap, String esContratante, String codCliIntegrador) {
		responseMap.put("isContratante", esContratante != null ? esContratante : "N");
		responseMap.put("codCliIntegrador", codCliIntegrador != null ? codCliIntegrador : "");
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

	private ResponsePolizaModel getPolizas(String idCliente, String idAgente, boolean isContratante, String mail) {
		log.info("Metodo getPolizas idCliente: {}, mail: {}", idCliente, mail);
		try {
			String servicioWeb = construirUrlPolizas(idCliente, isContratante, mail);
			boolean esContratante = isContratante;
			Root servicesAllianzPoliza = getServicesAllianzPoliza(servicioWeb);

			ResponsePolizaModel resultadoPolizas = resultadoPolizas(servicesAllianzPoliza.getRows(), esContratante,
					idAgente, mail, idCliente);
			log.info("Respuesta del servicio de pólizas: {}", resultadoPolizas);
			return resultadoPolizas;
		} catch (Exception e) {
			log.error("Error al obtener pólizas: {}", e.getMessage(), e);
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}
	}

	private String construirUrlPolizas(String idCliente, boolean isContratante, String mail) {
		log.info("Metodo construirUrlPolizas");
		String baseUrl = servicesConfiguration.getServicioPolizas();

		if (isContratante) {
			// Si es contratante, buscar por idCliente
			return String.format(baseUrl, "$text", "$search\":\"" + idCliente + "\"");
		} else {
			// Si no es contratante
			if ("USER".equalsIgnoreCase(mail)) {
				return String.format(baseUrl, "$text", "$search\":\"" + idCliente + "\"");
			} else {
				return String.format(baseUrl, "\"Contratante.UsApp\"", "\"" + mail + "\"");
			}
		}
	}

	public Root getServicesAllianzPoliza(String url) {
		log.info("Metodo getServicesAllianzPoliza {} ", url);
		try {
			String encodedAuth = encodedAuth();

			// Codificar parámetro "where" si es necesario
			url = encodeWhereParamIfNeeded(url);

			URI uri = new URI(url);
			URL urlWeb = uri.toURL();

			HttpURLConnection connection = (HttpURLConnection) urlWeb.openConnection();
			connection.setRequestProperty("Authorization", "Basic " + encodedAuth);

			int status = connection.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {
				try (InputStream is = connection.getInputStream()) {
					// Deserializar directamente desde el InputStream
					ObjectMapper mapper = new ObjectMapper();
					return mapper.readValue(is, Root.class);
				} catch (IOException e) {
					log.error("Error al deserializar la respuesta JSON: {}", e.getMessage(), e);
					throw new BusinessException(codes.getResponseCode("IGBL002"));
				}
			} else {
				log.error("Solicitud fallida. Código HTTP: {}", status);
				throw new BusinessException(codes.getResponseCode("IGBL003")); // Código HTTP no esperado
			}
		} catch (IOException | URISyntaxException e) {
			log.error("Error en la conexión o formato de URL: {}", e.getMessage(), e);
			throw new BusinessException(codes.getResponseCode("IGBL001")); // Error genérico
		}
	}

	private ResponsePolizaModel resultadoPolizas(ArrayList<Row> rows, boolean isContra, String idAgente, String mail,
			String idCliente) {

		log.info("Metodo resultadoPolizas");
		if (rows == null || rows.isEmpty()) {
			log.warn("La lista de rows está vacía o es nula.");
			throw new BusinessException(codes.getResponseCode("IGBL004"));
		}
		try {
			List<Poliza> dataService = null;
			for (Row row : rows) {
				Contratante contratante = row.getContratante();
				String esContratante = contratante != null ? contratante.getEsContratante() : null;

				log.debug("Contratante encontrado con estado: {}", esContratante);

				if ("S".equalsIgnoreCase(esContratante)) {
					dataService = row.getPolizas();
					break;
				}
			}

			if (dataService != null && !dataService.isEmpty()) {
				log.info("Polizas encontradas para contratante válido: {}", dataService.size());
				return procesarPolizas(rows, isContra, idAgente, mail, idCliente);
			} else {
				log.warn("No se encontraron pólizas para ningún contratante válido.");
			}

		} catch (Exception e) {
			log.error("Error al procesar resultadoPolizas: {}", e.getMessage(), e);
			throw new BusinessException(codes.getResponseCode("IGBL004"));
		}
		return null;

	}

	public ResponsePolizaModel procesarPolizas(ArrayList<Row> rows, boolean isContra, String idAgente, String mail,
			String idCliente) {
		log.info("Metodo procesarPolizas");
		List<PolizaModel> poliza = new ArrayList<>();
		ResponsePolizaModel responsePoliza = new ResponsePolizaModel();
		RespuestaPolizaModel respuesta = new RespuestaPolizaModel();
		try {

			if (rows == null || rows.isEmpty()) {
				log.warn("No se encontraron datos en la lista de rows.");
				responsePoliza.setEstatus(false);
				responsePoliza.setMensaje("No se encontraron datos.");
				return responsePoliza;
			}

			// Buscar contratante con EsContratante = "S" o usar el primero
			Row dataService = rows.stream().filter(row -> row.getContratante() != null)
					.filter(row -> "S".equalsIgnoreCase(row.getContratante().getEsContratante())).findFirst()
					.orElse(rows.get(0));

			Contratante contratante = dataService.getContratante();
			if (contratante == null) {
				log.warn("No se encontró información del contratante en el registro seleccionado.");
				responsePoliza.setEstatus(false);
				responsePoliza.setMensaje("No se encontró información del contratante.");
				return responsePoliza;
			}

			// Datos básicos del contratante

			responsePoliza.setEstatus(true);
			responsePoliza.setMensaje("JSON Consumido correctamente");
			responsePoliza.setIdClientePoliza(contratante.getIdCliente());
			responsePoliza.setRfc(contratante.getrFC());

			String nombre = Optional.ofNullable(contratante.getNombre()).orElse(contratante.getNombreCompleto());
			String tipoPersona = contratante.getTipoPersona();
			responsePoliza.setNombre(nombre);
			responsePoliza.setTipoPersona(tipoPersona);

			String apellidoP = "";
			String apellidoM = "";

			if ("FISICA".equalsIgnoreCase(tipoPersona)) {
				apellidoP = contratante.getApellidoPaterno();
				apellidoM = contratante.getApellidoMaterno();
			}

			responsePoliza.setApellidoP(apellidoP);
			responsePoliza.setApellidoM(apellidoM);

			GeneralesModel generales = procesaModelGeneral(contratante, nombre, apellidoP, apellidoM, isContra,
					dataService);

			poliza = searchPolizas(dataService, contratante.getIdCliente(), contratante, idAgente, respuesta);

			List<String> idepoliciesTitular = new ArrayList<String>();
			List<String> idepolicies = new ArrayList<String>();
			List<PolizaModel> polizaTitularTemp = new ArrayList<>();
			List<PolizaModel> polizaTemp = new ArrayList<>();
			List<PolizaModel> polizaTempLimpioFinal = new ArrayList<>();

			for (PolizaModel pol : poliza) {
				String idepol = pol.getPoliza().getGenerales().getIDEPOL();

				if (!idepolicies.contains(idepol)) {
					idepolicies.add(idepol);
					polizaTemp.add(pol);
				}

				if (esTitular(pol, mail) && !idepoliciesTitular.contains(idepol)) {
					idepoliciesTitular.add(idepol);
					polizaTitularTemp.add(pol);
				}

			}

			// Agregar pólizas del titular al resultado final
			for (PolizaModel pol : polizaTitularTemp) {
				String idepol = pol.getPoliza().getGenerales().getIDEPOL();
				if (idepoliciesTitular.contains(idepol)) {
					polizaTempLimpioFinal.add(pol);
				}
			}

			// Agregar pólizas no titular al resultado final
			for (PolizaModel pol : polizaTemp) {
				String idepol = pol.getPoliza().getGenerales().getIDEPOL();
				if (!idepoliciesTitular.contains(idepol)) {
					polizaTempLimpioFinal.add(pol);
				}
			}

			poliza = polizaTempLimpioFinal;
			log.info("PolizaLimpioFina {}", poliza);
			String esContratantee = contratante.getEsContratante();
			log.info("{}", detalleDeSaldoObj.getJsonDetalleDeSaldo());
			responsePoliza.setDetalleSaldo(detalleDeSaldoObj);

			try {
				List<AlertasModel> notificacionesService = dataService.getAlertas();
				List<NotificacionModel> obtenerNotificaciones = obtenerNotificaciones(notificacionesService);
				responsePoliza.setNotificaciones(obtenerNotificaciones);
			} catch (Exception e) {
				List<NotificacionModel> notificaciones = new ArrayList<>();
				NotificacionModel notifi = new NotificacionModel();
				notifi.setDescripcion("No hay notificaciones disponibles.");
				notifi.setEstatus("1");
				notificaciones.add(notifi);
				responsePoliza.setNotificaciones(notificaciones);
			}

			List<ProximosPagos> proximosPagos = dataService.getProximosPagos();
			responsePoliza.setProximosPagos(obtenerProximosPagos(proximosPagos, polizaTempLimpioFinal, idAgente));
			responsePoliza.setGenerales(generales);
			responsePoliza.setPoliza(poliza);
			responsePoliza.setEsContratante(esContratantee);
			responsePoliza.setObtenerJsonFamiliasParaLaRuleta(grupoDePolizasHardCode.obtenerJsonFamiliasParaLaRuleta());
			responsePoliza.setVigencias(getVigenciasPoliza(idCliente, rows, idAgente));
			String urlConsultarTramites = servicesConfiguration.getUrlConsultarTramites();
			TramitesObjecto obtenerTramites = obtenerTramites(poliza, urlConsultarTramites);
			if (obtenerTramites != null) {
				responsePoliza.setTramites(obtenerTramites);
			}

			ValidadorWhatsApp validadoWhatsApp = new ValidadorWhatsApp();
			String productos = whatsappConfiguracion.getWhatsappProductos();
			String api = whatsappConfiguracion.getWhatsappApi();
			String contacto = whatsappConfiguracion.getWhatsappNumero();
			InformacionWhatsApp info = validadoWhatsApp.obtenerInformacionWhatsApp(poliza, productos, api, contacto);
			WhatsapModel whatsApp = new RespuestaWhatsApp().obtenerRespuestaParaWhatsApp(info);
			if (whatsApp != null) {
				responsePoliza.setInfoWhatsApp(whatsApp);
			}

			log.info("Pólizas procesadas: {}", new Gson().toJson(responsePoliza));

		} catch (Exception e) {
			log.error("Error al procesar pólizas: {}", e.getMessage(), e);
			responsePoliza.setEstatus(false);
			responsePoliza.setMensaje("Ocurrió un error al procesar las pólizas.");
		}

		return responsePoliza;
	}

	private GeneralesModel procesaModelGeneral(Contratante contratante, String nombre, String apellidoP,
			String apellidoM, boolean isContra, Row dataService) {
		log.info("Metodo procesaModelGeneral");
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

	private List<PolizaModel> searchPolizas(Row rows, String idClientePoliza, Contratante contratante, String idAgente,
			RespuestaPolizaModel respuesta) {
		log.info("Metodo searchPolizas");
		String productosVisiblesPortal = productosConfiguration.getProductosVisiblesPortal();
		String[] polInhabilesArray = productosVisiblesPortal.isEmpty() ? null : productosVisiblesPortal.split(",");
		PolizaModel procesarPoliza = new PolizaModel();

		try {
			if (rows == null) {
				throw new DataAccessException(codes.getResponseCode("IGBL004"));
			}

			ArrayList<Poliza> polizas = rows.getPolizas();
			if (rows.getPolizasGMMAsegurado() != null) {
				addGMMAseguradosToPolizas(rows, polizas);
			}

			List<PolizaModel> polizasLimpias = new ArrayList<>();

			for (Poliza poliza : polizas) {
				PolizaLimpiaModel polizaLimpia = new PolizaLimpiaModel();
				GeneralesModel generales = new GeneralesModel();
				if (isPolizaInhabiles(poliza, polInhabilesArray)) {
					procesarPoliza = procesarPoliza(poliza, respuesta, generales, polizaLimpia, contratante);
					polizasLimpias.add(procesarPoliza);
				}
			}

			return ordenarPolizas(polizasLimpias);

		} catch (Exception e) {
			log.error("Exception {}", e);
		}
		return null;
	}

	private void addGMMAseguradosToPolizas(Row rows, ArrayList<Poliza> polizas) {
		log.info("Metodo addGMMAseguradosToPolizas");
		for (Object o : rows.getPolizasGMMAsegurado()) {
			if (o instanceof Poliza) {
				polizas.add((Poliza) o);
			}
		}
	}

	private boolean isPolizaInhabiles(Poliza poliza, String[] polInhabilesArray) {
		log.info("Metodo isPolizaInhabiles");
		if (polInhabilesArray == null)
			return false;
		String emisor = poliza.getEmisor();
		return Arrays.asList(polInhabilesArray).contains(emisor);
	}

	private PolizaModel procesarPoliza(Poliza poliza, RespuestaPolizaModel respuesta, GeneralesModel generales,
			PolizaLimpiaModel polizaLimpia, Contratante contratante) {
		log.info("Metodo procesarPoliza");
		try {
			if (poliza == null) {
				log.warn("El objeto póliza es requeridos es nulo. poliza: {}, contratante: {}", poliza, contratante);
			}
			String emisor = Optional.ofNullable(poliza.getEmisor()).orElse("");
			boolean mostrarPoliza = "S".equalsIgnoreCase(poliza.getMostrarPolizaAgente());

			procesarGeneralesEmpresarial(respuesta, poliza, contratante, generales);
			procesarDatosProductos(generales, poliza);
			procesarLeyendaMosaico(generales, poliza);
			responsablePago(poliza, generales);

			polizaLimpia.setCodCondGen(poliza.getCodCondGen());
			if (poliza.getFondo() != null && !poliza.getFondo().isEmpty()) {
				armarDetalleDeSaldo(poliza);
			}

			if (poliza.getVehiculo() != null && !poliza.getVehiculo().isEmpty()) {
				polizaLimpia.setVehiculo(poliza.getVehiculo());
			}

			// Datos Generales
			generales.setFamiliaPoliza(emisor);
			generales.setCodMoneda(poliza.getCodMoneda());
			generales.setFechaTerminoVigencia(FormatosUtil.dateFormat(poliza.getFecFinVig()));
			generales.setCaratulaPoliza("https://projects.invisionapp.com/share/3E9AVYBV9#/screens/204561721");
			generales.setIDEPOL(Optional.ofNullable(poliza.getiDEPOL()).orElse(""));

			// Información personal
			InformacionPersonalModel informacionPersona = buildInformacionPersonal(poliza, contratante, polizaLimpia);
			polizaLimpia.setInformacionPersonal(informacionPersona);

			// Familia y color
			String familia = grupoDePolizasHardCode.setFamilia(emisor, obtenerTodosLosProductos());
			polizaLimpia.setFamiliaColor(familia);
			polizaLimpia.setGenerales(generales);

			// Agregados por familia
			if (!isExcludedEmisor(emisor)) {
				handleAdditionalPolicyDetails(poliza, polizaLimpia, emisor);
			}

			// Beneficiarios
			polizaLimpia.setBeneficiarios(getBeneficiario(poliza.getBeneficiario()));

			return getIdAgente(familia, mostrarPoliza, polizaLimpia);

		} catch (Exception ex) {
			log.error("Error al procesar la póliza: {}", ex.getMessage(), ex);
		}
		return null;
	}

	private InformacionPersonalModel buildInformacionPersonal(Poliza poliza, Contratante contratante,
			PolizaLimpiaModel polizaLimpia) {
		log.info("Metodo buildInformacionPersonal");
		InformacionPersonalModel informacionPersona = new InformacionPersonalModel();
		Contratante contratanteService = getContratanteService(poliza, contratante);

		String nombre = contratanteService.getNombre();
		String apellidoP = contratanteService.getApellidoPaterno();
		String apellidoM = contratanteService.getApellidoMaterno();
		Contratante contratanteL = new Contratante();

		contratanteL.setNombre(nombre + " " + apellidoP + " " + apellidoM);
		contratanteL.setDomicilioCompleto(
				contratanteService.getDomicilioCompleto().replace("\"", "&#34;").replace("\'", "&#39;"));
		contratanteL.setTelParticular(contratanteService.getTelParticular());
		contratanteL.setEmail(contratanteService.getEmail());
		contratanteL.setrFC(contratanteService.getrFC());
		contratanteL.setApellidos(apellidoP + " " + apellidoM);
		contratanteL.setNombre(nombre);

		polizaLimpia.setContratante(contratanteL);

		informacionPersona.setClienteDesde(FormatosUtil.dateFormat(contratanteService.getFechaAntiguedad()));
		informacionPersona.setNotificaciones("");
		informacionPersona.setNombreCliente(nombre + " " + apellidoP + " " + apellidoM);

		return informacionPersona;
	}

	private Contratante getContratanteService(Poliza poliza, Contratante contratante) {
		log.info("Metodo getContratanteService");
		if (!poliza.getContratante().isEmpty()) {
			return poliza.getContratante().get(0).getContratante();
		}
		return contratante;
	}

	private boolean isExcludedEmisor(String emisor) {
		log.info("Metodo isExcludedEmisor emiso: {}", emisor);
		return "ACTD".equals(emisor) || "ACTM".equals(emisor);
	}

	private void handleAdditionalPolicyDetails(Poliza poliza, PolizaLimpiaModel polizaLimpia, String emisor) {
		log.info("Metodo handleAdditionalPolicyDetails");
		polizaLimpia.setAsegurados(getAsegurados(poliza));
		log.info("JSON POLIZA LIMPIA {}", new Gson().toJson(polizaLimpia));
		getCoberturas(poliza, polizaLimpia);
		getIntermediario(poliza, polizaLimpia, emisor);
		polizaLimpia.setBienesAsegurado(getBienesAsegurado(poliza.getBienAsegurado()));

		List<InmuebleAseguradoDestino> inmueblesasegurado = getInmueblesasegurado(poliza.getInmuebleAsegurado());
		polizaLimpia.setInmueblesAsegurado(inmueblesasegurado);

		String obtenerColor = grupoDePolizasHardCode.obtenerColor(emisor, obtenerTodosLosProductos());
		if (obtenerColor != null) {
			polizaLimpia.setColorEmisor(obtenerColor);
		}
	}

	private List<Producto> obtenerTodosLosProductos() {
		log.info("Metodo obtenerTodosLosProductos");
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
		log.info("Metodo procesarDatosProductos");
		generales.setEsContratante(
				polizas.getEsContratante() != null && polizas.getEsContratante().equals("S") ? true : false);
		generales.setFolletoProducto("https://projects.invisionapp.com/share/3E9AVYBV9#/screens/204561721");
		generales.setNumeroPoliza(polizas.getEmisor() + "-" + polizas.getNumPoliza() + "-" + polizas.getIdRenovacion());
		generales.setEstatus(polizas.getEstatusPoliza());
		generales.setTipoPoliza(polizas.getEmisor() + polizas.getNumPoliza());
		generales.setFechaInicioVigencia(FormatosUtil.dateFormat(polizas.getFecIniVig()));
		generales.setFechaEmision(FormatosUtil.dateFormat(polizas.getFechaEmision()));

	}

	private void procesarGeneralesEmpresarial(RespuestaPolizaModel respuesta, Poliza polizas, Contratante contratante,
			GeneralesModel generales) {
		log.info("Metodo procesarGeneralesEmpresarial");
		// Check if the emitter is GMMC or GMMM
		if (isEmisorGMMCOrGMMM(polizas)) {
			GeneralesEmpresarialModel generalesEmpresarial = obtenerGeneralesEmpresariales(polizas);
			respuesta.setGeneralesEmpresarial(generalesEmpresarial);
		}

	}

	private boolean isEmisorGMMCOrGMMM(Poliza polizas) {
		log.info("Metodo isEmisorGMMCOrGMMM emisor {}", polizas.getEmisor());
		return polizas.getEmisor().equalsIgnoreCase("GMMC") || polizas.getEmisor().equalsIgnoreCase("GMMM");
	}

	private GeneralesEmpresarialModel obtenerGeneralesEmpresariales(Poliza polizas) {
		log.info("Metodo obtenerGeneralesEmpresariales");
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
		log.info("Metodo obtenerValorNoNulo valor: {}", valor);
		return valor != null ? valor : "ND";
	}

	private void procesarLeyendaMosaico(GeneralesModel generales, Poliza polizas) {
		log.info("Metodo procesarLeyendaMosaico");
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
				generales.setSumaAsegurada(valorSaldo);
				generales.setSaldo(valorSaldo);
			}
		}
	}

	private void armarDetalleDeSaldo(Poliza polizas) {
		log.info("Metodo armarDetalleDeSaldo");
		detalleDeSaldoObj.armarGraficas(polizas.getFondo(),
				polizas.getEmisor() + "-" + polizas.getNumPoliza() + "-" + polizas.getIdRenovacion());
	}

	private void responsablePago(Poliza datosService, GeneralesModel generales) {
		log.info("Metodo responsablePago");
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
		log.info("Metodo getAsegurados");
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
		log.info("Metodo getCoberturas");
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
		log.info("Metodo obtenerCoberturasDePoliza");
		if (poliza != null) {
			ArrayList<Coberturas> coberturas = poliza.getCobertura();
			return coberturas;
		}
		return null;
	}

	private int obtenerIndiceZona(List<CoberturasModel> coberturas, String zona) {
		log.info("Metodo obtenerIndiceZona");
		for (int numeroZona = 0; numeroZona < coberturas.size(); numeroZona++) {
			if (coberturas.get(numeroZona).getNombreCobertura().equalsIgnoreCase(zona)) {
				return numeroZona;
			}
		}
		return -1;
	}

	private void getIntermediario(Poliza polizas, PolizaLimpiaModel polizaLimpia, String emisor) {
		log.info("Metodo getIntermediario");
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
		log.info("Metodo getBienesAsegurado");
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
		log.info("Metodo getInmueblesasegurado");
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

	private List<Beneficiario> getBeneficiario(List<Beneficiario> beneficiarioPorPoliza) {
		log.info("Metodo getBeneficiario");
		List<Beneficiario> listaBeneficiarios = new ArrayList<>();

		if (!beneficiarioPorPoliza.isEmpty()) {
			for (Beneficiario beneficiarioItem : beneficiarioPorPoliza) {
				Beneficiario beneficiario = createBeneficiario(beneficiarioItem);
				listaBeneficiarios.add(beneficiario);
			}
		} else {
			// Si la lista está vacía, agregar un beneficiario vacío
			listaBeneficiarios.add(createEmptyBeneficiario());
		}

		return listaBeneficiarios;
	}

	private Beneficiario createBeneficiario(Beneficiario beneficiarioItem) {
		log.info("Metodo createBeneficiario");
		Beneficiario beneficiario = new Beneficiario();

		beneficiario.setNombreBeneficiario(beneficiarioItem.getNombreBeneficiario());
		beneficiario.setParentesco(getParentesco(beneficiarioItem));
		beneficiario.setPorcentaje(getPorcentaje(beneficiarioItem));

		return beneficiario;
	}

	private String getParentesco(Beneficiario beneficiarioItem) {
		log.info("Metodo getParentesco");
		String parentesco = beneficiarioItem.getParentesco();
		return StringUtils.isEmpty(parentesco) ? "PARENTESCO" : parentesco;
	}

	private String getPorcentaje(Beneficiario beneficiarioItem) {
		log.info("Metodo getPorcentaje");
		String porcentaje = beneficiarioItem.getPorcentaje(); // Now a double
		if (StringUtils.isEmpty(porcentaje)) {
			return "PORCENTAJE";
		} else {
			return formatPorcentaje(String.valueOf(porcentaje)); // Convert double to String
		}
	}

	private String formatPorcentaje(String porcentaje) {
		log.info("Metodo formatPorcentaje {}", porcentaje);
		try {
			double porcentajeDouble = Double.parseDouble(porcentaje);
			return new DecimalFormat("#,###").format(porcentajeDouble) + " %";
		} catch (NumberFormatException e) {
			// Manejo de errores si el porcentaje no se puede convertir a Double
			return "PORCENTAJE";
		}
	}

	private Beneficiario createEmptyBeneficiario() {
		log.info("Metodo createEmptyBeneficiario ");
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setNombreBeneficiario(""); // O lo que sea necesario por defecto
		beneficiario.setParentesco("PARENTESCO");
		beneficiario.setPorcentaje("PORCENTAJE");
		return beneficiario;
	}

	private PolizaModel getIdAgente(String idAgente, boolean mostrarPoliza, PolizaLimpiaModel polizaLimpia) {
		log.info("Metodo procesarPoliza");
		PolizaModel poliza = new PolizaModel();
		poliza.setPoliza(polizaLimpia);
		if (idAgente != null && idAgente.length() > 0 && TramitesUtility.esNumerico(idAgente)) {
			if (mostrarPoliza) {
				idAgente = (idAgente.length() == 8) ? idAgente.substring(2, idAgente.length()) : idAgente;
				String idAgentePoliza = polizaLimpia.getClaveAgente();
				idAgentePoliza = (idAgentePoliza.length() == 8) ? idAgentePoliza.substring(2, idAgentePoliza.length())
						: idAgentePoliza;
				if (idAgente.equalsIgnoreCase(idAgentePoliza)) {
					return poliza;
				}
			}
		} else {
			return poliza;
		}
		return poliza;

	}

	public List<PolizaModel> ordenarPolizas(List<PolizaModel> polizas) {
		log.info("Metodo ordenarPolizas");
		// Creamos una lista para ordenar las pólizas
		List<PolizaModel> polizasOrdenadas = new ArrayList<>(polizas);

		// Ordenamos la lista con un comparator personalizado
		Collections.sort(polizasOrdenadas, new Comparator<PolizaModel>() {
			@Override
			public int compare(PolizaModel a, PolizaModel b) {
				String valA = a.getPoliza().getGenerales().getNumeroPoliza();
				String valB = b.getPoliza().getGenerales().getNumeroPoliza();

				// Dividimos el número de póliza para compararlo en varias partes
				String[] polizaA = valA.split("-");
				String[] polizaB = valB.split("-");

				// Comparamos primero la parte del año
				int resultado = polizaA[0].compareToIgnoreCase(polizaB[0]);
				if (resultado != 0) {
					return resultado;
				}
				// Si el año es el mismo, comparamos la segunda parte (número)
				resultado = Integer.compare(Integer.parseInt(polizaA[1]), Integer.parseInt(polizaB[1]));
				if (resultado != 0) {
					return resultado;
				}
				// Si también coinciden, comparamos la última parte
				return polizaA[2].compareTo(polizaB[2]);
			}
		});

		// Asignamos el orden a las pólizas
		for (int i = 0; i < polizasOrdenadas.size(); i++) {
			PolizaModel poliza = polizasOrdenadas.get(i);
			// Suponemos que `setOrden` es un método de PolizaLimpiaModel para almacenar el
			// orden
			poliza.setOrden(i + 1);
		}
		log.info("procesarPoliza --> {}", new Gson().toJson(polizasOrdenadas));
		// Retornamos la lista ordenada
		return polizasOrdenadas;
	}

	private String encodeWhereParamIfNeeded(String url) throws UnsupportedEncodingException {
		log.info("Metodo encodeWhereParamIfNeeded url: {}", url);
		if (!url.contains("where=")) {
			return url;
		}

		int whereIndex = url.indexOf("where=");
		String queryString = url.substring(whereIndex + 6); // after 'where='

		String encodedQuery = URLEncoder.encode(queryString, StandardCharsets.UTF_8.toString());

		return url.substring(0, whereIndex + 6) + encodedQuery;
	}

	private boolean esTitular(PolizaModel poliza, String mail) {
		for (Asegurado asegurado : poliza.getPoliza().getAsegurados()) {
			if (asegurado.getUsApp() != null && asegurado.getUsApp().equals(mail)) {
				return true;
			}
		}
		return false;
	}

	private List<NotificacionModel> obtenerNotificaciones(List<AlertasModel> alertas) {
		List<NotificacionModel> notificacionesConFormato = new ArrayList<>();

		// Recorremos las alertas usando un for-each
		for (AlertasModel alerta : alertas) {
			NotificacionModel notificacion = new NotificacionModel();

			// Establecer descripción
			String msg = String.format("%s - %s", FormatosUtil.dateFormat(alerta.getFechaAlerta()),
					alerta.getEstatus());
			notificacion.setDescripcion(msg);

			// Establecer ID de notificación y comprobar su existencia
			int idNotificacion = Integer.parseInt(alerta.getId());
			boolean notificacionExiste = notificacionImpl.encontrarNotificacion(idNotificacion);

			// No ha sido vista o es persistente
			if (!notificacionExiste || "S".equals(alerta.getPersistencia())) {
				// Asignar estatus basado en si la notificación ha sido vista
				notificacion.setEstatus(notificacionExiste ? "1" : "0");

				// Formatear la fecha
				String fechaFormateada = formatearFecha(alerta.getFechaAlerta());
				notificacion.setFecha(fechaFormateada);

				// Asignar identificación de la notificación
				notificacion.setNotificacion(alerta.getProducto() + "-" + alerta.getNumPoliza());

				// Agregar a la lista
				notificacionesConFormato.add(notificacion);
			}
		}
		return notificacionesConFormato;
	}

	/**
	 * Método para formatear la fecha de la alerta en formato yyyyMMdd.
	 * 
	 * @param fechaStr Fecha en formato String.
	 * @return Fecha formateada en el formato 'yyyyMMdd'.
	 */
	private String formatearFecha(String fechaStr) {
		String[] splitFecha = fechaStr.split("/");
		return splitFecha[2] + splitFecha[1] + splitFecha[0]; // Formato: "yyyyMMdd"
	}

	private List<Pago> obtenerProximosPagos(List<ProximosPagos> proximosPagos, List<PolizaModel> poliza,
			String idAgente) {
		List<Pago> jsonArrayProximosPagos = new ArrayList<>();
		proximosPagos = filtradoUtil.obtenerProximosPagos(proximosPagos, poliza);
		// }}
		if (proximosPagos != null && proximosPagos.size() > 0) {
			for (int i = 0; i < proximosPagos.size(); i++) {
				ProximosPagos proximoPago = proximosPagos.get(i);
				Pago pago = new Pago();
				pago.setProducto(proximoPago.getProducto() + "-" + proximoPago.getNumPoliza());
				pago.setImporteAPagar(FormatosUtil.formatoNumerolRedoneado(proximoPago.getMontoOriginal()));
				pago.setFechaVencimiento(FormatosUtil.dateFormat(proximoPago.getFechaVencimiento()));

				jsonArrayProximosPagos.add(pago);
			}
		}
		return jsonArrayProximosPagos;
	}

	private TramitesObjecto obtenerTramites(List<PolizaModel> polizas, String urlConsultarTramites) {
		if (polizas != null) {
			TramitesUtility tramitesUtility = new TramitesUtility();
			List<String> familiasUnicas = tramitesUtility.obtenerPolizasUnicas(polizas);
			TramitesDAO tramitesDao = new TramitesDAO(restTemplate);
			List<TramiteEntity> tramitesDeBaseDeDatos = tramitesDao.obtenerTramitesParaJson(familiasUnicas,
					urlConsultarTramites);
			TramitesJSON tramitesJson = new TramitesJSON();
			TramitesObjecto tramites = tramitesJson.obtenerTramitesObjecto(tramitesDeBaseDeDatos);
			return tramites;
		}
		return null;
	}

	public List<Vigencias> getVigenciasPoliza(String idCliente, ArrayList<Row> servicioWeb, String idAgente) {

		Set<String> idepoliciesVig = new HashSet<String>();
		if (idCliente != null) {
			List<Vigencias> response = new ArrayList<>();
			try {
				if (servicioWeb.size() > 0 && servicioWeb.get(0) != null) {
					Row dataService = new Row();
					;
					for (Row row : servicioWeb) {
						Contratante contratante = row.getContratante();
						String esContratante = contratante != null ? contratante.getEsContratante() : null;

						log.debug("Contratante encontrado con estado: {}", esContratante);

						if ("S".equalsIgnoreCase(esContratante)) {
							dataService = row;
							break;
						}
					}

					List<Poliza> polizas = dataService.getPolizas();

					String productosVisiblesPortal = productosConfiguration.getProductosVisiblesPortal();
					String[] polInhabilesArray = productosVisiblesPortal.isEmpty() ? null
							: productosVisiblesPortal.split(",");

					for (Poliza poliza : polizas) {
						String idepol = poliza.getiDEPOL();
						if (idepoliciesVig.contains(idepol)) {
							continue;
						} else {
							idepoliciesVig.add(poliza.getiDEPOL());
							if (isPolizaInhabiles(poliza, polInhabilesArray)) {
								Vigencias contenedor = new Vigencias();
								contenedor.setProducto(poliza.getEmisor() + "-" + poliza.getNumPoliza() + "-"
										+ poliza.getIdRenovacion());
								contenedor.setFechaDesde(FormatosUtil.dateFormat(poliza.getFecIniVig()));
								contenedor.setFechaHasta(FormatosUtil.dateFormat(poliza.getFecFinVig()));
								String familia = grupoDePolizasHardCode.setFamilia(poliza.getEmisor(),
										obtenerTodosLosProductos());
								contenedor.setFamilia(familia);
								response.add(contenedor);
							}
						}
					}

					return response;
				}
			} catch (Exception e) {
				log.error("Error {}", e);
			}
		}
		return null;
	}

}

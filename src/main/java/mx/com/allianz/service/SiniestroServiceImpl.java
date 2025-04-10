package mx.com.allianz.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.UsuarioRequestModel;

@Service
public class SiniestroServiceImpl implements ISiniestroService {
	private static final Logger log = LoggerFactory.getLogger(SiniestroServiceImpl.class);

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	/**
	 * Instancia de manejo de codigos de respuesta
	 */
	@Autowired
	private Codes codes;

	private final RestTemplate restTemplate;

	public SiniestroServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public RespuestaGenerica consultarEstatus(UsuarioRequestModel request) throws BusinessException {

		String url = String.format(servicesConfiguration.getServicioEstatusSiniestroEmail(), request.getUsuario());
		String usuarioAuth = servicesConfiguration.getUsuarioAuthorizationServices();
		String passwordAuth = servicesConfiguration.getPassworAuthorizationServices();

		String authString = usuarioAuth + ":" + passwordAuth;
		String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
		return getRequest(url, authStringEnc);
		
	}

	public RespuestaGenerica getRequest(String webPage, String authStringEnc) {
		RespuestaGenerica respuesta = new RespuestaGenerica();

		try {
			// 1. Armar autenticación en base64
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Basic " + authStringEnc);
			HttpEntity<String> entity = new HttpEntity<>(headers);

			// 2. Llamar al servicio
			ResponseEntity<String> response = restTemplate.exchange(webPage, HttpMethod.GET, entity, String.class);

			// 3. Guardar respuesta
			respuesta.setEstatus(0);
			respuesta.setRespuesta(response.getBody());

			log.info("Llamado exitoso al servicio");

		} catch (Exception e) {
			log.error("Error al consumir el servicio. \nError: " + e.getMessage());
			respuesta.setEstatus(1);
			respuesta.setMensaje("Servicio no disponible por el momento");
		}
		return respuesta;
	}

}

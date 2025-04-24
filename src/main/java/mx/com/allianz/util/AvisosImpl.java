package mx.com.allianz.util;

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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.allianz.commons.model.SingleResponse;
import mx.com.allianz.config.ServicesConfiguration;

@Service
public class AvisosImpl {
	private static final Logger log = LoggerFactory.getLogger(AvisosImpl.class);

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	private final RestTemplate restTemplate;

	public AvisosImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public boolean encontrarAviso(String idAvisos) {
		log.info("Entro al metodo encontrarAviso");

		try {
			String urlServicio = servicesConfiguration.getUrlConsultarAvisos() + idAvisos;
			ResponseEntity<SingleResponse<String>> responseEntity = obtenerRespuestaDelServicio(urlServicio);

			if (responseEntity != null) {
				return procesarRespuesta(responseEntity.getBody());
			} else {
				log.warn("No se obtuvo respuesta del servicio.");
				return false;
			}
		} catch (RestClientException e) {
			log.error("Error en la comunicación con el servicio: {}", e.getMessage());
		} catch (Exception e) {
			log.error("Ocurrió un error inesperado: {}", e.getMessage());
		}

		return false;
	}

	/**
	 * Este método realiza la solicitud GET y obtiene la respuesta.
	 */
	private ResponseEntity<SingleResponse<String>> obtenerRespuestaDelServicio(String urlServicio) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		log.info("Realizando solicitud a la URL: {}", urlServicio);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			return restTemplate.exchange(urlServicio, HttpMethod.GET, entity,
					new ParameterizedTypeReference<SingleResponse<String>>() {
					});
		} catch (RestClientException e) {
			log.error("Error al hacer la solicitud GET: {}", e.getMessage());
			throw e; // Re-throw para que sea manejado en el método principal
		}
	}

	/**
	 * Este método procesa la respuesta del servicio y retorna si la notificación
	 * existe.
	 */
	private boolean procesarRespuesta(SingleResponse<String> responseBody) {
		if (responseBody == null) {
			log.warn("El cuerpo de la respuesta es null.");
			return false;
		}

		String response = responseBody.getResponse();
		log.info("Response Body: {}", responseBody);

		// Verificar si la respuesta es "true" (de forma insensible a
		// mayúsculas/minúsculas)
		boolean existeLaNotificacion = "true".equalsIgnoreCase(response);
		if (existeLaNotificacion) {
			log.info("El aviso existe.");
		} else {
			log.info("El aviso no existe.");
		}

		return existeLaNotificacion;
	}
}

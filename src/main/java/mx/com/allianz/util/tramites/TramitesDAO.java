package mx.com.allianz.util.tramites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import mx.com.allianz.service.impl.SiniestroServiceImpl;

@Service
public class TramitesDAO {
	private static final Logger log = LoggerFactory.getLogger(SiniestroServiceImpl.class);

	private final RestTemplate restTemplate;

	public TramitesDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<TramiteEntity> obtenerTramites(List<String> familias) {
		if (familias != null && familias.size() > 0) {
			List<TramiteEntity> tramites = new ArrayList<TramiteEntity>();
			for (int indiceFamilia = 0; indiceFamilia < familias.size(); indiceFamilia++) {
				try {
					List<TramiteEntity> tramitesPorFamilia = new ArrayList<>();
					if (tramitesPorFamilia != null && tramitesPorFamilia.size() > 0) {
						for (int indiceTramite = 0; indiceTramite < tramitesPorFamilia.size(); indiceTramite++) {
							tramites.add(tramitesPorFamilia.get(indiceTramite));
						}
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			return tramites;
		}
		return null;
	}

	public List<TramiteEntity> obtenerTramitesParaJson(List<String> familias, String urlConsultarTramites) {
		if (familias != null) {
			List<TramiteEntity> tramitesPorFamilia = obtenerTramitesConsultaDinamicaExterna(familias,
					urlConsultarTramites);
			if (tramitesPorFamilia != null && tramitesPorFamilia.size() > 0) {
				List<TramiteEntity> tramites = new ArrayList<TramiteEntity>();
				for (int indiceTramite = 0; indiceTramite < tramitesPorFamilia.size(); indiceTramite++) {
					TramiteEntity tramite = new TramiteEntity();
					tramite.setIdProducto(tramitesPorFamilia.get(indiceTramite).getIdProducto());
					tramite.setIdTramite(tramitesPorFamilia.get(indiceTramite).getIdTramite());
					tramite.setDescripcionTramite(tramitesPorFamilia.get(indiceTramite).getDescripcionTramite());
					tramite.setCorreo(tramitesPorFamilia.get(indiceTramite).getCorreo());
					tramites.add(tramite);
				}
				return tramites;
			}
		}
		return null;
	}

//	public List<TramiteEntity> obtenerTramitesConsultaDinamica(List<String> familias) {
//		if (familias != null) {
//			DynamicQuery consultaDinamica = DynamicQueryFactoryUtil.forClass(TRAMITES.class, "tr");
//			consultaDinamica.add(RestrictionsFactoryUtil.in("tr.primaryKey.idproducto", familias));
//			try {
//				List<TRAMITES> tramites = TRAMITESLocalServiceUtil.dynamicQuery(consultaDinamica);
//				return tramites;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

	public List<TramiteEntity> obtenerTramitesConsultaDinamicaExterna(List<String> familias,
			String urlConsultarTramites) {
		try {
			if (urlConsultarTramites == null || urlConsultarTramites.isEmpty()) {
				log.warn("La URL para consultar trámites es nula o vacía.");
				return Collections.emptyList();
			}

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<List<String>> entity = new HttpEntity<>(familias, headers);

			log.info("Consultando trámites en la URL: {}", urlConsultarTramites);
			ResponseEntity<SingleResponse<List<TramiteEntity>>> response = restTemplate.exchange(urlConsultarTramites,
					HttpMethod.POST, entity, new ParameterizedTypeReference<SingleResponse<List<TramiteEntity>>>() {
					});

			SingleResponse<List<TramiteEntity>> body = response.getBody();
			List<TramiteEntity> listaTramites = body != null ? body.getResponse() : Collections.emptyList();

			// Si hay familias, podrías filtrar la respuesta (si aplica)
			if (familias != null && !familias.isEmpty()) {
				// Si deseas filtrar por familias, implementa aquí la lógica
				log.info("Familias recibidas: {}", familias);
				// Por ahora, devolvemos todos los trámites sin filtrar
			}

			return listaTramites;

		} catch (RestClientException e) {
			log.error("Error al consultar trámites: {}", e.getMessage(), e);
		} catch (Exception e) {
			log.error("Error inesperado al obtener trámites: {}", e.getMessage(), e);
		}

		return Collections.emptyList(); // Retorna lista vacía en caso de error
	}

}

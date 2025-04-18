package mx.com.allianz.util.tramites;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.allianz.config.ServicesConfiguration;

@Service
public class TramitesDAO {

	@Autowired
	private ServicesConfiguration servicesConfiguration;

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

	public List<TramiteEntity> obtenerTramitesParaJson(List<String> familias) {
		if (familias != null) {
			List<TramiteEntity> tramitesPorFamilia = obtenerTramitesConsultaDinamicaExterna(familias);
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

	public List<TramiteEntity> obtenerTramitesConsultaDinamicaExterna(List<String> familias) {
		String urlServicio = servicesConfiguration.getUrlConsultarTramites();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Configuración de la solicitud con los headers
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<List<TramiteEntity>> responseEntity = restTemplate.exchange(urlServicio, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<TramiteEntity>>() {
				});

		//FGGG
		if (familias != null) {
			String[] familiasArray = new String[familias.size()];
			for (int i = 0; i < familias.size(); i++) {
				familiasArray[i] = familias.get(i);
			}
			return responseEntity.getBody();
		}
		return null;
	}

}

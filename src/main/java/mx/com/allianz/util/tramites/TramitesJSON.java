package mx.com.allianz.util.tramites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mx.com.allianz.model.TramitesModel;
import mx.com.allianz.model.TramitesObjecto;
import mx.com.allianz.model.TramitesPolizaModel;

public class TramitesJSON {

	public TramitesObjecto obtenerTramitesObjecto(List<TramiteEntity> tramites) {
		if (tramites != null) {
			List<TramitesPolizaModel> tramitesJson = obtenerTramitesJson(tramites);
			if (tramitesJson != null) {
				TramitesObjecto tramitesObjeto = new TramitesObjecto();
				tramitesObjeto.setListaTramites(tramitesJson);
				return tramitesObjeto;
			}
		}
		return null;
	}

	private List<TramitesPolizaModel> obtenerTramitesJson(List<TramiteEntity> tramites) {
		if (tramites != null) {
			List<TramitesAgrupados> tramitesAgrupados = obtenerTramitesAgrupados(tramites);
			if (tramitesAgrupados != null) {
				List<TramitesPolizaModel> tramitesJson = new ArrayList<>();
				for (int tramite = 0; tramite < tramitesAgrupados.size(); tramite++) {
					TramitesPolizaModel tramiteJson = new TramitesPolizaModel();
					Collections.sort(tramitesAgrupados.get(tramite).getTramiteCorreos());
					tramiteJson.setTipoPoliza(tramitesAgrupados.get(tramite).getIdFamilia());
					List<TramitesModel> tramitesPorFamilia = obtenerTramitesPorFamilia(
							tramitesAgrupados.get(tramite).getTramiteCorreos());
					tramiteJson.setTramites(tramitesPorFamilia);
					tramitesJson.add(tramiteJson);
				}
				return tramitesJson;
			}
		}
		return null;
	}

	private List<TramitesModel> obtenerTramitesPorFamilia(List<TramitesPorFamilia> tramitesPorFamilia) {
		if (tramitesPorFamilia != null) {
			List<TramitesModel> tramitesArray = new ArrayList<>();
			for (int tramite = 0; tramite < tramitesPorFamilia.size(); tramite++) {
				TramitesModel tramiteObject = new TramitesModel();
				tramiteObject.setTramite(tramitesPorFamilia.get(tramite).getDescripcionTramite());
				tramiteObject.setCorreo(tramitesPorFamilia.get(tramite).getCorreo());
				tramitesArray.add(tramiteObject);
			}
			return tramitesArray;
		}
		return null;
	}

	private List<TramitesAgrupados> obtenerTramitesAgrupados(List<TramiteEntity> tramites) {
		if (tramites != null) {
			List<TramitesAgrupados> tramitesAgrupados = new ArrayList<TramitesAgrupados>();
			for (int tramite = 0; tramite < tramites.size(); tramite++) {
				if (tramite == 0) {
					TramitesAgrupados tramiteActual = new TramitesAgrupados();
					tramiteActual.setIdFamilia(tramites.get(tramite).getIdProducto());
					TramitesPorFamilia tramitePorFamilia = new TramitesPorFamilia();
					tramitePorFamilia.setDescripcionTramite(tramites.get(tramite).getDescripcionTramite());
					tramitePorFamilia.setIdTramite(tramites.get(tramite).getIdTramite());
					tramitePorFamilia.setCorreo(tramites.get(tramite).getCorreo());
					tramiteActual.getTramiteCorreos().add(tramitePorFamilia);
					tramitesAgrupados.add(tramiteActual);
				} else {
					int indiceFamilia = obtenerIndiceFamilia(tramitesAgrupados, tramites.get(tramite).getIdProducto());
					if (indiceFamilia >= 0) {
						TramitesAgrupados tramiteActual = new TramitesAgrupados();
						tramiteActual.setIdFamilia(tramites.get(tramite).getIdProducto());
						TramitesPorFamilia tramiteFamilia = new TramitesPorFamilia();
						tramiteFamilia.setDescripcionTramite(tramites.get(tramite).getDescripcionTramite());
						tramiteFamilia.setIdTramite(tramites.get(tramite).getIdTramite());
						tramiteFamilia.setCorreo(tramites.get(tramite).getCorreo());
						tramiteActual.getTramiteCorreos().add(tramiteFamilia);
						tramitesAgrupados.get(indiceFamilia).getTramiteCorreos().add(tramiteFamilia);
					} else {
						TramitesAgrupados tramiteActual = new TramitesAgrupados();
						tramiteActual.setIdFamilia(tramites.get(tramite).getIdProducto());
						TramitesPorFamilia tramiteFamilia = new TramitesPorFamilia();
						tramiteFamilia.setDescripcionTramite(tramites.get(tramite).getDescripcionTramite());
						tramiteFamilia.setIdTramite(tramites.get(tramite).getIdTramite());
						tramiteFamilia.setCorreo(tramites.get(tramite).getCorreo());
						tramiteActual.getTramiteCorreos().add(tramiteFamilia);
						tramitesAgrupados.add(tramiteActual);
					}
				}
			}
			return tramitesAgrupados;
		}
		return null;
	}

	private int obtenerIndiceFamilia(List<TramitesAgrupados> tramites, String familia) {
		for (int indice = 0; indice < tramites.size(); indice++) {
			if (tramites.get(indice) != null) {
				if (tramites.get(indice).getIdFamilia().equalsIgnoreCase(familia)) {
					return indice;
				}
			}
		}
		return -1;
	}
}

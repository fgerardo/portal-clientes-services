package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

public class TramitesPolizaModel implements Serializable {

	/**
	 * Seriarilzador
	 */
	private static final long serialVersionUID = -6561514385375371903L;
	private String tipoPoliza;
	private List<TramitesModel> tramites;

	public String getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(String tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public List<TramitesModel> getTramites() {
		return tramites;
	}

	public void setTramites(List<TramitesModel> tramites) {
		this.tramites = tramites;
	}

	@Override
	public String toString() {
		return "TramitesPolizaModel [tipoPoliza=" + tipoPoliza + ", tramites=" + tramites + "]";
	}

}

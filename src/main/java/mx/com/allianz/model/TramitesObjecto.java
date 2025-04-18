package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

public class TramitesObjecto implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -453217715513991575L;
	private List<TramitesPolizaModel> listaTramites;

	public List<TramitesPolizaModel> getListaTramites() {
		return listaTramites;
	}

	public void setListaTramites(List<TramitesPolizaModel> listaTramites) {
		this.listaTramites = listaTramites;
	}

	@Override
	public String toString() {
		return "TramitesObjecto [listaTramites=" + listaTramites + "]";
	}

}

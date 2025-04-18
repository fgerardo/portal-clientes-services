package mx.com.allianz.util.tramites;

import java.util.ArrayList;
import java.util.List;

public class TramitesAgrupados {

	private String idFamilia;
	private List<TramitesPorFamilia> tramiteCorreos = new ArrayList<TramitesPorFamilia>();

	public String getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}

	public List<TramitesPorFamilia> getTramiteCorreos() {
		return tramiteCorreos;
	}

	public void setTramiteCorreos(List<TramitesPorFamilia> tramiteCorreos) {
		this.tramiteCorreos = tramiteCorreos;
	}
}

class TramitesPorFamilia implements Comparable<TramitesPorFamilia> {
	private String idTramite;
	private String descripcionTramite;
	private String correo;

	public String getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}

	public String getDescripcionTramite() {
		return descripcionTramite;
	}

	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public int compareTo(TramitesPorFamilia aComparar) {
		return this.descripcionTramite.compareTo(aComparar.descripcionTramite);
	}
}
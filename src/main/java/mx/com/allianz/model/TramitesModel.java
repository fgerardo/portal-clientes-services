package mx.com.allianz.model;

import java.io.Serializable;

public class TramitesModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7398003069524563196L;
	private String tramite;
	private String correo;

	public String getTramite() {
		return tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "TramitesModel [tramite=" + tramite + ", correo=" + correo + "]";
	}

}

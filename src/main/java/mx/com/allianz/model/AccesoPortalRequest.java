package mx.com.allianz.model;

import java.io.Serializable;

public class AccesoPortalRequest extends UsuarioRequestModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -7114344433841170791L;

	private String mensajeAutenticacion;

	public String getMensajeAutenticacion() {
		return mensajeAutenticacion;
	}

	public void setMensajeAutenticacion(String mensajeAutenticacion) {
		this.mensajeAutenticacion = mensajeAutenticacion;
	}

	@Override
	public String toString() {
		return "AccesoPortalRequest [mensajeAutenticacion=" + mensajeAutenticacion + "]";
	}

}

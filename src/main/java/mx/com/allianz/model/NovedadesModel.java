package mx.com.allianz.model;

import java.io.Serializable;

public class NovedadesModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 2492514820611594465L;

	private String respuesta;
	private String error;
	private String mensaje;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "NovedadesModel [respuesta=" + respuesta + ", error=" + error + ", mensaje=" + mensaje + "]";
	}

}

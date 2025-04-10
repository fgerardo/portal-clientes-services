package mx.com.allianz.commons.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class RespuestaGenerica implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 999325535193219162L;

	private int estatus;
	private String mensaje;
	private String respuesta;
	private String flujo;
	private List<Map<String, String>> img;

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFlujo() {
		return flujo;
	}

	public void setFlujo(String flujo) {
		this.flujo = flujo;
	}

	public List<Map<String, String>> getImg() {
		return img;
	}

	public void setImg(List<Map<String, String>> selectedImages) {
		this.img = selectedImages;
	}

	@Override
	public String toString() {
		return "RespuestaGenerica [estatus=" + estatus + ", mensaje=" + mensaje + ", respuesta=" + respuesta
				+ ", flujo=" + flujo + ", img=" + img + "]";
	}

}

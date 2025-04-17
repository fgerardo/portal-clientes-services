package mx.com.allianz.model;

import java.io.Serializable;

public class NotificacionModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -219451582768835797L;

	private String descripcion;
	private String id;
	private String estatus;
	private String fecha;
	private String notificacion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	@Override
	public String toString() {
		return "NotificacionModel [descripcion=" + descripcion + ", id=" + id + ", estatus=" + estatus + ", fecha="
				+ fecha + ", notificacion=" + notificacion + "]";
	}

}

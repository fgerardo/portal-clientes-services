package mx.com.allianz.model;

import java.io.Serializable;

public class InformacionPersonalModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -8042473211149181066L;
	private String clienteDesde;
	private String notificaciones;
	private String nombreCliente;

	public String getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(String clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public String getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Override
	public String toString() {
		return "InformacionPersonalModel [clienteDesde=" + clienteDesde + ", notificaciones=" + notificaciones
				+ ", nombreCliente=" + nombreCliente + "]";
	}

}

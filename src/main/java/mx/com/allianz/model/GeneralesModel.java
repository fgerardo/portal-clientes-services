package mx.com.allianz.model;

import java.io.Serializable;

public class GeneralesModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 5224930797377894957L;
	private String nombreCliente;
	private String clienteDesde;
	private String idCliente;
	private String email;
	private String fotoCliente;
	private String FechaUltimaActualizacion;
	private String tipoPersona;
	private String rfc;

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(String clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFotoCliente() {
		return fotoCliente;
	}

	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

	public String getFechaUltimaActualizacion() {
		return FechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		FechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "GeneralesModel [nombreCliente=" + nombreCliente + ", clienteDesde=" + clienteDesde + ", idCliente="
				+ idCliente + ", email=" + email + ", fotoCliente=" + fotoCliente + ", FechaUltimaActualizacion="
				+ FechaUltimaActualizacion + ", tipoPersona=" + tipoPersona + ", rfc=" + rfc + "]";
	}

}

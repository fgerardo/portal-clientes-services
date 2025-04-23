package mx.com.allianz.model.response;

import java.io.Serializable;
import java.util.List;

import mx.com.allianz.model.Poliza;

public class Cliente implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 6106163059938797666L;
	String idCliente;
	String nombreCliente;
	String desdeCliente;
	String fotoCliente;
	String email;
	String telefono;
	String tipoPersona;
	String rfc;
	List<PolizaResponse> polizas;
	boolean isContratante;
	private String fechaUltimaActualizacion;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDesdeCliente() {
		return desdeCliente;
	}

	public void setDesdeCliente(String desdeCliente) {
		this.desdeCliente = desdeCliente;
	}

	public String getFotoCliente() {
		return fotoCliente;
	}

	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<PolizaResponse> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<PolizaResponse> polizas) {
		this.polizas = polizas;
	}

	public boolean getIsContratante() {
		return isContratante;
	}

	public void setIsContratante(boolean b) {
		this.isContratante = b;
	}

	public String getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", desdeCliente=" + desdeCliente
				+ ", fotoCliente=" + fotoCliente + ", email=" + email + ", telefono=" + telefono + ", tipoPersona="
				+ tipoPersona + ", rfc=" + rfc + ", polizas=" + polizas + ", isContratante=" + isContratante
				+ ", fechaUltimaActualizacion=" + fechaUltimaActualizacion + "]";
	}

}

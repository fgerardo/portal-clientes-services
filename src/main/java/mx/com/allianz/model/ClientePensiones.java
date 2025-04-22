package mx.com.allianz.model;

import java.io.Serializable;

public class ClientePensiones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8002833570134681585L;
	private boolean pension;
	private String idclie;
	private String idCliente;
	private String nombreCliente;
	private String desdeCliente;
	private String fotoCliente;
	private String email;
	private String tipoPersona;
	private String rfc;
	private String fechaUltimaActualizacion;
	private String version_portal;
	private String rfcEncript;

	public boolean isPension() {
		return pension;
	}

	public void setPension(boolean pension) {
		this.pension = pension;
	}

	public String getIdclie() {
		return idclie;
	}

	public void setIdclie(String idclie) {
		this.idclie = idclie;
	}

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

	public String getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getVersion_portal() {
		return version_portal;
	}

	public void setVersion_portal(String version_portal) {
		this.version_portal = version_portal;
	}

	public String getRfcEncript() {
		return rfcEncript;
	}

	public void setRfcEncript(String rfcEncript) {
		this.rfcEncript = rfcEncript;
	}

	@Override
	public String toString() {
		return "ClientePensiones [pension=" + pension + ", idclie=" + idclie + ", idCliente=" + idCliente
				+ ", nombreCliente=" + nombreCliente + ", desdeCliente=" + desdeCliente + ", fotoCliente=" + fotoCliente
				+ ", email=" + email + ", tipoPersona=" + tipoPersona + ", rfc=" + rfc + ", fechaUltimaActualizacion="
				+ fechaUltimaActualizacion + ", version_portal=" + version_portal + ", rfcEncript=" + rfcEncript + "]";
	}

}

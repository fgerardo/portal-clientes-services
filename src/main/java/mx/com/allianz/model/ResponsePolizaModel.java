package mx.com.allianz.model;

import java.io.Serializable;

public class ResponsePolizaModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3901925569654331533L;
	private boolean estatus;
	private String mensaje;
	private String idClientePoliza;
	private String rfc;
	private String nombre;
	private String tipoPersona;
	private String apellidoP;
	private String apellidoM;
	private GeneralesModel generales;

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdClientePoliza() {
		return idClientePoliza;
	}

	public void setIdClientePoliza(String idClientePoliza) {
		this.idClientePoliza = idClientePoliza;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public GeneralesModel getGenerales() {
		return generales;
	}

	public void setGenerales(GeneralesModel generales) {
		this.generales = generales;
	}

	@Override
	public String toString() {
		return "ResponsePolizaModel [estatus=" + estatus + ", mensaje=" + mensaje + ", idClientePoliza="
				+ idClientePoliza + ", rfc=" + rfc + ", nombre=" + nombre + ", tipoPersona=" + tipoPersona
				+ ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", generales=" + generales + "]";
	}

}

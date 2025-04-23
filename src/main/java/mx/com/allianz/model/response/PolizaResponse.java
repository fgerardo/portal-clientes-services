package mx.com.allianz.model.response;

import java.io.Serializable;

public class PolizaResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2244408891677308121L;

	private String sumaAsegurada;
	private String folletoProducto;
	private String caratulaPoliza;
	private String numeroPoliza;
	private String estatus;
	private String tipoPoliza;
	private String fechaInicioVigencia;
	private String fechaEmision;
	private String saldo;
	private String formaPago;
	private String fechaTerminoVigencia;
	private boolean esContratante;
	private String nombreE;
	private String direccionE;
	private String rfcE;
	private String emailE;
	private String telefonoE;

	public String getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public String getFolletoProducto() {
		return folletoProducto;
	}

	public void setFolletoProducto(String folletoProducto) {
		this.folletoProducto = folletoProducto;
	}

	public String getCaratulaPoliza() {
		return caratulaPoliza;
	}

	public void setCaratulaPoliza(String caratulaPoliza) {
		this.caratulaPoliza = caratulaPoliza;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(String tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getFechaTerminoVigencia() {
		return fechaTerminoVigencia;
	}

	public void setFechaTerminoVigencia(String fechaTerminoVigencia) {
		this.fechaTerminoVigencia = fechaTerminoVigencia;
	}

	public boolean getEsContratante() {
		return esContratante;
	}

	public void setEsContratante(boolean esContratante) {
		this.esContratante = esContratante;
	}

	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDireccionE() {
		return direccionE;
	}

	public void setDireccionE(String direccionE) {
		this.direccionE = direccionE;
	}

	public String getRfcE() {
		return rfcE;
	}

	public void setRfcE(String rfcE) {
		this.rfcE = rfcE;
	}

	public String getEmailE() {
		return emailE;
	}

	public void setEmailE(String emailE) {
		this.emailE = emailE;
	}

	public String getTelefonoE() {
		return telefonoE;
	}

	public void setTelefonoE(String telefonoE) {
		this.telefonoE = telefonoE;
	}

	@Override
	public String toString() {
		return "PolizaResponse [sumaAsegurada=" + sumaAsegurada + ", folletoProducto=" + folletoProducto
				+ ", caratulaPoliza=" + caratulaPoliza + ", numeroPoliza=" + numeroPoliza + ", estatus=" + estatus
				+ ", tipoPoliza=" + tipoPoliza + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaEmision="
				+ fechaEmision + ", saldo=" + saldo + ", formaPago=" + formaPago + ", fechaTerminoVigencia="
				+ fechaTerminoVigencia + ", esContratante=" + esContratante + ", nombreE=" + nombreE + ", direccionE="
				+ direccionE + ", rfcE=" + rfcE + ", emailE=" + emailE + ", telefonoE=" + telefonoE + "]";
	}

}

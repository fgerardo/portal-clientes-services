package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProximosPagos implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 824698438871881539L;
	@JsonProperty("Conducto")
	private String conducto;
	@JsonProperty("FechaFin")
	private String fechaFin;
	@JsonProperty("FechaInicio")
	private String fechaInicio;
	@JsonProperty("FechaVencimiento")
	private String fechaVencimiento;
	@JsonProperty("IDEPOL")
	private String IDEPOL;
	@JsonProperty("IdRenovacion")
	private String idRenovacion;
	@JsonProperty("MonedaOriginal")
	private String monedaOriginal;
	@JsonProperty("MontoOriginal")
	private String montoOriginal;
	@JsonProperty("NumAportacion")
	private String numAportacion;
	@JsonProperty("NumPoliza")
	private String numPoliza;
	@JsonProperty("NumRecibo")
	private String numRecibo;
	@JsonProperty("Producto")
	private String producto;
	@JsonProperty("Serie")
	private String serie;

	public String getConducto() {
		return conducto;
	}

	public void setConducto(String conducto) {
		this.conducto = conducto;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getIDEPOL() {
		return IDEPOL;
	}

	public void setIDEPOL(String iDEPOL) {
		IDEPOL = iDEPOL;
	}

	public String getIdRenovacion() {
		return idRenovacion;
	}

	public void setIdRenovacion(String idRenovacion) {
		this.idRenovacion = idRenovacion;
	}

	public String getMonedaOriginal() {
		return monedaOriginal;
	}

	public void setMonedaOriginal(String monedaOriginal) {
		this.monedaOriginal = monedaOriginal;
	}

	public String getMontoOriginal() {
		return montoOriginal;
	}

	public void setMontoOriginal(String montoOriginal) {
		this.montoOriginal = montoOriginal;
	}

	public String getNumAportacion() {
		return numAportacion;
	}

	public void setNumAportacion(String numAportacion) {
		this.numAportacion = numAportacion;
	}

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public String getNumRecibo() {
		return numRecibo;
	}

	public void setNumRecibo(String numRecibo) {
		this.numRecibo = numRecibo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "ProximosPagos [conducto=" + conducto + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
				+ ", fechaVencimiento=" + fechaVencimiento + ", IDEPOL=" + IDEPOL + ", idRenovacion=" + idRenovacion
				+ ", monedaOriginal=" + monedaOriginal + ", montoOriginal=" + montoOriginal + ", numAportacion="
				+ numAportacion + ", numPoliza=" + numPoliza + ", numRecibo=" + numRecibo + ", producto=" + producto
				+ ", serie=" + serie + "]";
	}

}

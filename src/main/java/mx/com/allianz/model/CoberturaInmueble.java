package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoberturaInmueble implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6862293143171785662L;
	@JsonProperty("CodCobert")
	private String codCobert;

	@JsonProperty("CodMoneda")
	private String codMoneda;

	@JsonProperty("DescCobert")
	private String descCobert;

	@JsonProperty("FechaFinVig")
	private String fechaFinVig;

	@JsonProperty("FechaIniVig")
	private String fechaIniVig;

	@JsonProperty("IdCobertura")
	private String idCobertura;

	@JsonProperty("NumCert")
	private String numCert;

	@JsonProperty("StsCobert")
	private String stsCobert;

	@JsonProperty("SumaAsegCob")
	private String sumaAsegCob;

	@JsonProperty("SumaAsegCobDesc")
	private String sumaAsegCobDesc;

	public String getCodCobert() {
		return codCobert;
	}

	public void setCodCobert(String codCobert) {
		this.codCobert = codCobert;
	}

	public String getCodMoneda() {
		return codMoneda;
	}

	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}

	public String getDescCobert() {
		return descCobert;
	}

	public void setDescCobert(String descCobert) {
		this.descCobert = descCobert;
	}

	public String getFechaFinVig() {
		return fechaFinVig;
	}

	public void setFechaFinVig(String fechaFinVig) {
		this.fechaFinVig = fechaFinVig;
	}

	public String getFechaIniVig() {
		return fechaIniVig;
	}

	public void setFechaIniVig(String fechaIniVig) {
		this.fechaIniVig = fechaIniVig;
	}

	public String getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(String idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getNumCert() {
		return numCert;
	}

	public void setNumCert(String numCert) {
		this.numCert = numCert;
	}

	public String getStsCobert() {
		return stsCobert;
	}

	public void setStsCobert(String stsCobert) {
		this.stsCobert = stsCobert;
	}

	public String getSumaAsegCob() {
		return sumaAsegCob;
	}

	public void setSumaAsegCob(String sumaAsegCob) {
		this.sumaAsegCob = sumaAsegCob;
	}

	public String getSumaAsegCobDesc() {
		return sumaAsegCobDesc;
	}

	public void setSumaAsegCobDesc(String sumaAsegCobDesc) {
		this.sumaAsegCobDesc = sumaAsegCobDesc;
	}

	@Override
	public String toString() {
		return "CoberturaInmueble [codCobert=" + codCobert + ", codMoneda=" + codMoneda + ", descCobert=" + descCobert
				+ ", fechaFinVig=" + fechaFinVig + ", fechaIniVig=" + fechaIniVig + ", idCobertura=" + idCobertura
				+ ", numCert=" + numCert + ", stsCobert=" + stsCobert + ", sumaAsegCob=" + sumaAsegCob
				+ ", sumaAsegCobDesc=" + sumaAsegCobDesc + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoberturaBien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3024439961693235436L;
	@JsonProperty("CodCobert")
	private String codCobert;
	@JsonProperty("CodMoneda")
	private String codMoneda;
	@JsonProperty("DescCobert")
	private String descCobert;
	@JsonProperty("FecFinValid")
	private String fecFinValid;
	@JsonProperty("FecIniValid")
	private String fecIniValid;
	@JsonProperty("IdCobertura")
	private String idCobertura;
	@JsonProperty("IdeBien")
	private String ideBien;
	@JsonProperty("NumCert")
	private String numCert;
	@JsonProperty("StsCobert")
	private String stsCobert;
	@JsonProperty("SumaAseg")
	private String SumaAseg;
	@JsonProperty("SumaAsegDesc")
	private String SumaAsegDesc;

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

	public String getFecFinValid() {
		return fecFinValid;
	}

	public void setFecFinValid(String fecFinValid) {
		this.fecFinValid = fecFinValid;
	}

	public String getFecIniValid() {
		return fecIniValid;
	}

	public void setFecIniValid(String fecIniValid) {
		this.fecIniValid = fecIniValid;
	}

	public String getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(String idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getIdeBien() {
		return ideBien;
	}

	public void setIdeBien(String ideBien) {
		this.ideBien = ideBien;
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

	public String getSumaAseg() {
		return SumaAseg;
	}

	public void setSumaAseg(String sumaAseg) {
		SumaAseg = sumaAseg;
	}

	public String getSumaAsegDesc() {
		return SumaAsegDesc;
	}

	public void setSumaAsegDesc(String sumaAsegDesc) {
		SumaAsegDesc = sumaAsegDesc;
	}

	@Override
	public String toString() {
		return "CoberturaBien [codCobert=" + codCobert + ", codMoneda=" + codMoneda + ", descCobert=" + descCobert
				+ ", fecFinValid=" + fecFinValid + ", fecIniValid=" + fecIniValid + ", idCobertura=" + idCobertura
				+ ", ideBien=" + ideBien + ", numCert=" + numCert + ", stsCobert=" + stsCobert + ", SumaAseg="
				+ SumaAseg + ", SumaAsegDesc=" + SumaAsegDesc + "]";
	}

}

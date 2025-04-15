package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coberturas implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 787258152520177437L;

	@JsonProperty("CodGua")
	private String CodGua;
	@JsonProperty("CodPlan")
	private String CodPlan;
	@JsonProperty("CodRamoCert")
	private String CodRamoCert;
	@JsonProperty("CodZona")
	private String CodZona;
	@JsonProperty("Deducible")
	private String Deducible;
	@JsonProperty("DesCobertura")
	private String DesCobertura;
	@JsonProperty("DesGua")
	private String DesGua;
	@JsonProperty("DesZona")
	private String DesZona;
	@JsonProperty("FechaFinVig")
	private String FechaFinVig;
	@JsonProperty("FechaIniVig")
	private String FechaIniVig;
	@JsonProperty("IdCobertura")
	private String IdCobertura;
	@JsonProperty("PorcCoa")
	private String PorcCoa;
	@JsonProperty("RevPlan")
	private String RevPlan;
	@JsonProperty("StsCobert")
	private String StsCobert;
	@JsonProperty("SumaAsegurada")
	private String SumaAsegurada;

	public String getCodGua() {
		return CodGua;
	}

	public void setCodGua(String codGua) {
		CodGua = codGua;
	}

	public String getCodPlan() {
		return CodPlan;
	}

	public void setCodPlan(String codPlan) {
		CodPlan = codPlan;
	}

	public String getCodRamoCert() {
		return CodRamoCert;
	}

	public void setCodRamoCert(String codRamoCert) {
		CodRamoCert = codRamoCert;
	}

	public String getCodZona() {
		return CodZona;
	}

	public void setCodZona(String codZona) {
		CodZona = codZona;
	}

	public String getDeducible() {
		return Deducible;
	}

	public void setDeducible(String deducible) {
		Deducible = deducible;
	}

	public String getDesCobertura() {
		return DesCobertura;
	}

	public void setDesCobertura(String desCobertura) {
		DesCobertura = desCobertura;
	}

	public String getDesGua() {
		return DesGua;
	}

	public void setDesGua(String desGua) {
		DesGua = desGua;
	}

	public String getDesZona() {
		return DesZona;
	}

	public void setDesZona(String desZona) {
		DesZona = desZona;
	}

	public String getFechaFinVig() {
		return FechaFinVig;
	}

	public void setFechaFinVig(String fechaFinVig) {
		FechaFinVig = fechaFinVig;
	}

	public String getFechaIniVig() {
		return FechaIniVig;
	}

	public void setFechaIniVig(String fechaIniVig) {
		FechaIniVig = fechaIniVig;
	}

	public String getIdCobertura() {
		return IdCobertura;
	}

	public void setIdCobertura(String idCobertura) {
		IdCobertura = idCobertura;
	}

	public String getPorcCoa() {
		return PorcCoa;
	}

	public void setPorcCoa(String porcCoa) {
		PorcCoa = porcCoa;
	}

	public String getRevPlan() {
		return RevPlan;
	}

	public void setRevPlan(String revPlan) {
		RevPlan = revPlan;
	}

	public String getStsCobert() {
		return StsCobert;
	}

	public void setStsCobert(String stsCobert) {
		StsCobert = stsCobert;
	}

	public String getSumaAsegurada() {
		return SumaAsegurada;
	}

	public void setSumaAsegurada(String sumaAsegurada) {
		SumaAsegurada = sumaAsegurada;
	}

	@Override
	public String toString() {
		return "Coberturas [CodGua=" + CodGua + ", CodPlan=" + CodPlan + ", CodRamoCert=" + CodRamoCert + ", CodZona="
				+ CodZona + ", Deducible=" + Deducible + ", DesCobertura=" + DesCobertura + ", DesGua=" + DesGua
				+ ", DesZona=" + DesZona + ", FechaFinVig=" + FechaFinVig + ", FechaIniVig=" + FechaIniVig
				+ ", IdCobertura=" + IdCobertura + ", PorcCoa=" + PorcCoa + ", RevPlan=" + RevPlan + ", StsCobert="
				+ StsCobert + ", SumaAsegurada=" + SumaAsegurada + "]";
	}

}

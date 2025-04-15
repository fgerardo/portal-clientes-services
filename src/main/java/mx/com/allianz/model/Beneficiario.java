package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Beneficiario implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -1011733545405255951L;
	@JsonProperty("NombreBeneficiario")
	public String nombreBeneficiario;
	@JsonProperty("NumBen")
	public int numBen;
	@JsonProperty("NumCert")
	public int numCert;
	@JsonProperty("TipoBen")
	public String tipoBen;
	@JsonProperty("StsBen")
	public String stsBen;
	@JsonProperty("Parentesco")
	public String parentesco;
	@JsonProperty("Porcentaje")
	public String porcentaje;

	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	public int getNumBen() {
		return numBen;
	}

	public void setNumBen(int numBen) {
		this.numBen = numBen;
	}

	public int getNumCert() {
		return numCert;
	}

	public void setNumCert(int numCert) {
		this.numCert = numCert;
	}

	public String getTipoBen() {
		return tipoBen;
	}

	public void setTipoBen(String tipoBen) {
		this.tipoBen = tipoBen;
	}

	public String getStsBen() {
		return stsBen;
	}

	public void setStsBen(String stsBen) {
		this.stsBen = stsBen;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Beneficiario [nombreBeneficiario=" + nombreBeneficiario + ", numBen=" + numBen + ", numCert=" + numCert
				+ ", tipoBen=" + tipoBen + ", stsBen=" + stsBen + ", parentesco=" + parentesco + ", porcentaje="
				+ porcentaje + "]";
	}

}

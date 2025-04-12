package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Asegurado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3295175658311627215L;
	@JsonProperty("IdAsegurado")
	public int idAsegurado;
	@JsonProperty("NombreAsegurado")
	public String nombreAsegurado;
	@JsonProperty("Parentesco")
	public String parentesco;
	@JsonProperty("SexoAsegurado")
	public String sexoAsegurado;
	@JsonProperty("FechaNacimiento")
	public String fechaNacimiento;
	@JsonProperty("FechaAntiguedad")
	public String fechaAntiguedad;
	@JsonProperty("FechaIniVig")
	public String fechaIniVig;
	@JsonProperty("FechaFinVig")
	public String fechaFinVig;
	@JsonProperty("StsAseg")
	public String stsAseg;
	@JsonProperty("IndAsegTitular")
	public String indAsegTitular;
	@JsonProperty("CodCli")
	public String codCli;
	@JsonProperty("CoberturaAsegurado")
	public ArrayList<CoberturaAsegurado> coberturaAsegurado;

	public int getIdAsegurado() {
		return idAsegurado;
	}

	public void setIdAsegurado(int idAsegurado) {
		this.idAsegurado = idAsegurado;
	}

	public String getNombreAsegurado() {
		return nombreAsegurado;
	}

	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getSexoAsegurado() {
		return sexoAsegurado;
	}

	public void setSexoAsegurado(String sexoAsegurado) {
		this.sexoAsegurado = sexoAsegurado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaAntiguedad() {
		return fechaAntiguedad;
	}

	public void setFechaAntiguedad(String fechaAntiguedad) {
		this.fechaAntiguedad = fechaAntiguedad;
	}

	public String getFechaIniVig() {
		return fechaIniVig;
	}

	public void setFechaIniVig(String fechaIniVig) {
		this.fechaIniVig = fechaIniVig;
	}

	public String getFechaFinVig() {
		return fechaFinVig;
	}

	public void setFechaFinVig(String fechaFinVig) {
		this.fechaFinVig = fechaFinVig;
	}

	public String getStsAseg() {
		return stsAseg;
	}

	public void setStsAseg(String stsAseg) {
		this.stsAseg = stsAseg;
	}

	public String getIndAsegTitular() {
		return indAsegTitular;
	}

	public void setIndAsegTitular(String indAsegTitular) {
		this.indAsegTitular = indAsegTitular;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public ArrayList<CoberturaAsegurado> getCoberturaAsegurado() {
		return coberturaAsegurado;
	}

	public void setCoberturaAsegurado(ArrayList<CoberturaAsegurado> coberturaAsegurado) {
		this.coberturaAsegurado = coberturaAsegurado;
	}

	@Override
	public String toString() {
		return "Asegurado [idAsegurado=" + idAsegurado + ", nombreAsegurado=" + nombreAsegurado + ", parentesco="
				+ parentesco + ", sexoAsegurado=" + sexoAsegurado + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaAntiguedad=" + fechaAntiguedad + ", fechaIniVig=" + fechaIniVig + ", fechaFinVig="
				+ fechaFinVig + ", stsAseg=" + stsAseg + ", indAsegTitular=" + indAsegTitular + ", codCli=" + codCli
				+ ", coberturaAsegurado=" + coberturaAsegurado + "]";
	}

}

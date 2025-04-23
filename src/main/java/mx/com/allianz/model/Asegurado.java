package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Asegurado implements Serializable {
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
	@JsonProperty("MembresiaVRIM")
	public String membresiaVRIM;
	@JsonProperty("NoMembresiaVrim")
	public String noMembresiaVrim;
	@JsonProperty("Telemedicina")
	public String telemedicina;
	@JsonProperty("UsApp")
	public String usApp;
	@JsonProperty("IDEPOL_CODCLI")
	public String IDEPOL_CODCLI;
	@JsonProperty("IDEPOL_NUMCERT")
	public String IDEPOL_NUMCERT;
	@JsonProperty("NumCert")
	public String numCert;
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

	public String getUsApp() {
		return usApp;
	}

	public String getNumCert() {
		return numCert;
	}

	public void setNumCert(String numCert) {
		this.numCert = numCert;
	}

	public void setUsApp(String usApp) {
		this.usApp = usApp;
	}

	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}

	public String getIDEPOL_CODCLI() {
		return IDEPOL_CODCLI;
	}

	public void setIDEPOL_CODCLI(String iDEPOL_CODCLI) {
		IDEPOL_CODCLI = iDEPOL_CODCLI;
	}

	public String getIDEPOL_NUMCERT() {
		return IDEPOL_NUMCERT;
	}

	public void setIDEPOL_NUMCERT(String iDEPOL_NUMCERT) {
		IDEPOL_NUMCERT = iDEPOL_NUMCERT;
	}

	public String getParentesco() {
		return parentesco;
	}

	public String getMembresiaVRIM() {
		return membresiaVRIM;
	}

	public void setMembresiaVRIM(String membresiaVRIM) {
		this.membresiaVRIM = membresiaVRIM;
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

	public String getTelemedicina() {
		return telemedicina;
	}

	public void setTelemedicina(String telemedicina) {
		this.telemedicina = telemedicina;
	}

	public String getNoMembresiaVrim() {
		return noMembresiaVrim;
	}

	public void setNoMembresiaVrim(String noMembresiaVrim) {
		this.noMembresiaVrim = noMembresiaVrim;
	}

	@Override
	public String toString() {
		return "Asegurado [idAsegurado=" + idAsegurado + ", nombreAsegurado=" + nombreAsegurado + ", parentesco="
				+ parentesco + ", sexoAsegurado=" + sexoAsegurado + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaAntiguedad=" + fechaAntiguedad + ", fechaIniVig=" + fechaIniVig + ", fechaFinVig="
				+ fechaFinVig + ", stsAseg=" + stsAseg + ", indAsegTitular=" + indAsegTitular + ", codCli=" + codCli
				+ ", membresiaVRIM=" + membresiaVRIM + ", noMembresiaVrim=" + noMembresiaVrim + ", telemedicina="
				+ telemedicina + ", usApp=" + usApp + ", IDEPOL_CODCLI=" + IDEPOL_CODCLI + ", IDEPOL_NUMCERT="
				+ IDEPOL_NUMCERT + ", numCert=" + numCert + ", coberturaAsegurado=" + coberturaAsegurado + "]";
	}

}

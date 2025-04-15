package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoberturaAsegurado implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 2000402474195605807L;
	@JsonProperty("IdCobertura")
	public int idCobertura;
	@JsonProperty("DescCobertura")
	public String descCobertura;
	@JsonProperty("SumaAsegCob")
	public double sumaAsegCob;
	@JsonProperty("FechaIniVig")
	public String fechaIniVig;
	@JsonProperty("FechaFinVig")
	public String fechaFinVig;
	@JsonProperty("Estatus")
	public String estatus;
	@JsonProperty("CodCli")
	public String codCli;
	@JsonProperty("IDEPOL_CODCLI")
	public String IDEPOL_CODCLI;

	@JsonProperty("SumaAsegCobDesc")
	public String sumaAsegCobDesc;

	public int getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(int idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getDescCobertura() {
		return descCobertura;
	}

	public void setDescCobertura(String descCobertura) {
		this.descCobertura = descCobertura;
	}

	public double getSumaAsegCob() {
		return sumaAsegCob;
	}

	public void setSumaAsegCob(double sumaAsegCob) {
		this.sumaAsegCob = sumaAsegCob;
	}

	public String getFechaIniVig() {
		return fechaIniVig;
	}

	public String getIDEPOL_CODCLI() {
		return IDEPOL_CODCLI;
	}

	public void setIDEPOL_CODCLI(String iDEPOL_CODCLI) {
		IDEPOL_CODCLI = iDEPOL_CODCLI;
	}

	public String getSumaAsegCobDesc() {
		return sumaAsegCobDesc;
	}

	public void setSumaAsegCobDesc(String sumaAsegCobDesc) {
		this.sumaAsegCobDesc = sumaAsegCobDesc;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	@Override
	public String toString() {
		return "CoberturaAsegurado [idCobertura=" + idCobertura + ", descCobertura=" + descCobertura + ", sumaAsegCob="
				+ sumaAsegCob + ", fechaIniVig=" + fechaIniVig + ", fechaFinVig=" + fechaFinVig + ", estatus=" + estatus
				+ ", codCli=" + codCli + ", IDEPOL_CODCLI=" + IDEPOL_CODCLI + ", sumaAsegCobDesc=" + sumaAsegCobDesc
				+ "]";
	}

}

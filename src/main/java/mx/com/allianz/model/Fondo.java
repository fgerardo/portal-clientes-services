package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fondo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6546197746333710940L;
    @JsonProperty("IdFondo") 
	public int idFondo;
	@JsonProperty("StsFondo")
	public String stsFondo;
	@JsonProperty("TipoFondo")
	public String tipoFondo;
	@JsonProperty("NombreFondo")
	public String nombreFondo;
	@JsonProperty("Moneda")
	public String moneda;
	@JsonProperty("ImporteMonOrig")
	public String importeMonOrig;
	@JsonProperty("ImportePesos")
	public String importePesos;
	@JsonProperty("Año")
	public String año;
	@JsonProperty("Mes")
	public String mes;
	@JsonProperty("Saldo")
	public ArrayList<Saldo> saldo;

	public int getIdFondo() {
		return idFondo;
	}

	public void setIdFondo(int idFondo) {
		this.idFondo = idFondo;
	}

	public String getStsFondo() {
		return stsFondo;
	}

	public void setStsFondo(String stsFondo) {
		this.stsFondo = stsFondo;
	}

	public String getTipoFondo() {
		return tipoFondo;
	}

	public void setTipoFondo(String tipoFondo) {
		this.tipoFondo = tipoFondo;
	}

	public String getNombreFondo() {
		return nombreFondo;
	}

	public void setNombreFondo(String nombreFondo) {
		this.nombreFondo = nombreFondo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getImporteMonOrig() {
		return importeMonOrig;
	}

	public void setImporteMonOrig(String importeMonOrig) {
		this.importeMonOrig = importeMonOrig;
	}

	public String getImportePesos() {
		return importePesos;
	}

	public void setImportePesos(String importePesos) {
		this.importePesos = importePesos;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public ArrayList<Saldo> getSaldo() {
		return saldo;
	}

	public void setSaldo(ArrayList<Saldo> saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Fondo [idFondo=" + idFondo + ", stsFondo=" + stsFondo + ", tipoFondo=" + tipoFondo + ", nombreFondo="
				+ nombreFondo + ", moneda=" + moneda + ", importeMonOrig=" + importeMonOrig + ", importePesos="
				+ importePesos + ", año=" + año + ", mes=" + mes + "]";
	}

}

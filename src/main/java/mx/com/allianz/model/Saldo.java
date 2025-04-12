package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saldo implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 1862677208903567647L;
	@JsonProperty("_id")
	public String _id;
	@JsonProperty("IDEPOL")
	public int iDEPOL;
	@JsonProperty("IDEFONDO")
	public int iDEFONDO;
	@JsonProperty("IDEFONDOMOV")
	public String iDEFONDOMOV;
	@JsonProperty("AnioMes")
	public String anioMes;
	@JsonProperty("SaldoInicialMN")
	public String saldoInicialMN;
	@JsonProperty("AportacionesMesMN")
	public String aportacionesMesMN;
	@JsonProperty("RetirosMesMN")
	public String retirosMesMN;
	@JsonProperty("TraspasosMesMN")
	public String traspasosMesMN;
	@JsonProperty("BonoMesMN")
	public String bonoMesMN;
	@JsonProperty("RetencionMesMN")
	public String retencionMesMN;
	@JsonProperty("SaldoFinalMN")
	public String saldoFinalMN;
	@JsonProperty("AcumuladoTotalAporatciones")
	public String acumuladoTotalAporatciones;
	@JsonProperty("Anio")
	public String anio;
	@JsonProperty("Mes")
	public String mes;
	@JsonProperty("NombreFondo")
	public String nombreFondo;
	@JsonProperty("Moneda")
	public String moneda;
	@JsonProperty("SaldoFinalMonOrig")
	public String saldoFinalMonOrig;
	@JsonProperty("Movimientos")
	public ArrayList<Movimiento> movimientos;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getiDEPOL() {
		return iDEPOL;
	}

	public void setiDEPOL(int iDEPOL) {
		this.iDEPOL = iDEPOL;
	}

	public int getiDEFONDO() {
		return iDEFONDO;
	}

	public void setiDEFONDO(int iDEFONDO) {
		this.iDEFONDO = iDEFONDO;
	}

	public String getiDEFONDOMOV() {
		return iDEFONDOMOV;
	}

	public void setiDEFONDOMOV(String iDEFONDOMOV) {
		this.iDEFONDOMOV = iDEFONDOMOV;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getSaldoInicialMN() {
		return saldoInicialMN;
	}

	public void setSaldoInicialMN(String saldoInicialMN) {
		this.saldoInicialMN = saldoInicialMN;
	}

	public String getAportacionesMesMN() {
		return aportacionesMesMN;
	}

	public void setAportacionesMesMN(String aportacionesMesMN) {
		this.aportacionesMesMN = aportacionesMesMN;
	}

	public String getRetirosMesMN() {
		return retirosMesMN;
	}

	public void setRetirosMesMN(String retirosMesMN) {
		this.retirosMesMN = retirosMesMN;
	}

	public String getTraspasosMesMN() {
		return traspasosMesMN;
	}

	public void setTraspasosMesMN(String traspasosMesMN) {
		this.traspasosMesMN = traspasosMesMN;
	}

	public String getBonoMesMN() {
		return bonoMesMN;
	}

	public void setBonoMesMN(String bonoMesMN) {
		this.bonoMesMN = bonoMesMN;
	}

	public String getRetencionMesMN() {
		return retencionMesMN;
	}

	public void setRetencionMesMN(String retencionMesMN) {
		this.retencionMesMN = retencionMesMN;
	}

	public String getSaldoFinalMN() {
		return saldoFinalMN;
	}

	public void setSaldoFinalMN(String saldoFinalMN) {
		this.saldoFinalMN = saldoFinalMN;
	}

	public String getAcumuladoTotalAporatciones() {
		return acumuladoTotalAporatciones;
	}

	public void setAcumuladoTotalAporatciones(String acumuladoTotalAporatciones) {
		this.acumuladoTotalAporatciones = acumuladoTotalAporatciones;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
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

	public String getSaldoFinalMonOrig() {
		return saldoFinalMonOrig;
	}

	public void setSaldoFinalMonOrig(String saldoFinalMonOrig) {
		this.saldoFinalMonOrig = saldoFinalMonOrig;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}


	@Override
	public String toString() {
		return "Saldo [_id=" + _id + ", iDEPOL=" + iDEPOL + ", iDEFONDO=" + iDEFONDO + ", iDEFONDOMOV=" + iDEFONDOMOV
				+ ", anioMes=" + anioMes + ", saldoInicialMN=" + saldoInicialMN + ", aportacionesMesMN="
				+ aportacionesMesMN + ", retirosMesMN=" + retirosMesMN + ", traspasosMesMN=" + traspasosMesMN
				+ ", bonoMesMN=" + bonoMesMN + ", retencionMesMN=" + retencionMesMN + ", saldoFinalMN=" + saldoFinalMN
				+ ", acumuladoTotalAporatciones=" + acumuladoTotalAporatciones + ", anio=" + anio + ", mes=" + mes
				+ ", nombreFondo=" + nombreFondo + ", moneda=" + moneda + ", saldoFinalMonOrig=" + saldoFinalMonOrig
				+ ", movimientos=" + movimientos + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movimiento implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -8795488162703008760L;
	@JsonProperty("_id")
	public String _id;
	@JsonProperty("IDEPOL")
	public int iDEPOL;
	@JsonProperty("IDEFONDO")
	public int iDEFONDO;
	@JsonProperty("IDEFONDOMOV")
	public String iDEFONDOMOV;
	@JsonProperty("Anio")
	public String anio;
	@JsonProperty("Mes")
	public String mes;
	@JsonProperty("Fondo")
	public String fondo;
	@JsonProperty("Moneda")
	public String moneda;
	@JsonProperty("Fecha")
	public String fecha;
	@JsonProperty("TipoMovimiento")
	public String tipoMovimiento;
	@JsonProperty("MontoMN")
	public String montoMN;

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

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getMontoMN() {
		return montoMN;
	}

	public void setMontoMN(String montoMN) {
		this.montoMN = montoMN;
	}

	@Override
	public String toString() {
		return "Movimiento [_id=" + _id + ", iDEPOL=" + iDEPOL + ", iDEFONDO=" + iDEFONDO + ", iDEFONDOMOV="
				+ iDEFONDOMOV + ", anio=" + anio + ", mes=" + mes + ", fondo=" + fondo + ", moneda=" + moneda
				+ ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", montoMN=" + montoMN + "]";
	}

}

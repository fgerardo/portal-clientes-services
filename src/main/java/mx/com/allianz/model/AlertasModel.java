package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertasModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -4284465754853303872L;
	@JsonProperty("CodMensajeRemesa")
	private String codMensajeRemesa;
	@JsonProperty("CodTipoMensaje")
	private String codTipoMensaje;
	@JsonProperty("ConductoCobro")
	private String conductoCobro;
	@JsonProperty("DescMensajeRemesa")
	private String descMensajeRemesa;
	@JsonProperty("Estatus")
	private String estatus;
	@JsonProperty("FechaAlerta")
	private String fechaAlerta;
	@JsonProperty("IDEPOL")
	private String IDEPOL;
	@JsonProperty("Id")
	private String id;
	@JsonProperty("IdRenovacion")
	private String idRenovacion;
	@JsonProperty("NumAportacion")
	private String numAportacion;
	@JsonProperty("NumPoliza")
	private String numPoliza;
	@JsonProperty("NumRecibo")
	private String numRecibo;
	@JsonProperty("Persistencia")
	private String persistencia;
	@JsonProperty("Producto")
	private String producto;
	@JsonProperty("Serie")
	private String serie;

	public String getCodMensajeRemesa() {
		return codMensajeRemesa;
	}

	public void setCodMensajeRemesa(String codMensajeRemesa) {
		this.codMensajeRemesa = codMensajeRemesa;
	}

	public String getCodTipoMensaje() {
		return codTipoMensaje;
	}

	public void setCodTipoMensaje(String codTipoMensaje) {
		this.codTipoMensaje = codTipoMensaje;
	}

	public String getConductoCobro() {
		return conductoCobro;
	}

	public void setConductoCobro(String conductoCobro) {
		this.conductoCobro = conductoCobro;
	}

	public String getDescMensajeRemesa() {
		return descMensajeRemesa;
	}

	public void setDescMensajeRemesa(String descMensajeRemesa) {
		this.descMensajeRemesa = descMensajeRemesa;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechaAlerta() {
		return fechaAlerta;
	}

	public void setFechaAlerta(String fechaAlerta) {
		this.fechaAlerta = fechaAlerta;
	}

	public String getIDEPOL() {
		return IDEPOL;
	}

	public void setIDEPOL(String iDEPOL) {
		IDEPOL = iDEPOL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdRenovacion() {
		return idRenovacion;
	}

	public void setIdRenovacion(String idRenovacion) {
		this.idRenovacion = idRenovacion;
	}

	public String getNumAportacion() {
		return numAportacion;
	}

	public void setNumAportacion(String numAportacion) {
		this.numAportacion = numAportacion;
	}

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public String getNumRecibo() {
		return numRecibo;
	}

	public void setNumRecibo(String numRecibo) {
		this.numRecibo = numRecibo;
	}

	public String getPersistencia() {
		return persistencia;
	}

	public void setPersistencia(String persistencia) {
		this.persistencia = persistencia;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "AlertasModel [codMensajeRemesa=" + codMensajeRemesa + ", codTipoMensaje=" + codTipoMensaje
				+ ", conductoCobro=" + conductoCobro + ", descMensajeRemesa=" + descMensajeRemesa + ", estatus="
				+ estatus + ", fechaAlerta=" + fechaAlerta + ", IDEPOL=" + IDEPOL + ", id=" + id + ", idRenovacion="
				+ idRenovacion + ", numAportacion=" + numAportacion + ", numPoliza=" + numPoliza + ", numRecibo="
				+ numRecibo + ", persistencia=" + persistencia + ", producto=" + producto + ", serie=" + serie + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InmuebleAsegurado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1730780089858082900L;

	@JsonProperty("CodigoPostal")
	private String codigoPostal;
	@JsonProperty("Colonia")
	private String colonia;
	@JsonProperty("Estado")
	private String estado;
	@JsonProperty("IdInmueble")
	private String idInmueble;
	@JsonProperty("Municipio")
	private String municipio;
	@JsonProperty("Numero")
	private String numero;
	@JsonProperty("Calle")
	private String calle;
	@JsonProperty("CoberturaInmueble")
	private List<CoberturaInmueble> coberturaInmueble;

	public List<CoberturaInmueble> getCoberturaInmueble() {
		return coberturaInmueble;
	}

	public void setCoberturaInmueble(List<CoberturaInmueble> coberturaInmueble) {
		this.coberturaInmueble = coberturaInmueble;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

}

package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BienAsegurado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6256722290674498864L;

	@JsonProperty("ClaseBien")
	private String claseBien;

	@JsonProperty("Descripcion")
	private String descripcion;

	@JsonProperty("IdBienAsegurado")
	private String idBienAsegurado;

	@JsonProperty("NumCert")
	private String NumCert;

	@JsonProperty("StsBien")
	private String stsBien;

	@JsonProperty("TipoBienAsegurable")
	private String tipoBienAsegurable;

	@JsonProperty("CoberturaBien")
	private List<CoberturaBien> coberturaBien;

	public String getClaseBien() {
		return claseBien;
	}

	public void setClaseBien(String claseBien) {
		this.claseBien = claseBien;
	}

	public List<CoberturaBien> getCoberturaBien() {
		return coberturaBien;
	}

	public void setCoberturaBien(List<CoberturaBien> coberturaBien) {
		this.coberturaBien = coberturaBien;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdBienAsegurado() {
		return idBienAsegurado;
	}

	public void setIdBienAsegurado(String idBienAsegurado) {
		this.idBienAsegurado = idBienAsegurado;
	}

	public String getNumCert() {
		return NumCert;
	}

	public void setNumCert(String numCert) {
		NumCert = numCert;
	}

	public String getStsBien() {
		return stsBien;
	}

	public void setStsBien(String stsBien) {
		this.stsBien = stsBien;
	}

	public String getTipoBienAsegurable() {
		return tipoBienAsegurable;
	}

	public void setTipoBienAsegurable(String tipoBienAsegurable) {
		this.tipoBienAsegurable = tipoBienAsegurable;
	}

	@Override
	public String toString() {
		return "BienAsegurado [claseBien=" + claseBien + ", descripcion=" + descripcion + ", idBienAsegurado="
				+ idBienAsegurado + ", NumCert=" + NumCert + ", stsBien=" + stsBien + ", tipoBienAsegurable="
				+ tipoBienAsegurable + ", coberturaBien=" + coberturaBien + "]";
	}

}

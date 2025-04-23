package mx.com.allianz.model;

import java.io.Serializable;

public class ComunicadoJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6168871186788351842L;

	private String idComunicado;
	private String tituloComunicado;
	private String versionComunicado;
	private String contenidoComunicado;
	private boolean estatus;

	public String getIdComunicado() {
		return idComunicado;
	}

	public void setIdComunicado(String idComunicado) {
		this.idComunicado = idComunicado;
	}

	public String getTituloComunicado() {
		return tituloComunicado;
	}

	public void setTituloComunicado(String tituloComunicado) {
		this.tituloComunicado = tituloComunicado;
	}

	public String getVersionComunicado() {
		return versionComunicado;
	}

	public void setVersionComunicado(String versionComunicado) {
		this.versionComunicado = versionComunicado;
	}

	public String getContenidoComunicado() {
		return contenidoComunicado;
	}

	public void setContenidoComunicado(String contenidoComunicado) {
		this.contenidoComunicado = contenidoComunicado;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "ComunicadoJson [idComunicado=" + idComunicado + ", tituloComunicado=" + tituloComunicado
				+ ", versionComunicado=" + versionComunicado + ", contenidoComunicado=" + contenidoComunicado
				+ ", estatus=" + estatus + "]";
	}
}
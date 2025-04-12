package mx.com.allianz.model;

import java.io.Serializable;

public class ResponseHeaderModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4603759934314373933L;

	private Boolean isContratante;
	private String codCliIntegrador;

	public Boolean getIsContratante() {
		return isContratante;
	}

	public void setIsContratante(Boolean isContratante) {
		this.isContratante = isContratante;
	}

	public String getCodCliIntegrador() {
		return codCliIntegrador;
	}

	public void setCodCliIntegrador(String codCliIntegrador) {
		this.codCliIntegrador = codCliIntegrador;
	}

}

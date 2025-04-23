package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeyendaMosaico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2720345113556845695L;
	@JsonProperty("Etiqueta")
	public String etiqueta;
	@JsonProperty("Valor")
	public String valor;
	@JsonProperty("Monto")
	public String monto;
	@JsonProperty("IDEPOL_CODCLI")
	public String IDEPOL_CODCLI;

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getIDEPOL_CODCLI() {
		return IDEPOL_CODCLI;
	}

	public void setIDEPOL_CODCLI(String iDEPOL_CODCLI) {
		IDEPOL_CODCLI = iDEPOL_CODCLI;
	}

	@Override
	public String toString() {
		return "LeyendaMosaico [etiqueta=" + etiqueta + ", valor=" + valor + ", monto=" + monto + ", IDEPOL_CODCLI="
				+ IDEPOL_CODCLI + "]";
	}

}

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

	@Override
	public String toString() {
		return "LeyendaMosaico [etiqueta=" + etiqueta + ", valor=" + valor + ", monto=" + monto + "]";
	}

}

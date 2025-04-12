package mx.com.allianz.model;

import java.io.Serializable;

public class ParametroRequestModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 8823626482058194707L;

	private String parametro;

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String toString() {
		return "ParametroRequestModel [parametro=" + parametro + "]";
	}

}

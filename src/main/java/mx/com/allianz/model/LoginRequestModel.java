package mx.com.allianz.model;

import java.io.Serializable;

public class LoginRequestModel extends UsuarioRequestModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 4516897335082566058L;

	private String password;
	private String coordenadas;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	@Override
	public String toString() {
		return "LoginRequestModel [password=" + password + ", coordenadas=" + coordenadas + "]";
	}

}

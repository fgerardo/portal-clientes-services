package mx.com.allianz.commons.model;

import java.io.Serializable;

public class RespuestaGenericaLogin implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 999325535193219162L;

	private int estatus;
	private String rol;
	private String encrypt;

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	@Override
	public String toString() {
		return "RespuestaGenericaLogin [estatus=" + estatus + ", rol=" + rol + ", encrypt=" + encrypt + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;

public class UsuarioRequestModel implements Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -3188192257390310220L;
	private String usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioRequestModel [usuario=" + usuario + "]";
	}

}

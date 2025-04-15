package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DescripcionCoberturasModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8637771550335127159L;

	private ArrayList<String> descripcion;

	public ArrayList<String> getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(ArrayList<String> descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "DescripcionCoberturasModel [descripcion=" + descripcion + "]";
	}

}

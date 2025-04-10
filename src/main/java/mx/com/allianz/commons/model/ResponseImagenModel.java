package mx.com.allianz.commons.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseImagenModel implements Serializable {
	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -867133220527138379L;
	private String idImagen;
	private byte[] imagen;

	// Constructor
	public ResponseImagenModel(String idImagen, byte[] imagen) {
		this.idImagen = idImagen;
		this.imagen = imagen;
	}

	public ResponseImagenModel() {
	}

	@XmlElement
	public String getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(String idImagen) {
		this.idImagen = idImagen;
	}

	@XmlElement
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

}

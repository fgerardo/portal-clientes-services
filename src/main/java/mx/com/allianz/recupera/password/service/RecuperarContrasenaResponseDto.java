package mx.com.allianz.recupera.password.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecuperarContrasenaResponseDto", namespace = "http://dto.services.admincontrasenas.web.habil.com", propOrder = {
		"mensaje", "response" })
public class RecuperarContrasenaResponseDto {

	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String mensaje;
	protected boolean response;

	/**
	 * Obtiene el valor de la propiedad mensaje.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Define el valor de la propiedad mensaje.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMensaje(String value) {
		this.mensaje = value;
	}

	/**
	 * Obtiene el valor de la propiedad response.
	 * 
	 */
	public boolean isResponse() {
		return response;
	}

	/**
	 * Define el valor de la propiedad response.
	 * 
	 */
	public void setResponse(boolean value) {
		this.response = value;
	}

	@Override
	public String toString() {
		return "RecuperarContrasenaResponseDto [mensaje=" + mensaje + ", response=" + response + "]";
	}

}

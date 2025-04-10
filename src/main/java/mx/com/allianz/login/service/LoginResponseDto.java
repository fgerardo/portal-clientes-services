package mx.com.allianz.login.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResponseDto", namespace = "http://services.admincontrasenas.web.habil.com", propOrder = {
		"cookieDto", "mensaje", "response" })
public class LoginResponseDto {

//	@XmlElement(required = true, nillable = true)
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected CookieDto cookieDto;
//	@XmlElement(required = true, nillable = true)
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String mensaje;
	@XmlElement(namespace = "http://services.admincontrasenas.web.habil.com")
	protected boolean response;

	/**
	 * Obtiene el valor de la propiedad cookieDto.
	 * 
	 * @return possible object is {@link CookieDto }
	 * 
	 */
	public CookieDto getCookieDto() {
		return cookieDto;
	}

	/**
	 * Define el valor de la propiedad cookieDto.
	 * 
	 * @param value allowed object is {@link CookieDto }
	 * 
	 */
	public void setCookieDto(CookieDto value) {
		this.cookieDto = value;
	}

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
		return "LoginResponseDto [cookieDto=" + cookieDto + ", mensaje=" + mensaje + ", response=" + response + "]";
	}

}

package mx.com.allianz.login.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CookieDto", namespace = "http://dto.services.admincontrasenas.web.habil.com", propOrder = { "dominio",
		"nombreCookie", "path", "secure", "token", "value" })
public class CookieDto {

	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String dominio;
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String nombreCookie;
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String path;
	protected boolean secure;
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String token;
	@XmlElement(required = true, nillable = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected String value;

	/**
	 * Obtiene el valor de la propiedad dominio.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDominio() {
		return dominio;
	}

	/**
	 * Define el valor de la propiedad dominio.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDominio(String value) {
		this.dominio = value;
	}

	/**
	 * Obtiene el valor de la propiedad nombreCookie.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreCookie() {
		return nombreCookie;
	}

	/**
	 * Define el valor de la propiedad nombreCookie.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNombreCookie(String value) {
		this.nombreCookie = value;
	}

	/**
	 * Obtiene el valor de la propiedad path.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Define el valor de la propiedad path.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPath(String value) {
		this.path = value;
	}

	/**
	 * Obtiene el valor de la propiedad secure.
	 * 
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * Define el valor de la propiedad secure.
	 * 
	 */
	public void setSecure(boolean value) {
		this.secure = value;
	}

	/**
	 * Obtiene el valor de la propiedad token.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Define el valor de la propiedad token.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * Obtiene el valor de la propiedad value.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Define el valor de la propiedad value.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

}

package mx.com.allianz.recupera.password.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "email", "uid" })
@XmlRootElement(name = "recuperarContrasena", namespace = "http://services.admincontrasenas.web.habil.com")
public class RecuperarContrasena {

	@XmlElement(required = true)
	protected String email;
	@XmlElement(required = true)
	protected String uid;

	/**
	 * Obtiene el valor de la propiedad email.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Define el valor de la propiedad email.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Obtiene el valor de la propiedad uid.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Define el valor de la propiedad uid.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUid(String value) {
		this.uid = value;
	}

}

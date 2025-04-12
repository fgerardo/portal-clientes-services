package mx.com.allianz.cipher.service;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "decryptResponse", namespace = "http://service.ws.security.commons.az.habil.com", propOrder = {
		"outPlainText" })
@XmlRootElement(name = "decryptResponse", namespace = "http://service.ws.security.commons.az.habil.com")
public class DecryptResponse {

	protected String outPlainText;

	/**
	 * Obtiene el valor de la propiedad outPlainText.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOutPlainText() {
		return outPlainText;
	}

	/**
	 * Define el valor de la propiedad outPlainText.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOutPlainText(String value) {
		this.outPlainText = value;
	}

}

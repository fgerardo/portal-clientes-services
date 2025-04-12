//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.12.23 a las 12:54:09 AM CST 
//


package mx.com.allianz.cipher.service;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "decrypt", namespace = "http://service.ws.security.commons.az.habil.com", propOrder = {
	    "inCryptText"
	})
	@XmlRootElement(name = "decrypt", namespace = "http://service.ws.security.commons.az.habil.com")
public class Decrypt {

    protected String inCryptText;

    /**
     * Obtiene el valor de la propiedad inCryptText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInCryptText() {
        return inCryptText;
    }

    /**
     * Define el valor de la propiedad inCryptText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInCryptText(String value) {
        this.inCryptText = value;
    }

}

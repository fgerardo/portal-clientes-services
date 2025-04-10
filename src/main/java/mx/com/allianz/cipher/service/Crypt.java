package mx.com.allianz.cipher.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crypt", namespace = "http://service.ws.security.commons.az.habil.com", propOrder = {
    "inPlainText"
})
@XmlRootElement(name = "crypt", namespace = "http://service.ws.security.commons.az.habil.com")
public class Crypt {

    protected String inPlainText;

    /**
     * Obtiene el valor de la propiedad inPlainText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInPlainText() {
        return inPlainText;
    }

    /**
     * Define el valor de la propiedad inPlainText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInPlainText(String value) {
        this.inPlainText = value;
    }

}

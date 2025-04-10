package mx.com.allianz.cipher.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cryptResponse", namespace = "http://service.ws.security.commons.az.habil.com", propOrder = {
    "outCrypText"
})
@XmlRootElement(name = "cryptResponse")
public class CryptResponse {

    protected String outCrypText;

    /**
     * Obtiene el valor de la propiedad outCrypText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutCrypText() {
        return outCrypText;
    }

    /**
     * Define el valor de la propiedad outCrypText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutCrypText(String value) {
        this.outCrypText = value;
    }

}

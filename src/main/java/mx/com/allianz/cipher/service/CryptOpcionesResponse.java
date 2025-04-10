//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.12.23 a las 12:54:09 AM CST 
//


package mx.com.allianz.cipher.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cryptOpcionesResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cryptOpcionesResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outCrypTextOpciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cryptOpcionesResponse", propOrder = {
    "outCrypTextOpciones"
})
public class CryptOpcionesResponse {

    protected String outCrypTextOpciones;

    /**
     * Obtiene el valor de la propiedad outCrypTextOpciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutCrypTextOpciones() {
        return outCrypTextOpciones;
    }

    /**
     * Define el valor de la propiedad outCrypTextOpciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutCrypTextOpciones(String value) {
        this.outCrypTextOpciones = value;
    }

}

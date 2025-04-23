//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.23 a las 01:25:46 PM CST 
//

package mx.com.allianz.central.comunicados.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para CodigoErrorDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CodigoErrorDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodigoErrorDto", propOrder = { "codigoError", "mensajeError" })
public class CodigoErrorDto {

	@XmlElement(required = true, nillable = true)
	protected String codigoError;
	@XmlElement(required = true, nillable = true)
	protected String mensajeError;

	/**
	 * Obtiene el valor de la propiedad codigoError.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * Define el valor de la propiedad codigoError.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCodigoError(String value) {
		this.codigoError = value;
	}

	/**
	 * Obtiene el valor de la propiedad mensajeError.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * Define el valor de la propiedad mensajeError.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMensajeError(String value) {
		this.mensajeError = value;
	}

}

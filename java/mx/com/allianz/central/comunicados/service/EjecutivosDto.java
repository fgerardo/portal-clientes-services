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
 * Clase Java para EjecutivosDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EjecutivosDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveEjecutivo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descEjecutivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EjecutivosDto", propOrder = { "claveEjecutivo", "descEjecutivo" })
public class EjecutivosDto {

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer claveEjecutivo;
	@XmlElement(required = true, nillable = true)
	protected String descEjecutivo;

	/**
	 * Obtiene el valor de la propiedad claveEjecutivo.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getClaveEjecutivo() {
		return claveEjecutivo;
	}

	/**
	 * Define el valor de la propiedad claveEjecutivo.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setClaveEjecutivo(Integer value) {
		this.claveEjecutivo = value;
	}

	/**
	 * Obtiene el valor de la propiedad descEjecutivo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescEjecutivo() {
		return descEjecutivo;
	}

	/**
	 * Define el valor de la propiedad descEjecutivo.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescEjecutivo(String value) {
		this.descEjecutivo = value;
	}

}

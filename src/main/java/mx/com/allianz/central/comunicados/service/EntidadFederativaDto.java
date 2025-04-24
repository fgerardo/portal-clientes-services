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
 * Clase Java para EntidadFederativaDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EntidadFederativaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveEstdo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descEstado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntidadFederativaDto", propOrder = { "claveEstdo", "descEstado" })
public class EntidadFederativaDto {

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer claveEstdo;
	@XmlElement(required = true, nillable = true)
	protected String descEstado;

	/**
	 * Obtiene el valor de la propiedad claveEstdo.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getClaveEstdo() {
		return claveEstdo;
	}

	/**
	 * Define el valor de la propiedad claveEstdo.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setClaveEstdo(Integer value) {
		this.claveEstdo = value;
	}

	/**
	 * Obtiene el valor de la propiedad descEstado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescEstado() {
		return descEstado;
	}

	/**
	 * Define el valor de la propiedad descEstado.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescEstado(String value) {
		this.descEstado = value;
	}

}

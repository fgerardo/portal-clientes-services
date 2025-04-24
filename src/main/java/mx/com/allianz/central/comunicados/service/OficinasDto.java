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
 * Clase Java para OficinasDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OficinasDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveOficina" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descOficina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OficinasDto", propOrder = { "claveOficina", "descOficina" })
public class OficinasDto {

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer claveOficina;
	@XmlElement(required = true, nillable = true)
	protected String descOficina;

	/**
	 * Obtiene el valor de la propiedad claveOficina.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getClaveOficina() {
		return claveOficina;
	}

	/**
	 * Define el valor de la propiedad claveOficina.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setClaveOficina(Integer value) {
		this.claveOficina = value;
	}

	/**
	 * Obtiene el valor de la propiedad descOficina.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescOficina() {
		return descOficina;
	}

	/**
	 * Define el valor de la propiedad descOficina.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescOficina(String value) {
		this.descOficina = value;
	}

}

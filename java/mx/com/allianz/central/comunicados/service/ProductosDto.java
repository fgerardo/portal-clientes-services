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
 * Clase Java para ProductosDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ProductosDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductosDto", propOrder = { "claveProducto", "descProducto" })
public class ProductosDto {

	@XmlElement(required = true, nillable = true)
	protected String claveProducto;
	@XmlElement(required = true, nillable = true)
	protected String descProducto;

	/**
	 * Obtiene el valor de la propiedad claveProducto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClaveProducto() {
		return claveProducto;
	}

	/**
	 * Define el valor de la propiedad claveProducto.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setClaveProducto(String value) {
		this.claveProducto = value;
	}

	/**
	 * Obtiene el valor de la propiedad descProducto.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescProducto() {
		return descProducto;
	}

	/**
	 * Define el valor de la propiedad descProducto.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescProducto(String value) {
		this.descProducto = value;
	}

}

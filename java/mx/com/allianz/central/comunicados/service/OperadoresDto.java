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
 * Clase Java para OperadoresDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OperadoresDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idOperador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcionOperador" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperadoresDto", propOrder = { "idOperador", "operador", "descripcionOperador" })
public class OperadoresDto {

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer idOperador;
	@XmlElement(required = true, nillable = true)
	protected String operador;
	@XmlElement(required = true, nillable = true)
	protected String descripcionOperador;

	/**
	 * Obtiene el valor de la propiedad idOperador.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getIdOperador() {
		return idOperador;
	}

	/**
	 * Define el valor de la propiedad idOperador.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setIdOperador(Integer value) {
		this.idOperador = value;
	}

	/**
	 * Obtiene el valor de la propiedad operador.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Define el valor de la propiedad operador.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOperador(String value) {
		this.operador = value;
	}

	/**
	 * Obtiene el valor de la propiedad descripcionOperador.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescripcionOperador() {
		return descripcionOperador;
	}

	/**
	 * Define el valor de la propiedad descripcionOperador.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescripcionOperador(String value) {
		this.descripcionOperador = value;
	}

}

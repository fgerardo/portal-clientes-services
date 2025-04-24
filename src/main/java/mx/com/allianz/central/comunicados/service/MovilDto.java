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
 * Clase Java para MovilDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MovilDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idMovil" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoMovil" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovilDto", propOrder = { "idMovil", "correo", "tipoMovil" })
public class MovilDto {

	@XmlElement(required = true, nillable = true)
	protected String idMovil;
	@XmlElement(required = true, nillable = true)
	protected String correo;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long tipoMovil;

	/**
	 * Obtiene el valor de la propiedad idMovil.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdMovil() {
		return idMovil;
	}

	/**
	 * Define el valor de la propiedad idMovil.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIdMovil(String value) {
		this.idMovil = value;
	}

	/**
	 * Obtiene el valor de la propiedad correo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Define el valor de la propiedad correo.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCorreo(String value) {
		this.correo = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoMovil.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getTipoMovil() {
		return tipoMovil;
	}

	/**
	 * Define el valor de la propiedad tipoMovil.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setTipoMovil(Long value) {
		this.tipoMovil = value;
	}

}

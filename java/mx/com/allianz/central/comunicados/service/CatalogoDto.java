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
 * Clase Java para CatalogoDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CatalogoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCatalogo" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idActivo" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogoDto", propOrder = { "idCatalogo", "descripcion", "idActivo" })
public class CatalogoDto {

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idCatalogo;
	@XmlElement(required = true, nillable = true)
	protected String descripcion;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idActivo;

	/**
	 * Obtiene el valor de la propiedad idCatalogo.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdCatalogo() {
		return idCatalogo;
	}

	/**
	 * Define el valor de la propiedad idCatalogo.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdCatalogo(Long value) {
		this.idCatalogo = value;
	}

	/**
	 * Obtiene el valor de la propiedad descripcion.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Define el valor de la propiedad descripcion.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	/**
	 * Obtiene el valor de la propiedad idActivo.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdActivo() {
		return idActivo;
	}

	/**
	 * Define el valor de la propiedad idActivo.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdActivo(Long value) {
		this.idActivo = value;
	}

}

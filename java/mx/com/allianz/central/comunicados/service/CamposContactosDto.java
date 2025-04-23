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
 * Clase Java para CamposContactosDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CamposContactosDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCampo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="campo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idTipoCampo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CamposContactosDto", propOrder = { "idCampo", "campo", "idTipoCampo" })
public class CamposContactosDto {

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer idCampo;
	@XmlElement(required = true, nillable = true)
	protected String campo;
	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer idTipoCampo;

	/**
	 * Obtiene el valor de la propiedad idCampo.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getIdCampo() {
		return idCampo;
	}

	/**
	 * Define el valor de la propiedad idCampo.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setIdCampo(Integer value) {
		this.idCampo = value;
	}

	/**
	 * Obtiene el valor de la propiedad campo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * Define el valor de la propiedad campo.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCampo(String value) {
		this.campo = value;
	}

	/**
	 * Obtiene el valor de la propiedad idTipoCampo.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getIdTipoCampo() {
		return idTipoCampo;
	}

	/**
	 * Define el valor de la propiedad idTipoCampo.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setIdTipoCampo(Integer value) {
		this.idTipoCampo = value;
	}

}

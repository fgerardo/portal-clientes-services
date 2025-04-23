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
 * Clase Java para ContactoDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ContactoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="razonSocial" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefonoP" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefonoA" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descEstado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descOficina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descEjecutivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoAudiencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="edad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactoDto", propOrder = { "nombre", "aPaterno", "aMaterno", "razonSocial", "correo", "telefonoP",
		"telefonoA", "descProducto", "sexo", "descEstado", "descOficina", "descEjecutivo", "tipoAudiencia", "edad" })
public class ContactoDto {

	@XmlElement(required = true, nillable = true)
	protected String nombre;
	@XmlElement(required = true, nillable = true)
	protected String aPaterno;
	@XmlElement(required = true, nillable = true)
	protected String aMaterno;
	@XmlElement(required = true, nillable = true)
	protected String razonSocial;
	@XmlElement(required = true, nillable = true)
	protected String correo;
	@XmlElement(required = true, nillable = true)
	protected String telefonoP;
	@XmlElement(required = true, nillable = true)
	protected String telefonoA;
	@XmlElement(required = true, nillable = true)
	protected String descProducto;
	@XmlElement(required = true, nillable = true)
	protected String sexo;
	@XmlElement(required = true, nillable = true)
	protected String descEstado;
	@XmlElement(required = true, nillable = true)
	protected String descOficina;
	@XmlElement(required = true, nillable = true)
	protected String descEjecutivo;
	@XmlElement(required = true, nillable = true)
	protected String tipoAudiencia;
	@XmlElement(required = true, nillable = true)
	protected String edad;

	/**
	 * Obtiene el valor de la propiedad nombre.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Define el valor de la propiedad nombre.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}

	/**
	 * Obtiene el valor de la propiedad aPaterno.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAPaterno() {
		return aPaterno;
	}

	/**
	 * Define el valor de la propiedad aPaterno.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAPaterno(String value) {
		this.aPaterno = value;
	}

	/**
	 * Obtiene el valor de la propiedad aMaterno.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAMaterno() {
		return aMaterno;
	}

	/**
	 * Define el valor de la propiedad aMaterno.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAMaterno(String value) {
		this.aMaterno = value;
	}

	/**
	 * Obtiene el valor de la propiedad razonSocial.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * Define el valor de la propiedad razonSocial.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRazonSocial(String value) {
		this.razonSocial = value;
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
	 * Obtiene el valor de la propiedad telefonoP.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelefonoP() {
		return telefonoP;
	}

	/**
	 * Define el valor de la propiedad telefonoP.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTelefonoP(String value) {
		this.telefonoP = value;
	}

	/**
	 * Obtiene el valor de la propiedad telefonoA.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelefonoA() {
		return telefonoA;
	}

	/**
	 * Define el valor de la propiedad telefonoA.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTelefonoA(String value) {
		this.telefonoA = value;
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

	/**
	 * Obtiene el valor de la propiedad sexo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Define el valor de la propiedad sexo.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSexo(String value) {
		this.sexo = value;
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

	/**
	 * Obtiene el valor de la propiedad tipoAudiencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoAudiencia() {
		return tipoAudiencia;
	}

	/**
	 * Define el valor de la propiedad tipoAudiencia.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTipoAudiencia(String value) {
		this.tipoAudiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad edad.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * Define el valor de la propiedad edad.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEdad(String value) {
		this.edad = value;
	}

}

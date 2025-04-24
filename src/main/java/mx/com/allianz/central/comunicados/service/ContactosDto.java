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
 * Clase Java para ContactosDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ContactosDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="appPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="appMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="correoElectronico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactosDto", propOrder = { "nombre", "appPaterno", "appMaterno", "correoElectronico", "telefono" })
public class ContactosDto {

	@XmlElement(required = true, nillable = true)
	protected String nombre;
	@XmlElement(required = true, nillable = true)
	protected String appPaterno;
	@XmlElement(required = true, nillable = true)
	protected String appMaterno;
	@XmlElement(required = true, nillable = true)
	protected String correoElectronico;
	@XmlElement(required = true, nillable = true)
	protected String telefono;

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
	 * Obtiene el valor de la propiedad appPaterno.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppPaterno() {
		return appPaterno;
	}

	/**
	 * Define el valor de la propiedad appPaterno.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAppPaterno(String value) {
		this.appPaterno = value;
	}

	/**
	 * Obtiene el valor de la propiedad appMaterno.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppMaterno() {
		return appMaterno;
	}

	/**
	 * Define el valor de la propiedad appMaterno.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAppMaterno(String value) {
		this.appMaterno = value;
	}

	/**
	 * Obtiene el valor de la propiedad correoElectronico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Define el valor de la propiedad correoElectronico.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCorreoElectronico(String value) {
		this.correoElectronico = value;
	}

	/**
	 * Obtiene el valor de la propiedad telefono.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Define el valor de la propiedad telefono.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTelefono(String value) {
		this.telefono = value;
	}

}

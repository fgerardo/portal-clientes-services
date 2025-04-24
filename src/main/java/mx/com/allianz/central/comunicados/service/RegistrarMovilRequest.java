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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="movil" type="{http://dto.centralcomunicados.allianz.com.mx}MovilDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "movil" })
@XmlRootElement(name = "RegistrarMovilRequest", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx")
public class RegistrarMovilRequest {

	@XmlElement(namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx", required = true)
	protected MovilDto movil;

	/**
	 * Obtiene el valor de la propiedad movil.
	 * 
	 * @return possible object is {@link MovilDto }
	 * 
	 */
	public MovilDto getMovil() {
		return movil;
	}

	/**
	 * Define el valor de la propiedad movil.
	 * 
	 * @param value allowed object is {@link MovilDto }
	 * 
	 */
	public void setMovil(MovilDto value) {
		this.movil = value;
	}

}

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
 *         &lt;element name="ActualizarMovil" type="{http://dto.centralcomunicados.allianz.com.mx}MovilesResponseDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "actualizarMovil" })
@XmlRootElement(name = "ActualizarMovilResponse", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx")
public class ActualizarMovilResponse {

	@XmlElement(name = "ActualizarMovil", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx", required = true)
	protected MovilesResponseDto actualizarMovil;

	/**
	 * Obtiene el valor de la propiedad actualizarMovil.
	 * 
	 * @return possible object is {@link MovilesResponseDto }
	 * 
	 */
	public MovilesResponseDto getActualizarMovil() {
		return actualizarMovil;
	}

	/**
	 * Define el valor de la propiedad actualizarMovil.
	 * 
	 * @param value allowed object is {@link MovilesResponseDto }
	 * 
	 */
	public void setActualizarMovil(MovilesResponseDto value) {
		this.actualizarMovil = value;
	}

}

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
 *         &lt;element name="version" type="{http://dto.centralcomunicados.allianz.com.mx}VersionComunicadoResponseDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "version" })
@XmlRootElement(name = "ObtenerVersionComunicadoResponse", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx")
public class ObtenerVersionComunicadoResponse {

	@XmlElement(namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx", required = true)
	protected VersionComunicadoResponseDto version;

	/**
	 * Obtiene el valor de la propiedad version.
	 * 
	 * @return possible object is {@link VersionComunicadoResponseDto }
	 * 
	 */
	public VersionComunicadoResponseDto getVersion() {
		return version;
	}

	/**
	 * Define el valor de la propiedad version.
	 * 
	 * @param value allowed object is {@link VersionComunicadoResponseDto }
	 * 
	 */
	public void setVersion(VersionComunicadoResponseDto value) {
		this.version = value;
	}

}

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
 * Clase Java para VersionComunicadoResponseDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VersionComunicadoResponseDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://dto.centralcomunicados.allianz.com.mx}CodigoErrorDto"/&gt;
 *         &lt;element name="VersionComunicadoDto" type="{http://dto.centralcomunicados.allianz.com.mx}VersionComunicadoDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionComunicadoResponseDto", propOrder = { "codigoError", "versionComunicadoDto" })
public class VersionComunicadoResponseDto {

	@XmlElement(required = true, nillable = true)
	protected CodigoErrorDto codigoError;
	@XmlElement(name = "VersionComunicadoDto", required = true, nillable = true)
	protected VersionComunicadoDto versionComunicadoDto;

	/**
	 * Obtiene el valor de la propiedad codigoError.
	 * 
	 * @return possible object is {@link CodigoErrorDto }
	 * 
	 */
	public CodigoErrorDto getCodigoError() {
		return codigoError;
	}

	/**
	 * Define el valor de la propiedad codigoError.
	 * 
	 * @param value allowed object is {@link CodigoErrorDto }
	 * 
	 */
	public void setCodigoError(CodigoErrorDto value) {
		this.codigoError = value;
	}

	/**
	 * Obtiene el valor de la propiedad versionComunicadoDto.
	 * 
	 * @return possible object is {@link VersionComunicadoDto }
	 * 
	 */
	public VersionComunicadoDto getVersionComunicadoDto() {
		return versionComunicadoDto;
	}

	/**
	 * Define el valor de la propiedad versionComunicadoDto.
	 * 
	 * @param value allowed object is {@link VersionComunicadoDto }
	 * 
	 */
	public void setVersionComunicadoDto(VersionComunicadoDto value) {
		this.versionComunicadoDto = value;
	}

}

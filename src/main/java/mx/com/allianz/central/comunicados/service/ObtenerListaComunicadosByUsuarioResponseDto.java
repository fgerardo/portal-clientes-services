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
 * Clase Java para ObtenerListaComunicadosByUsuarioResponseDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ObtenerListaComunicadosByUsuarioResponseDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://dto.centralcomunicados.allianz.com.mx}CodigoErrorDto"/&gt;
 *         &lt;element name="listaComunicadosDto" type="{http://dto.centralcomunicados.allianz.com.mx}ListaComunicadosDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObtenerListaComunicadosByUsuarioResponseDto", propOrder = { "codigoError", "listaComunicadosDto" })
public class ObtenerListaComunicadosByUsuarioResponseDto {

	@XmlElement(required = true, nillable = true)
	protected CodigoErrorDto codigoError;
	@XmlElement(required = true, nillable = true)
	protected ListaComunicadosDto listaComunicadosDto;

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
	 * Obtiene el valor de la propiedad listaComunicadosDto.
	 * 
	 * @return possible object is {@link ListaComunicadosDto }
	 * 
	 */
	public ListaComunicadosDto getListaComunicadosDto() {
		return listaComunicadosDto;
	}

	/**
	 * Define el valor de la propiedad listaComunicadosDto.
	 * 
	 * @param value allowed object is {@link ListaComunicadosDto }
	 * 
	 */
	public void setListaComunicadosDto(ListaComunicadosDto value) {
		this.listaComunicadosDto = value;
	}

}

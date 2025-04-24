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
 * Clase Java para ComunicadoRespuestaDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComunicadoRespuestaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://dto.centralcomunicados.allianz.com.mx}CodigoErrorDto"/&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="idComunicado" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComunicadoRespuestaDto", propOrder = { "codigoError", "resultado", "idComunicado", "version" })
public class ComunicadoRespuestaDto {

	@XmlElement(required = true, nillable = true)
	protected CodigoErrorDto codigoError;
	@XmlElement(required = true, type = Boolean.class, nillable = true)
	protected Boolean resultado;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idComunicado;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long version;

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
	 * Obtiene el valor de la propiedad resultado.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isResultado() {
		return resultado;
	}

	/**
	 * Define el valor de la propiedad resultado.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setResultado(Boolean value) {
		this.resultado = value;
	}

	/**
	 * Obtiene el valor de la propiedad idComunicado.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdComunicado() {
		return idComunicado;
	}

	/**
	 * Define el valor de la propiedad idComunicado.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdComunicado(Long value) {
		this.idComunicado = value;
	}

	/**
	 * Obtiene el valor de la propiedad version.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * Define el valor de la propiedad version.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setVersion(Long value) {
		this.version = value;
	}

}

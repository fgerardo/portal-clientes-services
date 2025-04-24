//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.23 a las 01:25:46 PM CST 
//

package mx.com.allianz.central.comunicados.service;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ParametrosDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ParametrosDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="horaEnvio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estatusComunicado" type="{http://dto.centralcomunicados.allianz.com.mx}CatalogoDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametrosDto", propOrder = { "fechaEnvio", "horaEnvio", "estatusComunicado" })
public class ParametrosDto {

	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar fechaEnvio;
	@XmlElement(required = true, nillable = true)
	protected String horaEnvio;
	@XmlElement(required = true, nillable = true)
	protected CatalogoDto estatusComunicado;

	/**
	 * Obtiene el valor de la propiedad fechaEnvio.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * Define el valor de la propiedad fechaEnvio.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setFechaEnvio(XMLGregorianCalendar value) {
		this.fechaEnvio = value;
	}

	/**
	 * Obtiene el valor de la propiedad horaEnvio.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHoraEnvio() {
		return horaEnvio;
	}

	/**
	 * Define el valor de la propiedad horaEnvio.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHoraEnvio(String value) {
		this.horaEnvio = value;
	}

	/**
	 * Obtiene el valor de la propiedad estatusComunicado.
	 * 
	 * @return possible object is {@link CatalogoDto }
	 * 
	 */
	public CatalogoDto getEstatusComunicado() {
		return estatusComunicado;
	}

	/**
	 * Define el valor de la propiedad estatusComunicado.
	 * 
	 * @param value allowed object is {@link CatalogoDto }
	 * 
	 */
	public void setEstatusComunicado(CatalogoDto value) {
		this.estatusComunicado = value;
	}

}

//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.23 a las 01:25:46 PM CST 
//

package mx.com.allianz.central.comunicados.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ProgramacionComunicadoDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ProgramacionComunicadoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dto.centralcomunicados.allianz.com.mx}ComunicadoDto"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idProgramacionComunicado" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="canales" type="{http://dto.centralcomunicados.allianz.com.mx}CatalogoDto" maxOccurs="unbounded"/&gt;
 *         &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="fechaEnvioString" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="horaEnvio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramacionComunicadoDto", propOrder = { "idProgramacionComunicado", "canales", "fechaEnvio",
		"fechaEnvioString", "horaEnvio" })
public class ProgramacionComunicadoDto extends ComunicadoDto {

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idProgramacionComunicado;
	@XmlElement(required = true, nillable = true)
	protected List<CatalogoDto> canales;
	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar fechaEnvio;
	@XmlElement(required = true, nillable = true)
	protected String fechaEnvioString;
	@XmlElement(required = true, nillable = true)
	protected String horaEnvio;

	/**
	 * Obtiene el valor de la propiedad idProgramacionComunicado.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdProgramacionComunicado() {
		return idProgramacionComunicado;
	}

	/**
	 * Define el valor de la propiedad idProgramacionComunicado.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdProgramacionComunicado(Long value) {
		this.idProgramacionComunicado = value;
	}

	/**
	 * Gets the value of the canales property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the canales property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCanales().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CatalogoDto }
	 * 
	 * 
	 */
	public List<CatalogoDto> getCanales() {
		if (canales == null) {
			canales = new ArrayList<CatalogoDto>();
		}
		return this.canales;
	}

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
	 * Obtiene el valor de la propiedad fechaEnvioString.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFechaEnvioString() {
		return fechaEnvioString;
	}

	/**
	 * Define el valor de la propiedad fechaEnvioString.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFechaEnvioString(String value) {
		this.fechaEnvioString = value;
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

}

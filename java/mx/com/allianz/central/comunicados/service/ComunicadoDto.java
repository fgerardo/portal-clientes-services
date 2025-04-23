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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ComunicadoDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComunicadoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dto.centralcomunicados.allianz.com.mx}AudienciaDto"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idComunicado" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="contenido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idEstatus" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="descEstatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idCanal" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="descCanal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreTrigger" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idTipoComunicado" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="descTipoComunicado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComunicadoDto", propOrder = { "idComunicado", "titulo", "contenido", "version", "idEstatus",
		"descEstatus", "idCanal", "descCanal", "query", "nombreTrigger", "idTipoComunicado", "descTipoComunicado" })
@XmlSeeAlso({ ProgramacionComunicadoDto.class })
public class ComunicadoDto extends AudienciaDto {

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idComunicado;
	@XmlElement(required = true, nillable = true)
	protected String titulo;
	@XmlElement(required = true, nillable = true)
	protected String contenido;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long version;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idEstatus;
	@XmlElement(required = true, nillable = true)
	protected String descEstatus;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idCanal;
	@XmlElement(required = true, nillable = true)
	protected String descCanal;
	@XmlElement(required = true, nillable = true)
	protected String query;
	@XmlElement(required = true, nillable = true)
	protected String nombreTrigger;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idTipoComunicado;
	@XmlElement(required = true, nillable = true)
	protected String descTipoComunicado;

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
	 * Obtiene el valor de la propiedad titulo.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Define el valor de la propiedad titulo.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTitulo(String value) {
		this.titulo = value;
	}

	/**
	 * Obtiene el valor de la propiedad contenido.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Define el valor de la propiedad contenido.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setContenido(String value) {
		this.contenido = value;
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

	/**
	 * Obtiene el valor de la propiedad idEstatus.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdEstatus() {
		return idEstatus;
	}

	/**
	 * Define el valor de la propiedad idEstatus.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdEstatus(Long value) {
		this.idEstatus = value;
	}

	/**
	 * Obtiene el valor de la propiedad descEstatus.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescEstatus() {
		return descEstatus;
	}

	/**
	 * Define el valor de la propiedad descEstatus.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescEstatus(String value) {
		this.descEstatus = value;
	}

	/**
	 * Obtiene el valor de la propiedad idCanal.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdCanal() {
		return idCanal;
	}

	/**
	 * Define el valor de la propiedad idCanal.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdCanal(Long value) {
		this.idCanal = value;
	}

	/**
	 * Obtiene el valor de la propiedad descCanal.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescCanal() {
		return descCanal;
	}

	/**
	 * Define el valor de la propiedad descCanal.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescCanal(String value) {
		this.descCanal = value;
	}

	/**
	 * Obtiene el valor de la propiedad query.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * Define el valor de la propiedad query.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setQuery(String value) {
		this.query = value;
	}

	/**
	 * Obtiene el valor de la propiedad nombreTrigger.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreTrigger() {
		return nombreTrigger;
	}

	/**
	 * Define el valor de la propiedad nombreTrigger.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNombreTrigger(String value) {
		this.nombreTrigger = value;
	}

	/**
	 * Obtiene el valor de la propiedad idTipoComunicado.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdTipoComunicado() {
		return idTipoComunicado;
	}

	/**
	 * Define el valor de la propiedad idTipoComunicado.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdTipoComunicado(Long value) {
		this.idTipoComunicado = value;
	}

	/**
	 * Obtiene el valor de la propiedad descTipoComunicado.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescTipoComunicado() {
		return descTipoComunicado;
	}

	/**
	 * Define el valor de la propiedad descTipoComunicado.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescTipoComunicado(String value) {
		this.descTipoComunicado = value;
	}

}

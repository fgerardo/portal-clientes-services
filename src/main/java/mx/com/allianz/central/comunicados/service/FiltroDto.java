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
 * Clase Java para FiltroDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FiltroDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFiltro" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idTipoAudiencia" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="tipoAudiencia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreColumna" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="valorColumna" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="condicional" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="condicionalEtiqueta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="operacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="operacionEtiqueta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idTipoCampo" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idCampo" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idOperador" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiltroDto", propOrder = { "idFiltro", "idTipoAudiencia", "tipoAudiencia", "nombreColumna",
		"valorColumna", "condicional", "condicionalEtiqueta", "operacion", "operacionEtiqueta", "idTipoCampo",
		"idCampo", "idOperador" })
public class FiltroDto {

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idFiltro;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idTipoAudiencia;
	@XmlElement(required = true, nillable = true)
	protected String tipoAudiencia;
	@XmlElement(required = true, nillable = true)
	protected String nombreColumna;
	@XmlElement(required = true, nillable = true)
	protected String valorColumna;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long condicional;
	@XmlElement(required = true, nillable = true)
	protected String condicionalEtiqueta;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long operacion;
	@XmlElement(required = true, nillable = true)
	protected String operacionEtiqueta;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idTipoCampo;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idCampo;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long idOperador;

	/**
	 * Obtiene el valor de la propiedad idFiltro.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdFiltro() {
		return idFiltro;
	}

	/**
	 * Define el valor de la propiedad idFiltro.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdFiltro(Long value) {
		this.idFiltro = value;
	}

	/**
	 * Obtiene el valor de la propiedad idTipoAudiencia.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdTipoAudiencia() {
		return idTipoAudiencia;
	}

	/**
	 * Define el valor de la propiedad idTipoAudiencia.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdTipoAudiencia(Long value) {
		this.idTipoAudiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad tipoAudiencia.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTipoAudiencia() {
		return tipoAudiencia;
	}

	/**
	 * Define el valor de la propiedad tipoAudiencia.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTipoAudiencia(String value) {
		this.tipoAudiencia = value;
	}

	/**
	 * Obtiene el valor de la propiedad nombreColumna.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNombreColumna() {
		return nombreColumna;
	}

	/**
	 * Define el valor de la propiedad nombreColumna.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNombreColumna(String value) {
		this.nombreColumna = value;
	}

	/**
	 * Obtiene el valor de la propiedad valorColumna.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValorColumna() {
		return valorColumna;
	}

	/**
	 * Define el valor de la propiedad valorColumna.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setValorColumna(String value) {
		this.valorColumna = value;
	}

	/**
	 * Obtiene el valor de la propiedad condicional.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getCondicional() {
		return condicional;
	}

	/**
	 * Define el valor de la propiedad condicional.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setCondicional(Long value) {
		this.condicional = value;
	}

	/**
	 * Obtiene el valor de la propiedad condicionalEtiqueta.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCondicionalEtiqueta() {
		return condicionalEtiqueta;
	}

	/**
	 * Define el valor de la propiedad condicionalEtiqueta.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCondicionalEtiqueta(String value) {
		this.condicionalEtiqueta = value;
	}

	/**
	 * Obtiene el valor de la propiedad operacion.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getOperacion() {
		return operacion;
	}

	/**
	 * Define el valor de la propiedad operacion.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setOperacion(Long value) {
		this.operacion = value;
	}

	/**
	 * Obtiene el valor de la propiedad operacionEtiqueta.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperacionEtiqueta() {
		return operacionEtiqueta;
	}

	/**
	 * Define el valor de la propiedad operacionEtiqueta.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOperacionEtiqueta(String value) {
		this.operacionEtiqueta = value;
	}

	/**
	 * Obtiene el valor de la propiedad idTipoCampo.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdTipoCampo() {
		return idTipoCampo;
	}

	/**
	 * Define el valor de la propiedad idTipoCampo.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdTipoCampo(Long value) {
		this.idTipoCampo = value;
	}

	/**
	 * Obtiene el valor de la propiedad idCampo.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdCampo() {
		return idCampo;
	}

	/**
	 * Define el valor de la propiedad idCampo.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdCampo(Long value) {
		this.idCampo = value;
	}

	/**
	 * Obtiene el valor de la propiedad idOperador.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * Define el valor de la propiedad idOperador.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setIdOperador(Long value) {
		this.idOperador = value;
	}

}

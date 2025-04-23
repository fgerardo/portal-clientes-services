//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.23 a las 01:25:46 PM CST 
//

package mx.com.allianz.central.comunicados.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ConsultaRespuestaDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultaRespuestaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://dto.centralcomunicados.allianz.com.mx}CodigoErrorDto"/&gt;
 *         &lt;element name="listaComunicados" type="{http://dto.centralcomunicados.allianz.com.mx}ProgramacionComunicadoDto" maxOccurs="unbounded"/&gt;
 *         &lt;element name="detalleComunicado" type="{http://dto.centralcomunicados.allianz.com.mx}ProgramacionComunicadoDto"/&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="pagina" type="{http://dto.centralcomunicados.allianz.com.mx}PaginaDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaRespuestaDto", propOrder = { "codigoError", "listaComunicados", "detalleComunicado",
		"resultado", "pagina" })
public class ConsultaRespuestaDto {

	@XmlElement(required = true, nillable = true)
	protected CodigoErrorDto codigoError;
	@XmlElement(required = true, nillable = true)
	protected List<ProgramacionComunicadoDto> listaComunicados;
	@XmlElement(required = true, nillable = true)
	protected ProgramacionComunicadoDto detalleComunicado;
	@XmlElement(required = true, type = Boolean.class, nillable = true)
	protected Boolean resultado;
	@XmlElement(required = true, nillable = true)
	protected PaginaDto pagina;

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
	 * Gets the value of the listaComunicados property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the listaComunicados property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getListaComunicados().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ProgramacionComunicadoDto }
	 * 
	 * 
	 */
	public List<ProgramacionComunicadoDto> getListaComunicados() {
		if (listaComunicados == null) {
			listaComunicados = new ArrayList<ProgramacionComunicadoDto>();
		}
		return this.listaComunicados;
	}

	/**
	 * Obtiene el valor de la propiedad detalleComunicado.
	 * 
	 * @return possible object is {@link ProgramacionComunicadoDto }
	 * 
	 */
	public ProgramacionComunicadoDto getDetalleComunicado() {
		return detalleComunicado;
	}

	/**
	 * Define el valor de la propiedad detalleComunicado.
	 * 
	 * @param value allowed object is {@link ProgramacionComunicadoDto }
	 * 
	 */
	public void setDetalleComunicado(ProgramacionComunicadoDto value) {
		this.detalleComunicado = value;
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
	 * Obtiene el valor de la propiedad pagina.
	 * 
	 * @return possible object is {@link PaginaDto }
	 * 
	 */
	public PaginaDto getPagina() {
		return pagina;
	}

	/**
	 * Define el valor de la propiedad pagina.
	 * 
	 * @param value allowed object is {@link PaginaDto }
	 * 
	 */
	public void setPagina(PaginaDto value) {
		this.pagina = value;
	}

}

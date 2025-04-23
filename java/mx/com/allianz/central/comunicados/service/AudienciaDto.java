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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para AudienciaDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AudienciaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filtros" type="{http://dto.centralcomunicados.allianz.com.mx}FiltroDto" maxOccurs="unbounded"/&gt;
 *         &lt;element name="queryConstruct" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudienciaDto", propOrder = { "filtros", "queryConstruct" })
@XmlSeeAlso({ ComunicadoDto.class })
public class AudienciaDto {

	@XmlElement(required = true)
	protected List<FiltroDto> filtros;
	@XmlElement(required = true, nillable = true)
	protected String queryConstruct;

	/**
	 * Gets the value of the filtros property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the filtros property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFiltros().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link FiltroDto }
	 * 
	 * 
	 */
	public List<FiltroDto> getFiltros() {
		if (filtros == null) {
			filtros = new ArrayList<FiltroDto>();
		}
		return this.filtros;
	}

	/**
	 * Obtiene el valor de la propiedad queryConstruct.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQueryConstruct() {
		return queryConstruct;
	}

	/**
	 * Define el valor de la propiedad queryConstruct.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setQueryConstruct(String value) {
		this.queryConstruct = value;
	}

}

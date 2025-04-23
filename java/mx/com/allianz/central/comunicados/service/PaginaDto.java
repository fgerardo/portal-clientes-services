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
 * Clase Java para PaginaDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaginaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroPagina" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="paginasDisponibles" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="listaComunicados" type="{http://dto.centralcomunicados.allianz.com.mx}ProgramacionComunicadoDto" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaginaDto", propOrder = { "numeroPagina", "paginasDisponibles", "listaComunicados" })
public class PaginaDto {

	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long numeroPagina;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long paginasDisponibles;
	@XmlElement(required = true, nillable = true)
	protected List<ProgramacionComunicadoDto> listaComunicados;

	/**
	 * Obtiene el valor de la propiedad numeroPagina.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getNumeroPagina() {
		return numeroPagina;
	}

	/**
	 * Define el valor de la propiedad numeroPagina.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setNumeroPagina(Long value) {
		this.numeroPagina = value;
	}

	/**
	 * Obtiene el valor de la propiedad paginasDisponibles.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getPaginasDisponibles() {
		return paginasDisponibles;
	}

	/**
	 * Define el valor de la propiedad paginasDisponibles.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setPaginasDisponibles(Long value) {
		this.paginasDisponibles = value;
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

}

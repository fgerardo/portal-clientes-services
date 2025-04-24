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
 * Clase Java para ContactosResponseDto complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ContactosResponseDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://dto.centralcomunicados.allianz.com.mx}CodigoErrorDto"/&gt;
 *         &lt;element name="ContactoDto" type="{http://dto.centralcomunicados.allianz.com.mx}ContactoDto" maxOccurs="unbounded"/&gt;
 *         &lt;element name="pagina" type="{http://dto.centralcomunicados.allianz.com.mx}PaginaContactosDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactosResponseDto", propOrder = { "codigoError", "contactoDto", "pagina" })
public class ContactosResponseDto {

	@XmlElement(required = true, nillable = true)
	protected CodigoErrorDto codigoError;
	@XmlElement(name = "ContactoDto", required = true, nillable = true)
	protected List<ContactoDto> contactoDto;
	@XmlElement(required = true, nillable = true)
	protected PaginaContactosDto pagina;

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
	 * Gets the value of the contactoDto property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the contactoDto property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getContactoDto().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ContactoDto }
	 * 
	 * 
	 */
	public List<ContactoDto> getContactoDto() {
		if (contactoDto == null) {
			contactoDto = new ArrayList<ContactoDto>();
		}
		return this.contactoDto;
	}

	/**
	 * Obtiene el valor de la propiedad pagina.
	 * 
	 * @return possible object is {@link PaginaContactosDto }
	 * 
	 */
	public PaginaContactosDto getPagina() {
		return pagina;
	}

	/**
	 * Define el valor de la propiedad pagina.
	 * 
	 * @param value allowed object is {@link PaginaContactosDto }
	 * 
	 */
	public void setPagina(PaginaContactosDto value) {
		this.pagina = value;
	}

}

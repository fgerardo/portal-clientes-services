package mx.com.allianz.central.comunicados.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "comunicado" })
@XmlRootElement(name = "ObtenerComunicadoResponse", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx")
public class ObtenerComunicadoResponse {

	@XmlElement(name = "Comunicado", namespace = "http://serviceparameters.dto.centralcomunicados.allianz.com.mx", required = true)
	protected ComunicadoResponseMovilDto comunicado;

	/**
	 * Obtiene el valor de la propiedad comunicado.
	 * 
	 * @return possible object is {@link ComunicadoResponseMovilDto }
	 * 
	 */
	public ComunicadoResponseMovilDto getComunicado() {
		return comunicado;
	}

	/**
	 * Define el valor de la propiedad comunicado.
	 * 
	 * @param value allowed object is {@link ComunicadoResponseMovilDto }
	 * 
	 */
	public void setComunicado(ComunicadoResponseMovilDto value) {
		this.comunicado = value;
	}

}

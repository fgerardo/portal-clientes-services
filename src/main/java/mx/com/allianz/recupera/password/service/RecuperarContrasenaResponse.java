//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.08 a las 10:44:42 AM CST 
//

package mx.com.allianz.recupera.password.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "recuperarContrasenaReturn" })
@XmlRootElement(name = "recuperarContrasenaResponse", namespace = "http://services.admincontrasenas.web.habil.com")
public class RecuperarContrasenaResponse {

	@XmlElement(required = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected RecuperarContrasenaResponseDto recuperarContrasenaReturn;

	/**
	 * Obtiene el valor de la propiedad recuperarContrasenaReturn.
	 * 
	 * @return possible object is {@link RecuperarContrasenaResponseDto }
	 * 
	 */
	public RecuperarContrasenaResponseDto getRecuperarContrasenaReturn() {
		return recuperarContrasenaReturn;
	}

	/**
	 * Define el valor de la propiedad recuperarContrasenaReturn.
	 * 
	 * @param value allowed object is {@link RecuperarContrasenaResponseDto }
	 * 
	 */
	public void setRecuperarContrasenaReturn(RecuperarContrasenaResponseDto value) {
		this.recuperarContrasenaReturn = value;
	}

}

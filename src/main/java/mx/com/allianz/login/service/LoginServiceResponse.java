package mx.com.allianz.login.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "loginServiceReturn" })
@XmlRootElement(name = "loginServiceResponse", namespace = "http://services.admincontrasenas.web.habil.com")
public class LoginServiceResponse {

	@XmlElement(required = true, namespace = "http://services.admincontrasenas.web.habil.com")
	protected LoginResponseDto loginServiceReturn;

	/**
	 * Obtiene el valor de la propiedad loginServiceReturn.
	 * 
	 * @return possible object is {@link LoginResponseDto }
	 * 
	 */
	public LoginResponseDto getLoginServiceReturn() {
		return loginServiceReturn;
	}

	/**
	 * Define el valor de la propiedad loginServiceReturn.
	 * 
	 * @param value allowed object is {@link LoginResponseDto }
	 * 
	 */
	public void setLoginServiceReturn(LoginResponseDto value) {
		this.loginServiceReturn = value;
	}

}

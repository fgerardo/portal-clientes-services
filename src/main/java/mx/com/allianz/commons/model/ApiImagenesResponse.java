package mx.com.allianz.commons.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiImagenesResponse  implements Serializable{
	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -2746103152253671852L;
	private ResponseCode responseCode;
	private List<ResponseImagenModel> response;
	private boolean ok;
	private String[] validations;

	@XmlElement
	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	@XmlElement
	public List<ResponseImagenModel> getResponse() {
		return response;
	}

	public void setResponse(List<ResponseImagenModel> response) {
		this.response = response;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String[] getValidations() {
		return validations;
	}

	public void setValidations(String[] validations) {
		this.validations = validations;
	}

	@Override
	public String toString() {
		return "ApiResponse [responseCode=" + responseCode + ", response=" + response + ", ok=" + ok + ", validations="
				+ Arrays.toString(validations) + "]";
	}

}

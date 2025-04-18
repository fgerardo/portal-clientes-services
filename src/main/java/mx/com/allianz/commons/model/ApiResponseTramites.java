package mx.com.allianz.commons.model;

import java.util.List;

public class ApiResponseTramites<T> {
	private ResponseCode responseCode;
	private T response;
	private boolean ok;
	private List<String> validations;

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<String> getValidations() {
		return validations;
	}

	public void setValidations(List<String> validations) {
		this.validations = validations;
	}

	@Override
	public String toString() {
		return "ApiResponseTramites [responseCode=" + responseCode + ", response=" + response + ", ok=" + ok
				+ ", validations=" + validations + "]";
	}

	// Getters y setters
}
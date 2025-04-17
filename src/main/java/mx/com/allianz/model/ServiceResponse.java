package mx.com.allianz.model;

import java.util.List;

import mx.com.allianz.commons.model.ResponseCode;

public class ServiceResponse {
	private ResponseCode responseCode;
	private boolean response;
	private boolean ok;
	private List<String> validations;

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
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
		return "ServiceResponse [responseCode=" + responseCode + ", response=" + response + ", ok=" + ok
				+ ", validations=" + validations + "]";
	}

}

package mx.com.allianz.model.expediente;

import java.io.Serializable;
import java.util.List;

import mx.com.allianz.commons.model.ResponseCode;

public class RespuestaServicioExpedienteEstatusRfc implements Serializable {
	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -1005192830581990084L;

	private ResponseCode responseCode;

	private ExpedienteEstatusRfcDTO response;

	private Boolean ok;

	private List<String> validations;

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public ExpedienteEstatusRfcDTO getResponse() {
		return response;
	}

	public void setResponse(ExpedienteEstatusRfcDTO response) {
		this.response = response;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
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
		return "RespuestaServicio [responseCode=" + responseCode + ", response=" + response + ", ok=" + ok
				+ ", validations=" + validations + "]";
	}
}

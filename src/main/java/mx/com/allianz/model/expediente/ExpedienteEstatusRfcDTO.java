package mx.com.allianz.model.expediente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpedienteEstatusRfcDTO {
	@JsonProperty("existeCliente")
	private Boolean existeCliente;
	@JsonProperty("idCliente")
	private String idCliente;
	@JsonProperty("registroBiometrico")
	private Boolean registroBiometrico;
	@JsonProperty("dataIncode")
	private DataIncode dataIncode;
	@JsonProperty("expedienteCompleto")
	private Boolean expedienteCompleto;
	@JsonProperty("documentosPendientes")
	private String documentosPendientes;
	@JsonProperty("detalleOnboarding")
	private String detalleOnboarding;

	public Boolean getExisteCliente() {
		return existeCliente;
	}

	public void setExisteCliente(Boolean existeCliente) {
		this.existeCliente = existeCliente;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Boolean getRegistroBiometrico() {
		return registroBiometrico;
	}

	public void setRegistroBiometrico(Boolean registroBiometrico) {
		this.registroBiometrico = registroBiometrico;
	}

	public DataIncode getDataIncode() {
		return dataIncode;
	}

	public void setDataIncode(DataIncode dataIncode) {
		this.dataIncode = dataIncode;
	}

	public Boolean getExpedienteCompleto() {
		return expedienteCompleto;
	}

	public void setExpedienteCompleto(Boolean expedienteCompleto) {
		this.expedienteCompleto = expedienteCompleto;
	}

	public String getDocumentosPendientes() {
		return documentosPendientes;
	}

	public void setDocumentosPendientes(String documentosPendientes) {
		this.documentosPendientes = documentosPendientes;
	}

	public String getDetalleOnboarding() {
		return detalleOnboarding;
	}

	public void setDetalleOnboarding(String detalleOnboarding) {
		this.detalleOnboarding = detalleOnboarding;
	}

	@Override
	public String toString() {
		return "ExpedienteEstatusRfcDTO [existeCliente=" + existeCliente + ", idCliente=" + idCliente
				+ ", registroBiometrico=" + registroBiometrico + ", expedienteCompleto=" + expedienteCompleto
				+ ", documentosPendientes=" + documentosPendientes + "]";
	}
}

class DataIncode {
	@JsonProperty("documentType")
	private String documentType;
	@JsonProperty("addressStatementTimestamps")
	private List<AddressStatementTimestamps> addressStatementTimestamps;
	@JsonProperty("expirationDate")
	private Integer expirationDate;
	@JsonProperty("typeOfId")
	private String typeOfId;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public List<AddressStatementTimestamps> getAddressStatementTimestamps() {
		return addressStatementTimestamps;
	}

	public void setAddressStatementTimestamps(List<AddressStatementTimestamps> addressStatementTimestamps) {
		this.addressStatementTimestamps = addressStatementTimestamps;
	}

	public Integer getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Integer expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(String typeOfId) {
		this.typeOfId = typeOfId;
	}

	@Override
	public String toString() {
		return "DataIncode [documentType=" + documentType + ", addressStatementTimestamps=" + addressStatementTimestamps
				+ ", expirationDate=" + expirationDate + ", typeOfId=" + typeOfId + "]";
	}
}

class AddressStatementTimestamps {
	@JsonProperty("_id")
	private String _id;
	@JsonProperty("dateType")
	private String dateType;
	@JsonProperty("addressStatementTimestamp")
	private String addressStatementTimestamp;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getAddressStatementTimestamp() {
		return addressStatementTimestamp;
	}

	public void setAddressStatementTimestamp(String addressStatementTimestamp) {
		this.addressStatementTimestamp = addressStatementTimestamp;
	}

	@Override
	public String toString() {
		return "AddressStatementTimestamps [_id=" + _id + ", dateType=" + dateType + ", addressStatementTimestamp="
				+ addressStatementTimestamp + "]";
	}
}
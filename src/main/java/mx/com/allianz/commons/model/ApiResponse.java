package mx.com.allianz.commons.model;

import java.util.Arrays;

public class ApiResponse {
	private ResponseCode responseCode;
	private ResponseData response;
	private boolean ok;
	private String[] validations;

	// Getters y Setters

	public static class ResponseCode {
		private String code;
		private String message;
		private String level;
		private String description;
		private String moreInfo;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getMoreInfo() {
			return moreInfo;
		}

		public void setMoreInfo(String moreInfo) {
			this.moreInfo = moreInfo;
		}

		@Override
		public String toString() {
			return "ResponseCode [code=" + code + ", message=" + message + ", level=" + level + ", description="
					+ description + ", moreInfo=" + moreInfo + "]";
		}

	}

	public static class ResponseData {
		private String usuario;
		private String idImagen;
		private int numIntentos;
		private String errIngresa;
		private String exitoIngresa;
		private String origen;
		private String ipAddress;
		private String coordenadas;

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getIdImagen() {
			return idImagen;
		}

		public void setIdImagen(String idImagen) {
			this.idImagen = idImagen;
		}

		public int getNumIntentos() {
			return numIntentos;
		}

		public void setNumIntentos(int numIntentos) {
			this.numIntentos = numIntentos;
		}

		public String getErrIngresa() {
			return errIngresa;
		}

		public void setErrIngresa(String errIngresa) {
			this.errIngresa = errIngresa;
		}

		public String getExitoIngresa() {
			return exitoIngresa;
		}

		public void setExitoIngresa(String exitoIngresa) {
			this.exitoIngresa = exitoIngresa;
		}

		public String getOrigen() {
			return origen;
		}

		public void setOrigen(String origen) {
			this.origen = origen;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public String getCoordenadas() {
			return coordenadas;
		}

		public void setCoordenadas(String coordenadas) {
			this.coordenadas = coordenadas;
		}

		@Override
		public String toString() {
			return "ResponseData [usuario=" + usuario + ", idImagen=" + idImagen + ", numIntentos=" + numIntentos
					+ ", errIngresa=" + errIngresa + ", exitoIngresa=" + exitoIngresa + ", origen=" + origen
					+ ", ipAddress=" + ipAddress + ", coordenadas=" + coordenadas + "]";
		}

	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public ResponseData getResponse() {
		return response;
	}

	public void setResponse(ResponseData response) {
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

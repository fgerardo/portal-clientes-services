package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Intermediario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1161227516601013239L;
    @JsonProperty("IdIntermediario") 
	public String idIntermediario;
	@JsonProperty("IdPromotor")
	public String idPromotor;
	@JsonProperty("IdEjecutivo")
	public String idEjecutivo;

	public String getIdIntermediario() {
		return idIntermediario;
	}

	public void setIdIntermediario(String idIntermediario) {
		this.idIntermediario = idIntermediario;
	}

	public String getIdPromotor() {
		return idPromotor;
	}

	public void setIdPromotor(String idPromotor) {
		this.idPromotor = idPromotor;
	}

	public String getIdEjecutivo() {
		return idEjecutivo;
	}

	public void setIdEjecutivo(String idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

	@Override
	public String toString() {
		return "Intermediario [idIntermediario=" + idIntermediario + ", idPromotor=" + idPromotor + ", idEjecutivo="
				+ idEjecutivo + "]";
	}

}

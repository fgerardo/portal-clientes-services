package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosPago implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -3767745325305470367L;
    @JsonProperty("CuentaCobro4Ult") 
	public String cuentaCobro4Ult;
	@JsonProperty("CodPlanFracc")
	public String codPlanFracc;
	@JsonProperty("CodCondCobro")
	public String codCondCobro;
	@JsonProperty("Formapago")
	public String formapago;
	@JsonProperty("MetodoPago")
	public String metodoPago;

	public String getCuentaCobro4Ult() {
		return cuentaCobro4Ult;
	}

	public void setCuentaCobro4Ult(String cuentaCobro4Ult) {
		this.cuentaCobro4Ult = cuentaCobro4Ult;
	}

	public String getCodPlanFracc() {
		return codPlanFracc;
	}

	public void setCodPlanFracc(String codPlanFracc) {
		this.codPlanFracc = codPlanFracc;
	}

	public String getCodCondCobro() {
		return codCondCobro;
	}

	public void setCodCondCobro(String codCondCobro) {
		this.codCondCobro = codCondCobro;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	@Override
	public String toString() {
		return "DatosPago [cuentaCobro4Ult=" + cuentaCobro4Ult + ", codPlanFracc=" + codPlanFracc + ", codCondCobro="
				+ codCondCobro + ", formapago=" + formapago + ", metodoPago=" + metodoPago + "]";
	}

}

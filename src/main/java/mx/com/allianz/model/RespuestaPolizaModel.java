package mx.com.allianz.model;

import java.io.Serializable;

public class RespuestaPolizaModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 8040672042140233426L;
	private GeneralesEmpresarialModel generalesEmpresarial;
	private GeneralesModel generales;

	public GeneralesEmpresarialModel getGeneralesEmpresarial() {
		return generalesEmpresarial;
	}

	public void setGeneralesEmpresarial(GeneralesEmpresarialModel generalesEmpresarial) {
		this.generalesEmpresarial = generalesEmpresarial;
	}

	public GeneralesModel getGenerales() {
		return generales;
	}

	public void setGenerales(GeneralesModel generales) {
		this.generales = generales;
	}

	@Override
	public String toString() {
		return "RespuestaPolizaModel [generalesEmpresarial=" + generalesEmpresarial + ", generales=" + generales + "]";
	}

}

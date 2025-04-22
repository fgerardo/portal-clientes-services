package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

import mx.com.allianz.model.saldo.ContenedorModel;

public class SumaSaldo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 703699622391725211L;
	private String sumaPolizaPesos;
	private String sumaPolizaDolares;
	private List<ContenedorModel> infoPesos;
	private List<ContenedorModel> infoDolares;

	public String getSumaPolizaPesos() {
		return sumaPolizaPesos;
	}

	public void setSumaPolizaPesos(String sumaPolizaPesos) {
		this.sumaPolizaPesos = sumaPolizaPesos;
	}

	public String getSumaPolizaDolares() {
		return sumaPolizaDolares;
	}

	public void setSumaPolizaDolares(String sumaPolizaDolares) {
		this.sumaPolizaDolares = sumaPolizaDolares;
	}

	public List<ContenedorModel> getInfoPesos() {
		return infoPesos;
	}

	public void setInfoPesos(List<ContenedorModel> infoPesos) {
		this.infoPesos = infoPesos;
	}

	public List<ContenedorModel> getInfoDolares() {
		return infoDolares;
	}

	public void setInfoDolares(List<ContenedorModel> infoDolares) {
		this.infoDolares = infoDolares;
	}

	@Override
	public String toString() {
		return "SumaSaldo [sumaPolizaPesos=" + sumaPolizaPesos + ", sumaPolizaDolares=" + sumaPolizaDolares
				+ ", infoPesos=" + infoPesos + ", infoDolares=" + infoDolares + "]";
	}

}

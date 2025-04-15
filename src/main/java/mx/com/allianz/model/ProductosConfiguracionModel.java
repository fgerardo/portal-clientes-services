package mx.com.allianz.model;

import java.io.Serializable;

public class ProductosConfiguracionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3240578577225060741L;

	private String familiasHogar;
	private String familiasSalud;
	private String familiasProteccion;
	private String familiasAhorro;
	private String familiasInversion;
	private String familiasAuto;

	public String getFamiliasHogar() {
		return familiasHogar;
	}

	public void setFamiliasHogar(String familiasHogar) {
		this.familiasHogar = familiasHogar;
	}

	public String getFamiliasSalud() {
		return familiasSalud;
	}

	public void setFamiliasSalud(String familiasSalud) {
		this.familiasSalud = familiasSalud;
	}

	public String getFamiliasProteccion() {
		return familiasProteccion;
	}

	public void setFamiliasProteccion(String familiasProteccion) {
		this.familiasProteccion = familiasProteccion;
	}

	public String getFamiliasAhorro() {
		return familiasAhorro;
	}

	public void setFamiliasAhorro(String familiasAhorro) {
		this.familiasAhorro = familiasAhorro;
	}

	public String getFamiliasInversion() {
		return familiasInversion;
	}

	public void setFamiliasInversion(String familiasInversion) {
		this.familiasInversion = familiasInversion;
	}

	public String getFamiliasAuto() {
		return familiasAuto;
	}

	public void setFamiliasAuto(String familiasAuto) {
		this.familiasAuto = familiasAuto;
	}

	@Override
	public String toString() {
		return "ProductosConfiguracionModel [familiasHogar=" + familiasHogar + ", familiasSalud=" + familiasSalud
				+ ", familiasProteccion=" + familiasProteccion + ", familiasAhorro=" + familiasAhorro
				+ ", familiasInversion=" + familiasInversion + ", familiasAuto=" + familiasAuto + "]";
	}

}

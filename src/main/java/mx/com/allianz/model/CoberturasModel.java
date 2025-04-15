package mx.com.allianz.model;

import java.util.ArrayList;

public class CoberturasModel {
	String nombreZona;
	ArrayList<String> coberturas;

	public CoberturasModel() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreCobertura() {
		return nombreZona;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public ArrayList<String> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(ArrayList<String> coberturas) {
		this.coberturas = coberturas;
	}

	@Override
	public String toString() {
		return "CoberturasModel [nombreZona=" + nombreZona + ", coberturas=" + coberturas + "]";
	}

}
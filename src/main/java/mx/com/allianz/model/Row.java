package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Row implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6983438009458407590L;

	@JsonProperty("Contratante")
	public Contratante contratante;
	@JsonProperty("Alertas")
	public ArrayList<Object> alertas;
	@JsonProperty("Polizas")
	public ArrayList<Poliza> polizas;
	@JsonProperty("PolizasGMMAsegurado")
	public ArrayList<Object> polizasGMMAsegurado;
	@JsonProperty("ProximosPagos")
	public ArrayList<Object> proximosPagos;

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public ArrayList<Object> getAlertas() {
		return alertas;
	}

	public void setAlertas(ArrayList<Object> alertas) {
		this.alertas = alertas;
	}

	public ArrayList<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(ArrayList<Poliza> polizas) {
		this.polizas = polizas;
	}

	public ArrayList<Object> getPolizasGMMAsegurado() {
		return polizasGMMAsegurado;
	}

	public void setPolizasGMMAsegurado(ArrayList<Object> polizasGMMAsegurado) {
		this.polizasGMMAsegurado = polizasGMMAsegurado;
	}

	public ArrayList<Object> getProximosPagos() {
		return proximosPagos;
	}

	public void setProximosPagos(ArrayList<Object> proximosPagos) {
		this.proximosPagos = proximosPagos;
	}

	@Override
	public String toString() {
		return "Row [contratante=" + contratante + ", alertas=" + alertas + ", polizas=" + polizas
				+ ", polizasGMMAsegurado=" + polizasGMMAsegurado + ", proximosPagos=" + proximosPagos + "]";
	}

}

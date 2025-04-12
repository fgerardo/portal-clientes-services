package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsablePago implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 3776593951758132690L;

	@JsonProperty("Nombre")
	public String nombre;
	@JsonProperty("ApellidoPaterno")
	public String apellidoPaterno;
	@JsonProperty("ApellidoMaterno")
	public String apellidoMaterno;
	@JsonProperty("DatosPago")
	public ArrayList<DatosPago> datosPago;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public ArrayList<DatosPago> getDatosPago() {
		return datosPago;
	}

	public void setDatosPago(ArrayList<DatosPago> datosPago) {
		this.datosPago = datosPago;
	}

	@Override
	public String toString() {
		return "ResponsablePago [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", datosPago=" + datosPago + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

public class InmuebleAseguradoDestino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3431212819263922921L;
	private String domicilio;
	private List<CoberturaInmueble> coberturas;

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<CoberturaInmueble> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<CoberturaInmueble> coberturas) {
		this.coberturas = coberturas;
	}

	@Override
	public String toString() {
		return "InmuebleAseguradoDestino [domicilio=" + domicilio + ", coberturas=" + coberturas + "]";
	}

}

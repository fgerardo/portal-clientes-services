package mx.com.allianz.model;

import java.io.Serializable;

public class PolizaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4177128448671194321L;
	private PolizaLimpiaModel poliza;
	private int orden;

	public PolizaLimpiaModel getPoliza() {
		return poliza;
	}

	public void setPoliza(PolizaLimpiaModel poliza) {
		this.poliza = poliza;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "PolizaModel [poliza=" + poliza + ", orden=" + orden + "]";
	}

}

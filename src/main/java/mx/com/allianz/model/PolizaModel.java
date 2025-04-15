package mx.com.allianz.model;

import java.io.Serializable;

public class PolizaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4177128448671194321L;
	private PolizaLimpiaModel poliza;

	public PolizaLimpiaModel getPoliza() {
		return poliza;
	}

	public void setPoliza(PolizaLimpiaModel poliza) {
		this.poliza = poliza;
	}

	@Override
	public String toString() {
		return "PolizaModel [poliza=" + poliza + "]";
	}

}

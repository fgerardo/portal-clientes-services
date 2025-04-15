package mx.com.allianz.model;

import java.io.Serializable;

public class GeneralesEmpresarialModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 5224930797377894957L;
	private String direccionE;
	private String rfcE;
	private String emailE;
	private String telefonoE;
	private String nombreE;
	public String getDireccionE() {
		return direccionE;
	}
	public void setDireccionE(String direccionE) {
		this.direccionE = direccionE;
	}
	public String getRfcE() {
		return rfcE;
	}
	public void setRfcE(String rfcE) {
		this.rfcE = rfcE;
	}
	public String getEmailE() {
		return emailE;
	}
	public void setEmailE(String emailE) {
		this.emailE = emailE;
	}
	public String getTelefonoE() {
		return telefonoE;
	}
	public void setTelefonoE(String telefonoE) {
		this.telefonoE = telefonoE;
	}
	public String getNombreE() {
		return nombreE;
	}
	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}
	@Override
	public String toString() {
		return "GeneralesEmpresarialModel [direccionE=" + direccionE + ", rfcE=" + rfcE + ", emailE=" + emailE
				+ ", telefonoE=" + telefonoE + ", nombreE=" + nombreE + "]";
	}

	

}

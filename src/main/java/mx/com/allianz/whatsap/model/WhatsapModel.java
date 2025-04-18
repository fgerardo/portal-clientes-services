package mx.com.allianz.whatsap.model;

import java.io.Serializable;

public class WhatsapModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 7082161042843501047L;
	private String contacto;
	private String debeVerse;

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDebeVerse() {
		return debeVerse;
	}

	public void setDebeVerse(String debeVerse) {
		this.debeVerse = debeVerse;
	}

	@Override
	public String toString() {
		return "WhatsapModel [contacto=" + contacto + ", debeVerse=" + debeVerse + "]";
	}

}

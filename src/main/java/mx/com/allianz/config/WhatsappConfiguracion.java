package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "whatsapp")
public class WhatsappConfiguracion {
	private String whatsappProductos;
	private String whatsappApi;
	private String whatsappNumero;

	public String getWhatsappProductos() {
		return whatsappProductos;
	}

	public void setWhatsappProductos(String whatsappProductos) {
		this.whatsappProductos = whatsappProductos;
	}

	public String getWhatsappApi() {
		return whatsappApi;
	}

	public void setWhatsappApi(String whatsappApi) {
		this.whatsappApi = whatsappApi;
	}

	public String getWhatsappNumero() {
		return whatsappNumero;
	}

	public void setWhatsappNumero(String whatsappNumero) {
		this.whatsappNumero = whatsappNumero;
	}

	@Override
	public String toString() {
		return "WhatsappConfiguracion [whatsappProductos=" + whatsappProductos + ", whatsappApi=" + whatsappApi
				+ ", whatsappNumero=" + whatsappNumero + "]";
	}

}

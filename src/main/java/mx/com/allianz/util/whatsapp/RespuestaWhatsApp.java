package mx.com.allianz.util.whatsapp;

import mx.com.allianz.whatsap.model.WhatsapModel;

public class RespuestaWhatsApp {

	public WhatsapModel obtenerRespuestaParaWhatsApp(InformacionWhatsApp informacionWhatsApp) {
		if (informacionWhatsApp != null) {
			WhatsapModel respuesta = obtenerRespuesta(informacionWhatsApp);
			if (respuesta != null) {
				return respuesta;
			}
		}
		return respuestaNoDebeVerse();
	}

	private WhatsapModel respuestaNoDebeVerse() {
		WhatsapModel respuesta = new WhatsapModel();
		respuesta.setDebeVerse("0");
		return respuesta;
	}

	private WhatsapModel obtenerRespuesta(InformacionWhatsApp informacionWhatsApp) {
		if (informacionWhatsApp != null) {
			return respuestaWhatsApp(informacionWhatsApp);
		}
		return null;
	}

	private WhatsapModel respuestaWhatsApp(InformacionWhatsApp informacionWhatsApp) {
		if (informacionWhatsApp != null) {
			WhatsapModel whatsApp = new WhatsapModel();
			whatsApp.setContacto(informacionWhatsApp.getHref());
			whatsApp.setDebeVerse(informacionWhatsApp.getDebeAparecer() + "");
			return whatsApp;
		}
		return null;
	}

}

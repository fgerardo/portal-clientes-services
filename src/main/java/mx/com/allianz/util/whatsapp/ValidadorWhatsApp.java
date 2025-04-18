package mx.com.allianz.util.whatsapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.allianz.config.WhatsappConfiguracion;
import mx.com.allianz.model.GeneralesModel;
import mx.com.allianz.model.PolizaLimpiaModel;
import mx.com.allianz.model.PolizaModel;

@Service
public class ValidadorWhatsApp {
	private String COMA = ",";

	public InformacionWhatsApp obtenerInformacionWhatsApp(List<PolizaModel> polizas, String productos, String api,
			String contacto) {
		if (polizas != null && polizas.size() > 0) {
			List<String> familiasUnicas = obtenerPolizasUnicas(polizas);
			List<String> familiasConfiguradasParaVerWhatsApp = familiasQueVeranWhatsApp(productos);
			boolean debeVerse = seDeberaMostrarWhatsApp(familiasUnicas, familiasConfiguradasParaVerWhatsApp);
			if (debeVerse) {
				InformacionWhatsApp informacionWhatsApp = obtenerResultadoWhatsApp(api, contacto);
				return informacionWhatsApp;
			}
		}
		return null;
	}

	private String obtenerUrlMensaje(String api, String contacto) {
		if (api != null && contacto != null) {
			api = String.format(api, contacto);
			return api;
		}
		return null;
	}

	private InformacionWhatsApp obtenerResultadoWhatsApp(String api, String contacto) {
		InformacionWhatsApp informacionWhatsApp = new InformacionWhatsApp();
		String url = obtenerUrlMensaje(api, contacto);
		informacionWhatsApp.setHref(url);
		informacionWhatsApp.setDebeAparecer(1);
		return informacionWhatsApp;
	}

	private boolean seDeberaMostrarWhatsApp(List<String> productosCliente, List<String> productosWhatsApp) {
		if (productosCliente != null && productosCliente.size() > 0 && productosWhatsApp != null
				&& productosWhatsApp.size() > 0) {
			for (String producto : productosCliente) {
				for (String productoAValidar : productosWhatsApp) {
					if (producto.equalsIgnoreCase(productoAValidar)) {
						return true;
					}
				}
			}

		}
		return false;
	}

	private List<String> familiasQueVeranWhatsApp(String productos) {
		if (productos != null) {
			String[] familiasSeparadas = productos.split(COMA);
			if (familiasSeparadas != null && productos.length() > 0) {
				List<String> familiasQueVeranWhatsApp = new ArrayList<>();
				for (String familiaAparte : familiasSeparadas) {
					familiasQueVeranWhatsApp.add(familiaAparte);
				}
				return familiasQueVeranWhatsApp;
			}

		}
		return null;
	}

	private List<String> obtenerPolizasUnicas(List<PolizaModel> polizas) {
		if (polizas != null) {
			List<String> familias = obtenerFamilias(polizas);
			List<String> polizasUnicas = new ArrayList<>();
			if (familias != null && familias.size() > 0) {
				for (int indicePoliza = 0; indicePoliza < familias.size(); indicePoliza++) {
					if (indicePoliza == 0) {
						polizasUnicas.add(familias.get(indicePoliza));
					}
					int indice = obtenerIndiceDeLaLista(polizasUnicas, familias.get(indicePoliza));
					if (indice == -1) {
						polizasUnicas.add(familias.get(indicePoliza));
					}
				}
				return polizasUnicas;
			}
		}
		return null;
	}

	private int obtenerIndiceDeLaLista(List<String> familas, String familia) {
		for (int indice = 0; indice < familas.size(); indice++) {
			if (familas.get(indice).equalsIgnoreCase(familia)) {
				return indice;
			}
		}
		return -1;
	}

	private List<String> obtenerFamilias(List<PolizaModel> polizas) {
		if (polizas != null) {
			List<String> familias = new ArrayList<>();
			for (int indicePoliza = 0; indicePoliza < polizas.size(); indicePoliza++) {
				GeneralesModel generales = obtenerGenerales(polizas.get(indicePoliza));
				if (generales != null) {
					String nombreFamilia = generales.getFamiliaPoliza();
					if (nombreFamilia != null) {
						familias.add(nombreFamilia);
					}
				}
			}
			return familias;
		}
		return null;
	}

	private GeneralesModel obtenerGenerales(PolizaModel poliza) {
		if (poliza != null) {
			PolizaLimpiaModel polizaObject = poliza.getPoliza();
			if (polizaObject != null) {
				GeneralesModel generales = polizaObject.getGenerales();
				if (generales != null) {
					return generales;
				}
			}
		}
		return null;
	}
}

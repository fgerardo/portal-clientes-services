package mx.com.allianz.util;

import java.util.ArrayList;
import java.util.List;

import mx.com.allianz.model.GeneralesModel;
import mx.com.allianz.model.PolizaLimpiaModel;
import mx.com.allianz.model.PolizaModel;
import mx.com.allianz.model.ProximosPagos;

public class FiltradoAgenteUtil {

	public boolean esAgente(String idAgente) {
		if (idAgente != null && idAgente.length() > 0 && TramitesUtility.esNumerico(idAgente)) {
			return true;
		}
		return false;
	}

	public List<ProximosPagos> obtenerProximosPagos(List<ProximosPagos> proximosPagos, List<PolizaModel> polizas) {
		if (proximosPagos != null) {
			return obtenerProximosPagosPorPoliza(proximosPagos, polizas);
		}
		return null;
	}

	private List<ProximosPagos> obtenerProximosPagosPorPoliza(List<ProximosPagos> proximosPagos,
			List<PolizaModel> polizas) {
		List<ProximosPagos> proximosPagosAgente = new ArrayList<>();
		if (proximosPagos != null) {
			for (int poliza = 0; poliza < polizas.size(); poliza++) {
				PolizaLimpiaModel polizaActual = polizas.get(poliza).getPoliza();

				String idePolPolizaActual = obtenerIDEPOL(polizaActual);
				for (int pago = 0; pago < proximosPagos.size(); pago++) {
					ProximosPagos pagoActual = proximosPagos.get(pago);
					String idPolPago = pagoActual.getIDEPOL();
					if (idPolPago != null && idPolPago.equalsIgnoreCase(idePolPolizaActual)) {
						proximosPagosAgente.add(pagoActual);
					}
				}
			}
			return proximosPagosAgente;
		}
		return null;
	}

	private String obtenerIDEPOL(PolizaLimpiaModel polizaActual) {
		if (polizaActual != null) {
			GeneralesModel generales = obtenerGenerales(polizaActual);
			if (generales != null) {
				return generales.getIDEPOL();
			}
		}
		return null;
	}

	private GeneralesModel obtenerGenerales(PolizaLimpiaModel poliza) {
		if (poliza != null) {
			PolizaModel polizaO = poliza.getPoliza();
			if (polizaO != null) {
				return polizaO.getPoliza().getGenerales();
			}
		}
		return null;
	}
}

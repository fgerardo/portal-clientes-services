package mx.com.allianz.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.allianz.model.Fondo;
import mx.com.allianz.model.Movimiento;
import mx.com.allianz.model.Saldo;

public class DetalleDeSaldo {
	private static final Logger LOGGER = LoggerFactory.getLogger(DetalleDeSaldo.class);
	private JSONObject graficaSaldoActual = null;
	private JSONObject graficaAportacionesYSaldo = null;
	private JSONArray detalleDeSaldo = null;
	private String[] nombreMeses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
			"Septiembre", "Octubre", "Noviembre", "Diciembre" };

	public DetalleDeSaldo() {
		this.graficaSaldoActual = JSONFactoryUtil.createJSONObject();
		this.graficaAportacionesYSaldo = JSONFactoryUtil.createJSONObject();
		this.detalleDeSaldo = JSONFactoryUtil.createJSONArray();
	}

	public JSONObject getJsonDetalleDeSaldo() {
		JSONObject detalleDesaldoJsonObj = JSONFactoryUtil.createJSONObject();
		detalleDesaldoJsonObj.put("detalleDeSaldoArray", detalleDeSaldo);
		return detalleDesaldoJsonObj;
	}

	private JSONObject armarGraficaSaldoActual(ArrayList<Fondo> arrayFondos2) {
		JSONObject graficaSaldoActual = JSONFactoryUtil.createJSONObject();
		JSONArray arrayFondos = JSONFactoryUtil.createJSONArray();
		Fondo fondo = new Fondo();

		double saldoActualFinal = 0.0;

		for (int i = 0; i < arrayFondos2.size(); i++) {
			fondo = arrayFondos2.get(i);
			try {
				ArrayList<Saldo> saldos = new ArrayList<>();
				saldos = fondo.getSaldo();
				double saldoPorFondo = 0.0;
				if (saldos != null && saldos.size() > 0) {
					saldoPorFondo = Double.parseDouble(saldos.get(saldos.size() - 1).getSaldoFinalMN());
				} else {
					saldoPorFondo = 0.0;
				}
				saldoActualFinal += saldoPorFondo;
				JSONObject fondoYdalso = JSONFactoryUtil.createJSONObject();
				fondoYdalso.put("nombreFondo", fondo.getNombreFondo().replace("\"", "'"));
				fondoYdalso.put("idFondo", fondo.getIdFondo());
				fondoYdalso.put("saldoAcumulado", saldoPorFondo);
				arrayFondos.put(fondoYdalso);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		graficaSaldoActual.put("saldoActual", saldoActualFinal);
		graficaSaldoActual.put("fondos", arrayFondos);
		return graficaSaldoActual;
	}

	private JSONArray obtenerArternativasDeInversion(ArrayList<Fondo> jsonFondos) {
		JSONArray alternativas = JSONFactoryUtil.createJSONArray();
		Fondo fondo = new Fondo();
		Saldo saldo = new Saldo();

		for (int i = 0; i < jsonFondos.size(); i++) {
			fondo = jsonFondos.get(i);
			JSONObject alternativa = null;
			if (fondo != null && !(fondo.toString().equals(""))) {
				try {
					ArrayList<Saldo> saldos = fondo.getSaldo();
					for (int j = 0; j < saldos.size(); j++) {
						saldo = saldos.get(j);
						if (saldo != null && !(saldo.toString().equals(""))) {
							alternativa = JSONFactoryUtil.createJSONObject();
							alternativa.put("nombreFondo", fondo.getNombreFondo());
							alternativa.put("idFondo", fondo.getIdFondo());
							alternativa.put("aportaciones", saldo.getAcumuladoTotalAporatciones());
							alternativa.put("aportacionesMesMN", saldo.getAportacionesMesMN());
							LOGGER.info("nombreFondo --> " + fondo.getNombreFondo());
							LOGGER.info("SaldoInicialMN --> " + saldo.getSaldoInicialMN());
							alternativa.put("saldoInicial", saldo.getSaldoInicialMN());
							alternativa.put("bono", saldo.getBonoMesMN());
							alternativa.put("traspasos", saldo.getTraspasosMesMN());
							int mes = Integer.parseInt(saldo.getMes());
							alternativa.put("mes", nombreMeses[mes - 1]);
							alternativa.put("anioMes", saldo.getAnioMes());
							alternativa.put("numMes", mes);
							alternativa.put("retiros", saldo.getRetirosMesMN());
							alternativa.put("saldoMonedaOriginal", saldo.getSaldoFinalMonOrig());
							String saldoFinal = saldo.getSaldoFinalMN();
							if (saldoFinal != null && !saldoFinal.equals("")) {
								alternativa.put("saldoFinal", saldo.getSaldoFinalMN());
							} else {
								alternativa.put("saldoFinal", "0");
							}
							alternativas.put(alternativa);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

			}
		}
		return alternativas;
	}

	public void armarGraficas(ArrayList<Fondo> arrayFondos, String numeroPoliza) {
//		JSONArray saldoInicialASaldoFinal = ajustarSaldoInicialASaldoFinal(jsonArrayFondos);
		JSONObject detallePorPoliza = JSONFactoryUtil.createJSONObject();
		detallePorPoliza.put("jsonSaldoActual", armarGraficaSaldoActual(arrayFondos));
		JSONArray alternativasDeInversion = JSONFactoryUtil.createJSONArray();
		alternativasDeInversion = obtenerArternativasDeInversion(arrayFondos);
		detallePorPoliza.put("saldosAlter", obtenerAportacionesYSaldos(alternativasDeInversion));
		detallePorPoliza.put("alternativasDeInversion", alternativasDeInversion);
		detallePorPoliza.put("resumenDeMovimientos", resumenDeMovimientos(arrayFondos));
		detallePorPoliza.put("numeroPoliza", numeroPoliza);
		detalleDeSaldo.put(detallePorPoliza);
	}

	public JSONArray obtenerAportacionesYSaldos(JSONArray saldosYMovs) {
		String nodo = "numMes";
		JSONArray aportacionesYSaldos = JSONFactoryUtil.createJSONArray();
		Map<Integer, JSONArray> listaAlternativasMap = new HashMap<Integer, JSONArray>();
		JSONArray alternativasYsaldosDestino = JSONFactoryUtil.createJSONArray();

		try {
			for (int i = 0; i < saldosYMovs.length(); i++) {
				JSONObject alternativaYsaldoOrigen = saldosYMovs.getJSONObject(i);
				String saldo = "";
				int descBienAsegurado = alternativaYsaldoOrigen.getInt(nodo);

				boolean existeBienAsegurado = listaAlternativasMap.containsKey(descBienAsegurado);
				JSONArray coberturas = null;

				if (existeBienAsegurado) {
					coberturas = listaAlternativasMap.get(descBienAsegurado);
					saldo = alternativaYsaldoOrigen.getString(nodo);
				} else {
					coberturas = JSONFactoryUtil.createJSONArray();
					saldo = String.valueOf(alternativaYsaldoOrigen.get(nodo));
				}

				JSONObject itemAlternativaYSaldoDestino = JSONFactoryUtil.createJSONObject();
				JSONObject itemAlternativaYSaldoOrigen = saldosYMovs.getJSONObject(i);
				itemAlternativaYSaldoDestino.put(nodo, itemAlternativaYSaldoOrigen.getString(nodo));
				itemAlternativaYSaldoDestino.put("aportaciones", itemAlternativaYSaldoOrigen.getString("aportaciones"));
				itemAlternativaYSaldoDestino.put("saldoFinal", itemAlternativaYSaldoOrigen.getString("saldoFinal"));
				itemAlternativaYSaldoDestino.put("anioMes", itemAlternativaYSaldoOrigen.getString("anioMes"));
				itemAlternativaYSaldoDestino.put("mes", itemAlternativaYSaldoOrigen.getInt("mes"));

				coberturas.put(itemAlternativaYSaldoDestino);
				listaAlternativasMap.put(descBienAsegurado, coberturas);
			}

			listaAlternativasMap.forEach((k, v) -> alternativasYsaldosDestino
					.put(JSONFactoryUtil.createJSONObject().put("mes", k).put(nodo, v)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < alternativasYsaldosDestino.length(); i++) {
			JSONObject mesAlternativasSaldos = JSONFactoryUtil.createJSONObject();
			mesAlternativasSaldos = alternativasYsaldosDestino.getJSONObject(i);

			JSONObject mesLimpio = JSONFactoryUtil.createJSONObject();
			double sumaSsaldos = 0.0;
			double sumaAportaciones = 0.0;

			JSONArray lista = mesAlternativasSaldos.getJSONArray("numMes");
			String anioMes = "";
			for (int j = 0; j < lista.length(); j++) {
				JSONObject messs = lista.getJSONObject(j);

				sumaSsaldos += messs.getDouble("saldoFinal");
				sumaAportaciones += messs.getDouble("aportaciones");
				anioMes = messs.getString("anioMes");
			}

			mesLimpio.put("aportacionesMesMN2", sumaAportaciones);
			mesLimpio.put("saldoFinalMN", sumaSsaldos);
			mesLimpio.put("mes", mesAlternativasSaldos.getInt("mes"));
			mesLimpio.put("anioMes", Integer.parseInt(anioMes));
			mesLimpio.put("nombreMes", nombreMeses[mesAlternativasSaldos.getInt("mes") - 1]);

			aportacionesYSaldos.put(mesLimpio);
		}
		return aportacionesYSaldos;
	}

	public void armarGraficas(JSONObject jsonError, String numeroPoliza) {
		JSONObject detallePorPoliza = JSONFactoryUtil.createJSONObject();
		detallePorPoliza.put("error", jsonError.getString("error"));
		detallePorPoliza.put("numeroPoliza", numeroPoliza);
		detalleDeSaldo.put(detallePorPoliza);
	}

	private JSONArray resumenDeMovimientos(ArrayList<Fondo> jsonFondos) {
		JSONObject resumen = JSONFactoryUtil.createJSONObject();
		JSONArray movs = JSONFactoryUtil.createJSONArray();

		Fondo fondo = new Fondo();
		Saldo saldo = new Saldo();

		for (int i = 0; i < jsonFondos.size(); i++) {
			fondo = jsonFondos.get(i);
			if (fondo != null && !(fondo.toString().equals(""))) {
				try {
					ArrayList<Saldo> saldos = fondo.getSaldo();
					for (int j = 0; j < saldos.size(); j++) {
						saldo = saldos.get(j);
						if (saldo != null && !(saldo.toString().equals(""))) {

							ArrayList<Movimiento> movimientos = new ArrayList<>();
							try {
								JSONObject dos = JSONFactoryUtil.createJSONObject();
								movimientos = saldo.getMovimientos();
								String nombre = fondo.getNombreFondo().replaceAll(" ", "");
								dos.put("movimientos", movimientos);
								dos.put("mes", nombreMeses[(Integer.parseInt(saldo.getMes())) - 1]);
								dos.put("idFondo", fondo.getIdFondo());
								dos.put("nombre", nombre);

								movs.put(dos);
							} catch (Exception e) {
								JSONObject noHayMovimientos = JSONFactoryUtil.createJSONObject();
								noHayMovimientos.put("Error", "No hay movimientos para este fondo");
								String nombre = fondo.getNombreFondo().replaceAll(" ", "");
								resumen.put("idFondo", fondo.getIdFondo());
								resumen.put(nombre, "null");
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return movs;
	}

	public JSONArray sumarSaldosAgrupados(JSONArray meses, String nodo) {
		JSONArray saldosArdenados2 = JSONFactoryUtil.createJSONArray();

		for (int i = 0; i < meses.length(); i++) {
			JSONObject mesLimpio = JSONFactoryUtil.createJSONObject();
			Double sumaSaldo = 0.0;
			JSONObject mes = JSONFactoryUtil.createJSONObject();
			mes = meses.getJSONObject(i);

			JSONArray saldoFinalMN = JSONFactoryUtil.createJSONArray();
			saldoFinalMN = mes.getJSONArray(nodo);

			if (saldoFinalMN.length() > 0) {
				for (int j = 0; j < saldoFinalMN.length(); j++) {
					JSONObject saldo = JSONFactoryUtil.createJSONObject();
					saldo = saldoFinalMN.getJSONObject(j);
					sumaSaldo += saldo.getDouble(nodo);
				}
				mesLimpio.put(nodo, sumaSaldo);
			} else {
				mesLimpio.put(nodo, 0.00);
			}
			mesLimpio.put("mes", nombreMeses[(Integer.parseInt(mes.getString("mes"))) - 1]);
			mesLimpio.put("numeroMes", "" + Integer.parseInt(mes.getString("mes")));
			saldosArdenados2.put(mesLimpio);
		}
		return saldosArdenados2;
	}

	/**
	 * Se sobreescribe el valor del SaldoInicialMN tomando el valor del SaldoFinalMN
	 * que proviene del objeto anterior El primer y ultimo saldo por fondo no
	 * reciben esta modificacion
	 */
	private JSONArray ajustarSaldoInicialASaldoFinal(JSONArray fondos) {
		for (int i = 0; i < fondos.length(); i++) {

			JSONObject fondoOrigen = fondos.getJSONObject(i);

			JSONArray saldosPorFondo = fondoOrigen.getJSONArray("Saldo");

			for (int j = 0; j < saldosPorFondo.length(); j++) {
				JSONObject saldoAnterior = JSONFactoryUtil.createJSONObject();

				if (j != 0) {
					saldoAnterior = saldosPorFondo.getJSONObject(j - 1);
					LOGGER.info("SaldoInicialMNAjustar --> " + saldoAnterior.getDouble("SaldoFinalMN"));
					fondos.getJSONObject(i).getJSONArray("Saldo").getJSONObject(j).put("SaldoInicialMN",
							saldoAnterior.getDouble("SaldoFinalMN"));
				}
			}
		}
		return fondos;
	}
}

package mx.com.allianz.util;

import java.util.ArrayList;
import java.util.List;

import mx.com.allianz.model.GeneralesModel;
import mx.com.allianz.model.PolizaLimpiaModel;

public class TramitesUtility {

	/**
	 * METODOS PARA TENER UNA LISTA DE POLIZAS UNICAS
	 * @param polizas
	 * @return
	 */
//	public List<String> obtenerPolizasUnicas(List<PolizaLimpiaModel> polizas){
//		if(polizas != null){
//			List<String> familias = obtenerFamilias(polizas);
//			List<String> polizasUnicas = new ArrayList<>();
//			if(familias != null && familias.size() > 0){
//				for(int indicePoliza = 0; indicePoliza < familias.size(); indicePoliza++){
//					if(indicePoliza == 0){
//						polizasUnicas.add(familias.get(indicePoliza));
//					}
//					int indice = obtenerIndiceDeLaLista(polizasUnicas, familias.get(indicePoliza));
//					if(indice == -1){
//						polizasUnicas.add(familias.get(indicePoliza));
//					}
//				}
//				return polizasUnicas;
//			}
//		}
//		return null;
//	}
//	
//	private int obtenerIndiceDeLaLista(List<String> familas, String familia){
//		for(int indice = 0; indice < familas.size(); indice++){
//			if(familas.get(indice).equalsIgnoreCase(familia)){
//				return indice;
//			}
//		}
//		return -1;
//	}
//	
//	private List<String> obtenerFamilias(List<PolizaLimpiaModel> polizas){
//		if(polizas != null){
//			List<String> familias = new ArrayList<>();
//			for(int indicePoliza = 0; indicePoliza < polizas.size(); indicePoliza++){
//				GeneralesModel generales = obtenerGenerales(polizas.get(indicePoliza));
//				if(generales != null){
//					String nombreFamilia = generales.getFamiliaPoliza();
//					if(nombreFamilia != null){
//						familias.add(nombreFamilia);
//					}
//				}
//			}
//			return familias;
//		}
//		return null;
//	}
//	
//	private JSONObject obtenerGenerales(PolizaLimpiaModel poliza){
//		if(poliza != null){
//			JSONObject polizaObject = poliza.getPoliza();
//			if(polizaObject != null){
//				JSONObject generales = polizaObject.getJSONObject("Generales");
//				if(generales != null){
//					return generales;
//				}
//			}
//		}
//		return null;
//	}
	
	public static boolean esNumerico(String idAgente){
		try{
			Double.parseDouble(idAgente);
			return true;
		}catch(Exception exception){
			
		}
		return false;
	}
}

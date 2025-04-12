package mx.com.allianz.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatosUtil {

	public static String dateFormat(String object) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date convertedCurrentDate;
		String dateFormat = "";
		try {
			if(object != "") {
				convertedCurrentDate = sdf.parse(object);
				dateFormat = sdf.format(convertedCurrentDate);
				return dateFormat;				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatoNumerolRedoneado(String decimal) {
		double parteEntera, convertedStringDecimal;
		convertedStringDecimal = Double.valueOf(decimal);
		parteEntera = Math.floor(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal - parteEntera) * Math.pow(10, 2);
		convertedStringDecimal = Math.round(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal / Math.pow(10, 2)) + parteEntera;
		String numArre[] = String.valueOf(convertedStringDecimal).split("\\.");
		if (numArre[1].length() == 1) {
			return "$" + new DecimalFormat("#,###.00").format(convertedStringDecimal);
		}
		return "$" + new DecimalFormat("#,###.00").format(convertedStringDecimal);
	}
	
	public static String sumaformatoNumerolRedoneado(String decimal) {
		double parteEntera, convertedStringDecimal;
		convertedStringDecimal = Double.valueOf(decimal);
		parteEntera = Math.floor(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal - parteEntera) * Math.pow(10, 2);
		convertedStringDecimal = Math.round(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal / Math.pow(10, 2)) + parteEntera;
		String numArre[] = String.valueOf(convertedStringDecimal).split("\\.");
		if (numArre[1].length() == 1) {
			return new DecimalFormat("#,###.00").format(convertedStringDecimal);
		}
		return new DecimalFormat("#,###.00").format(convertedStringDecimal);
	}
	
	public static String sumaformatoNumerolRedoneadoDos(String decimal, boolean isDolares) {
		double parteEntera, convertedStringDecimal;
		convertedStringDecimal = Double.valueOf(decimal);
		parteEntera = Math.floor(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal - parteEntera) * Math.pow(10, 2);
		convertedStringDecimal = Math.round(convertedStringDecimal);
		convertedStringDecimal = (convertedStringDecimal / Math.pow(10, 2)) + parteEntera;
		String numArre[] = String.valueOf(convertedStringDecimal).split("\\.");
		
		if(isDolares){
			if (numArre[1].length() == 1) {
				return "US $" + new DecimalFormat("#,###.00").format(convertedStringDecimal);
			}
			return "US $ " + new DecimalFormat("#,###.00").format(convertedStringDecimal);			
		}else{
			if (numArre[1].length() == 1) {
				return "$" + new DecimalFormat("#,###.00").format(convertedStringDecimal);
			}
			return "$ " + new DecimalFormat("#,###.00").format(convertedStringDecimal);						
		}
	}
	
//	public static String sumaformatoNumerolRedoneadoDos(String decimal) {
//		String convertedStringDecimal = "";
//		if (Double.parseDouble(decimal) % 1 == 0) {
//			convertedStringDecimal = new DecimalFormat("#,###." + zeros).format(Double.parseDouble(decimal));			
//		} else {
//			String numSplit = new DecimalFormat("#,###.###").format(Double.parseDouble(decimal));
//			String[] arregloNum = numSplit.split("\\.");
//			
//			if(arregloNum[1].length() == 1){
//				convertedStringDecimal = new DecimalFormat("#,###.00").format(Double.parseDouble(decimal));
//			}else if(arregloNum[1].length() == 3){
//				convertedStringDecimal = new DecimalFormat("#,###.00").format(Double.parseDouble(decimal));
//			}else{
//				convertedStringDecimal = new DecimalFormat("#,###.##").format(Double.parseDouble(decimal));
//			}
//		}
//		return convertedStringDecimal;
//	}
	
	
}

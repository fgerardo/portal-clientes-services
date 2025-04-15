package mx.com.allianz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.allianz.config.FolletosConfiguracion;

@Service
public class FolletoProductoUtil {

	@Autowired
	private FolletosConfiguracion folletosConfiguracion;

	public String obtenerUrlFolleto(String familia) {
		if (familia == null)
			return null;

		switch (familia.toUpperCase()) {
		case "HOGD":
			return folletosConfiguracion.getFolletoHOGD();
		case "HOGM":
			return folletosConfiguracion.getFolletoHOGM();
		case "HOFP":
			return folletosConfiguracion.getFolletoHOFP();
		case "HOFD":
			return folletosConfiguracion.getFolletoHOFD();
		case "GMMI":
			return folletosConfiguracion.getFolletoGMMI();
		case "VIPD":
			return folletosConfiguracion.getFolletoVIPD();
		case "VIPM":
			return folletosConfiguracion.getFolletoVIPM();
		case "OPCD":
			return folletosConfiguracion.getFolletoOPCD();
		case "OPED":
			return folletosConfiguracion.getFolletoOPED();
		case "PLU2":
			return folletosConfiguracion.getFolletoPLU2();
		case "PLUS":
			return folletosConfiguracion.getFolletoPLUS();
		case "FTOT":
			return folletosConfiguracion.getFolletoFTOT();
		case "ACTD":
			return folletosConfiguracion.getFolletoACTD();
		case "ACTM":
			return folletosConfiguracion.getFolletoACTM();
		case "OPMX":
			return folletosConfiguracion.getFolletoOPMX();
		case "OPPT":
			return folletosConfiguracion.getFolletoOPPT();
		case "OPPA":
			return folletosConfiguracion.getFolletoOPPA();
		case "SVIP":
			return folletosConfiguracion.getFolletoSVIP();
		case "SVID":
			return folletosConfiguracion.getFolletoSVID();
		default:
			return null;
		}
	}

}

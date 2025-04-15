package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "folletos")
public class FolletosConfiguracion {

	private String folletoHOGD;
	private String folletoHOGM;
	private String folletoHOFP;
	private String folletoHOFD;
	private String folletoGMMI;
	private String folletoVIPD;
	private String folletoVIPM;
	private String folletoOPCD;
	private String folletoOPED;
	private String folletoPLU2;
	private String folletoPLUS;
	private String folletoFTOT;
	private String folletoACTD;
	private String folletoACTM;
	private String folletoOPMX;
	private String folletoOPPT;
	private String folletoOPPA;
	private String folletoSVIP;
	private String folletoSVID;

	public String getFolletoHOGD() {
		return folletoHOGD;
	}

	public void setFolletoHOGD(String folletoHOGD) {
		this.folletoHOGD = folletoHOGD;
	}

	public String getFolletoHOGM() {
		return folletoHOGM;
	}

	public void setFolletoHOGM(String folletoHOGM) {
		this.folletoHOGM = folletoHOGM;
	}

	public String getFolletoHOFP() {
		return folletoHOFP;
	}

	public void setFolletoHOFP(String folletoHOFP) {
		this.folletoHOFP = folletoHOFP;
	}

	public String getFolletoHOFD() {
		return folletoHOFD;
	}

	public void setFolletoHOFD(String folletoHOFD) {
		this.folletoHOFD = folletoHOFD;
	}

	public String getFolletoGMMI() {
		return folletoGMMI;
	}

	public void setFolletoGMMI(String folletoGMMI) {
		this.folletoGMMI = folletoGMMI;
	}

	public String getFolletoVIPD() {
		return folletoVIPD;
	}

	public void setFolletoVIPD(String folletoVIPD) {
		this.folletoVIPD = folletoVIPD;
	}

	public String getFolletoVIPM() {
		return folletoVIPM;
	}

	public void setFolletoVIPM(String folletoVIPM) {
		this.folletoVIPM = folletoVIPM;
	}

	public String getFolletoOPCD() {
		return folletoOPCD;
	}

	public void setFolletoOPCD(String folletoOPCD) {
		this.folletoOPCD = folletoOPCD;
	}

	public String getFolletoOPED() {
		return folletoOPED;
	}

	public void setFolletoOPED(String folletoOPED) {
		this.folletoOPED = folletoOPED;
	}

	public String getFolletoPLU2() {
		return folletoPLU2;
	}

	public void setFolletoPLU2(String folletoPLU2) {
		this.folletoPLU2 = folletoPLU2;
	}

	public String getFolletoPLUS() {
		return folletoPLUS;
	}

	public void setFolletoPLUS(String folletoPLUS) {
		this.folletoPLUS = folletoPLUS;
	}

	public String getFolletoFTOT() {
		return folletoFTOT;
	}

	public void setFolletoFTOT(String folletoFTOT) {
		this.folletoFTOT = folletoFTOT;
	}

	public String getFolletoACTD() {
		return folletoACTD;
	}

	public void setFolletoACTD(String folletoACTD) {
		this.folletoACTD = folletoACTD;
	}

	public String getFolletoACTM() {
		return folletoACTM;
	}

	public void setFolletoACTM(String folletoACTM) {
		this.folletoACTM = folletoACTM;
	}

	public String getFolletoOPMX() {
		return folletoOPMX;
	}

	public void setFolletoOPMX(String folletoOPMX) {
		this.folletoOPMX = folletoOPMX;
	}

	public String getFolletoOPPT() {
		return folletoOPPT;
	}

	public void setFolletoOPPT(String folletoOPPT) {
		this.folletoOPPT = folletoOPPT;
	}

	public String getFolletoOPPA() {
		return folletoOPPA;
	}

	public void setFolletoOPPA(String folletoOPPA) {
		this.folletoOPPA = folletoOPPA;
	}

	public String getFolletoSVIP() {
		return folletoSVIP;
	}

	public void setFolletoSVIP(String folletoSVIP) {
		this.folletoSVIP = folletoSVIP;
	}

	public String getFolletoSVID() {
		return folletoSVID;
	}

	public void setFolletoSVID(String folletoSVID) {
		this.folletoSVID = folletoSVID;
	}

}

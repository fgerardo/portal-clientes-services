package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PolizaLimpiaModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 5880806501203902329L;

	private String codCondGen;
	private NovedadesModel novedades;
	ArrayList<Object> vehiculo;
	private GeneralesModel generales;
	private Contratante contratante;
	private InformacionPersonalModel informacionPersonal;
	private String familiaColor;
	private ArrayList<Asegurado> asegurados;
	private List<CoberturasModel> coberturas;
	private String claveAgente;
	private String urlFolleto;
	private List<BienAsegurado> bienesAsegurado;
	private List<InmuebleAseguradoDestino> inmueblesAsegurado;
	private String colorEmisor;
	private List<Beneficiario> beneficiarios;
	private PolizaModel poliza;

	public List<InmuebleAseguradoDestino> getInmueblesAsegurado() {
		return inmueblesAsegurado;
	}

	public void setInmueblesAsegurado(List<InmuebleAseguradoDestino> inmueblesasegurado2) {
		this.inmueblesAsegurado = inmueblesasegurado2;
	}

	public List<BienAsegurado> getBienesAsegurado() {
		return bienesAsegurado;
	}

	public void setBienesAsegurado(List<BienAsegurado> bienesAsegurado) {
		this.bienesAsegurado = bienesAsegurado;
	}

	public String getClaveAgente() {
		return claveAgente;
	}

	public void setClaveAgente(String claveAgente) {
		this.claveAgente = claveAgente;
	}

	public String getUrlFolleto() {
		return urlFolleto;
	}

	public void setUrlFolleto(String urlFolleto) {
		this.urlFolleto = urlFolleto;
	}

	public List<CoberturasModel> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<CoberturasModel> coberturas) {
		this.coberturas = coberturas;
	}

	public String getFamiliaColor() {
		return familiaColor;
	}

	public void setFamiliaColor(String familiaColor) {
		this.familiaColor = familiaColor;
	}

	public String getCodCondGen() {
		return codCondGen;
	}

	public void setCodCondGen(String codCondGen) {
		this.codCondGen = codCondGen;
	}

	public NovedadesModel getNovedades() {
		return novedades;
	}

	public void setNovedades(NovedadesModel novedades) {
		this.novedades = novedades;
	}

	public ArrayList<Object> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ArrayList<Object> vehiculo) {
		this.vehiculo = vehiculo;
	}

	public GeneralesModel getGenerales() {
		return generales;
	}

	public void setGenerales(GeneralesModel generales) {
		this.generales = generales;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public InformacionPersonalModel getInformacionPersonal() {
		return informacionPersonal;
	}

	public void setInformacionPersonal(InformacionPersonalModel informacionPersonal) {
		this.informacionPersonal = informacionPersonal;
	}

	public ArrayList<Asegurado> getAsegurados() {
		return asegurados;
	}

	public void setAsegurados(ArrayList<Asegurado> asegurados) {
		this.asegurados = asegurados;
	}

	public String getColorEmisor() {
		return colorEmisor;
	}

	public void setColorEmisor(String colorEmisor) {
		this.colorEmisor = colorEmisor;
	}

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public PolizaModel getPoliza() {
		return poliza;
	}

	public void setPoliza(PolizaModel poliza) {
		this.poliza = poliza;
	}

	@Override
	public String toString() {
		return "PolizaLimpiaModel [codCondGen=" + codCondGen + ", novedades=" + novedades + ", vehiculo=" + vehiculo
				+ ", generales=" + generales + ", contratante=" + contratante + ", informacionPersonal="
				+ informacionPersonal + ", familiaColor=" + familiaColor + ", asegurados=" + asegurados
				+ ", coberturas=" + coberturas + ", claveAgente=" + claveAgente + ", urlFolleto=" + urlFolleto
				+ ", bienesAsegurado=" + bienesAsegurado + ", inmueblesAsegurado=" + inmueblesAsegurado
				+ ", colorEmisor=" + colorEmisor + ", beneficiarios=" + beneficiarios + ", poliza=" + poliza + "]";
	}

}

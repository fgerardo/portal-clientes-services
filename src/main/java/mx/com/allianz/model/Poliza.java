package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poliza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -416019918272137333L;
	@JsonProperty("IDEPOL") // Cambié aquí
	public int iDEPOL;
	@JsonProperty("Segmento")
	public String segmento;
	@JsonProperty("Lob")
	public String lob;
	@JsonProperty("Producto")
	public String producto;
	@JsonProperty("Emisor")
	public String emisor;
	@JsonProperty("NumPoliza")
	public int numPoliza;
	@JsonProperty("IdRenovacion")
	public int idRenovacion;
	@JsonProperty("EstatusPoliza")
	public String estatusPoliza;
	@JsonProperty("FechaEmision")
	public String fechaEmision;
	@JsonProperty("FecIniVig")
	public String fecIniVig;
	@JsonProperty("FecFinVig")
	public String fecFinVig;
	@JsonProperty("Plan")
	public String plan;
	@JsonProperty("PolizaAnterior")
	public String polizaAnterior;
	@JsonProperty("CodCondGen")
	public String codCondGen;
	@JsonProperty("CodMoneda")
	public String codMoneda;
	public String mostrarPolizaAgente;
	@JsonProperty("Cobertura")
	public ArrayList<Object> cobertura;
	@JsonProperty("BienAsegurado")
	public ArrayList<Object> bienAsegurado;
	@JsonProperty("Beneficiario")
	public ArrayList<Beneficiario> beneficiario;
	@JsonProperty("LeyendaMosaico")
	public ArrayList<LeyendaMosaico> leyendaMosaico;
	@JsonProperty("Fondo")
	public ArrayList<Fondo> fondo;
	@JsonProperty("Asegurado")
	public ArrayList<Asegurado> asegurado;
	@JsonProperty("Intermediario")
	public ArrayList<Intermediario> intermediario;
	@JsonProperty("InmuebleAsegurado")
	public ArrayList<Object> inmuebleAsegurado;
	@JsonProperty("ResponsablePago")
	public ArrayList<ResponsablePago> responsablePago;
	@JsonProperty("EstadoCuenta")
	public ArrayList<Object> estadoCuenta;
	public int numeroSolicitud;
	@JsonProperty("Vehiculo")
	public ArrayList<Object> vehiculo;
	@JsonProperty("NumCert")
	public String numCert;
	@JsonProperty("IDEPOL_NUMCERT")
	public String iDEPOL_NUMCERT;
	@JsonProperty("IDEPOL_NUMCERT_USAPP")
	public String iDEPOL_NUMCERT_USAPP;
	@JsonProperty("IDCLIENTE_POLIZA")
	public String iDCLIENTE_POLIZA;
	@JsonProperty("EsContratante")
	public String esContratante;
	@JsonProperty("IDESCONTRATANTEPOLIZA")
	public String iDESCONTRATANTEPOLIZA;
	@JsonProperty("Contratante")
	public ArrayList<Contratante> contratante;

	public int getiDEPOL() {
		return iDEPOL;
	}

	public void setiDEPOL(int iDEPOL) {
		this.iDEPOL = iDEPOL;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public int getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}

	public int getIdRenovacion() {
		return idRenovacion;
	}

	public void setIdRenovacion(int idRenovacion) {
		this.idRenovacion = idRenovacion;
	}

	public String getEstatusPoliza() {
		return estatusPoliza;
	}

	public void setEstatusPoliza(String estatusPoliza) {
		this.estatusPoliza = estatusPoliza;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFecIniVig() {
		return fecIniVig;
	}

	public void setFecIniVig(String fecIniVig) {
		this.fecIniVig = fecIniVig;
	}

	public String getFecFinVig() {
		return fecFinVig;
	}

	public void setFecFinVig(String fecFinVig) {
		this.fecFinVig = fecFinVig;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getPolizaAnterior() {
		return polizaAnterior;
	}

	public void setPolizaAnterior(String polizaAnterior) {
		this.polizaAnterior = polizaAnterior;
	}

	public String getCodCondGen() {
		return codCondGen;
	}

	public void setCodCondGen(String codCondGen) {
		this.codCondGen = codCondGen;
	}

	public String getCodMoneda() {
		return codMoneda;
	}

	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}

	public String getMostrarPolizaAgente() {
		return mostrarPolizaAgente;
	}

	public void setMostrarPolizaAgente(String mostrarPolizaAgente) {
		this.mostrarPolizaAgente = mostrarPolizaAgente;
	}

	public ArrayList<Object> getCobertura() {
		return cobertura;
	}

	public void setCobertura(ArrayList<Object> cobertura) {
		this.cobertura = cobertura;
	}

	public ArrayList<Object> getBienAsegurado() {
		return bienAsegurado;
	}

	public void setBienAsegurado(ArrayList<Object> bienAsegurado) {
		this.bienAsegurado = bienAsegurado;
	}

	public ArrayList<Beneficiario> getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(ArrayList<Beneficiario> beneficiario) {
		this.beneficiario = beneficiario;
	}

	public ArrayList<LeyendaMosaico> getLeyendaMosaico() {
		return leyendaMosaico;
	}

	public void setLeyendaMosaico(ArrayList<LeyendaMosaico> leyendaMosaico) {
		this.leyendaMosaico = leyendaMosaico;
	}

	public ArrayList<Fondo> getFondo() {
		return fondo;
	}

	public void setFondo(ArrayList<Fondo> fondo) {
		this.fondo = fondo;
	}

	public ArrayList<Asegurado> getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(ArrayList<Asegurado> asegurado) {
		this.asegurado = asegurado;
	}

	public ArrayList<Intermediario> getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(ArrayList<Intermediario> intermediario) {
		this.intermediario = intermediario;
	}

	public ArrayList<Object> getInmuebleAsegurado() {
		return inmuebleAsegurado;
	}

	public void setInmuebleAsegurado(ArrayList<Object> inmuebleAsegurado) {
		this.inmuebleAsegurado = inmuebleAsegurado;
	}

	public ArrayList<ResponsablePago> getResponsablePago() {
		return responsablePago;
	}

	public void setResponsablePago(ArrayList<ResponsablePago> responsablePago) {
		this.responsablePago = responsablePago;
	}

	public ArrayList<Object> getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(ArrayList<Object> estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public ArrayList<Object> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ArrayList<Object> vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getNumCert() {
		return numCert;
	}

	public void setNumCert(String numCert) {
		this.numCert = numCert;
	}

	public String getiDEPOL_NUMCERT() {
		return iDEPOL_NUMCERT;
	}

	public void setiDEPOL_NUMCERT(String iDEPOL_NUMCERT) {
		this.iDEPOL_NUMCERT = iDEPOL_NUMCERT;
	}

	public String getiDEPOL_NUMCERT_USAPP() {
		return iDEPOL_NUMCERT_USAPP;
	}

	public void setiDEPOL_NUMCERT_USAPP(String iDEPOL_NUMCERT_USAPP) {
		this.iDEPOL_NUMCERT_USAPP = iDEPOL_NUMCERT_USAPP;
	}

	public String getiDCLIENTE_POLIZA() {
		return iDCLIENTE_POLIZA;
	}

	public void setiDCLIENTE_POLIZA(String iDCLIENTE_POLIZA) {
		this.iDCLIENTE_POLIZA = iDCLIENTE_POLIZA;
	}

	public String getEsContratante() {
		return esContratante;
	}

	public void setEsContratante(String esContratante) {
		this.esContratante = esContratante;
	}

	public String getiDESCONTRATANTEPOLIZA() {
		return iDESCONTRATANTEPOLIZA;
	}

	public void setiDESCONTRATANTEPOLIZA(String iDESCONTRATANTEPOLIZA) {
		this.iDESCONTRATANTEPOLIZA = iDESCONTRATANTEPOLIZA;
	}

	public ArrayList<Contratante> getContratante() {
		return contratante;
	}

	public void setContratante(ArrayList<Contratante> contratante) {
		this.contratante = contratante;
	}

	@Override
	public String toString() {
		return "Poliza [iDEPOL=" + iDEPOL + ", segmento=" + segmento + ", lob=" + lob + ", producto=" + producto
				+ ", emisor=" + emisor + ", numPoliza=" + numPoliza + ", idRenovacion=" + idRenovacion
				+ ", estatusPoliza=" + estatusPoliza + ", fechaEmision=" + fechaEmision + ", fecIniVig=" + fecIniVig
				+ ", fecFinVig=" + fecFinVig + ", plan=" + plan + ", polizaAnterior=" + polizaAnterior + ", codCondGen="
				+ codCondGen + ", codMoneda=" + codMoneda + ", mostrarPolizaAgente=" + mostrarPolizaAgente
				+ ", cobertura=" + cobertura + ", bienAsegurado=" + bienAsegurado + ", beneficiario=" + beneficiario
				+ ", leyendaMosaico=" + leyendaMosaico + ", fondo=" + fondo + ", asegurado=" + asegurado
				+ ", intermediario=" + intermediario + ", inmuebleAsegurado=" + inmuebleAsegurado + ", estadoCuenta="
				+ estadoCuenta + ", numeroSolicitud=" + numeroSolicitud + ", vehiculo=" + vehiculo + ", numCert="
				+ numCert + ", iDEPOL_NUMCERT=" + iDEPOL_NUMCERT + ", iDEPOL_NUMCERT_USAPP=" + iDEPOL_NUMCERT_USAPP
				+ ", iDCLIENTE_POLIZA=" + iDCLIENTE_POLIZA + ", esContratante=" + esContratante
				+ ", iDESCONTRATANTEPOLIZA=" + iDESCONTRATANTEPOLIZA + ", contratante=" + contratante + "]";
	}

}

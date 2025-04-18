package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

import org.json.JSONObject;

import mx.com.allianz.util.DetalleDeSaldo;

public class ResponsePolizaModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3901925569654331533L;
	private boolean estatus;
	private String mensaje;
	private String idClientePoliza;
	private String rfc;
	private String nombre;
	private String tipoPersona;
	private String apellidoP;
	private String esContratante;
	private String apellidoM;
	private GeneralesModel generales;
	private DetalleDeSaldo detalleSaldo;
	private List<AlertasModel> alertas;
	private List<NotificacionModel> notificaciones;
	private List<Pago> proximosPagos;
	private List<PolizaModel> poliza;
	private JSONObject obtenerJsonFamiliasParaLaRuleta;
	private TramitesObjecto tramites;

	public String getEsContratante() {
		return esContratante;
	}

	public void setEsContratante(String esContratante) {
		this.esContratante = esContratante;
	}

	public List<PolizaModel> getPoliza() {
		return poliza;
	}

	public void setPoliza(List<PolizaModel> poliza) {
		this.poliza = poliza;
	}

	public List<Pago> getProximosPagos() {
		return proximosPagos;
	}

	public void setProximosPagos(List<Pago> list) {
		this.proximosPagos = list;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdClientePoliza() {
		return idClientePoliza;
	}

	public void setIdClientePoliza(String idClientePoliza) {
		this.idClientePoliza = idClientePoliza;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public GeneralesModel getGenerales() {
		return generales;
	}

	public void setGenerales(GeneralesModel generales) {
		this.generales = generales;
	}

	public DetalleDeSaldo getDetalleSaldo() {
		return detalleSaldo;
	}

	public void setDetalleSaldo(DetalleDeSaldo detalleSaldo) {
		this.detalleSaldo = detalleSaldo;
	}

	public List<AlertasModel> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<AlertasModel> alertas) {
		this.alertas = alertas;
	}

	public List<NotificacionModel> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<NotificacionModel> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public JSONObject getObtenerJsonFamiliasParaLaRuleta() {
		return obtenerJsonFamiliasParaLaRuleta;
	}

	public void setObtenerJsonFamiliasParaLaRuleta(JSONObject obtenerJsonFamiliasParaLaRuleta) {
		this.obtenerJsonFamiliasParaLaRuleta = obtenerJsonFamiliasParaLaRuleta;
	}

	public TramitesObjecto getTramites() {
		return tramites;
	}

	public void setTramites(TramitesObjecto tramites) {
		this.tramites = tramites;
	}

	@Override
	public String toString() {
		return "ResponsePolizaModel [estatus=" + estatus + ", mensaje=" + mensaje + ", idClientePoliza="
				+ idClientePoliza + ", rfc=" + rfc + ", nombre=" + nombre + ", tipoPersona=" + tipoPersona
				+ ", apellidoP=" + apellidoP + ", esContratante=" + esContratante + ", apellidoM=" + apellidoM
				+ ", generales=" + generales + ", detalleSaldo=" + detalleSaldo + ", alertas=" + alertas
				+ ", notificaciones=" + notificaciones + ", proximosPagos=" + proximosPagos + ", poliza=" + poliza
				+ ", obtenerJsonFamiliasParaLaRuleta=" + obtenerJsonFamiliasParaLaRuleta + ", tramites=" + tramites
				+ "]";
	}

}

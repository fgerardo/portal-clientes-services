package mx.com.allianz.model.response;

import java.io.Serializable;
import java.util.List;

import org.json.JSONObject;

import mx.com.allianz.model.ClientePensiones;
import mx.com.allianz.model.ComunicadoJson;
import mx.com.allianz.model.NotificacionModel;
import mx.com.allianz.model.Pago;
import mx.com.allianz.model.PolizaModel;
import mx.com.allianz.model.ResumenSaldos;
import mx.com.allianz.model.TramitesObjecto;
import mx.com.allianz.model.Vigencias;
import mx.com.allianz.model.expediente.ExpedienteEstatusRfcDTO;
import mx.com.allianz.util.DetalleDeSaldo;
import mx.com.allianz.whatsap.model.WhatsapModel;

public class JsonParseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4466969646432837467L;
	private String jsonString;
	private Cliente cliente = new Cliente();
	private List<PolizaModel> polizaStr;
	private TramitesObjecto tramitesStr;
	private List<Pago> proximosPagos;
	private DetalleDeSaldo detalleDeSaldo;
	private List<NotificacionModel> notificaciones;
	private JSONObject familiasParaLaRuleta;
	private List<Vigencias> vigencias;
	private String version_portal;
	private WhatsapModel InfoWhatsApp;
	private ResumenSaldos sumasPolizas;
	private String tipoPersona;
	private String rfc;
	private String rfcEncript;
	private ExpedienteEstatusRfcDTO expedienteCompleto;
	private String isContratante;
	private List<ComunicadoJson> listaDeAvisos;
	private String urlSiniestros;
	private String productoPagoLineaSuceptibles;
	private String productosProgramarPago;
	private String productosEnvioCobro;
	private String ProductoAhorros;
	private String correoUsuario;
	private String productosSuceptiblesEdoCuentaSaldos;
	private String productosEmpresariales;
	private String codCli;
	private ClientePensiones clientePensiones;

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PolizaModel> getPolizaStr() {
		return polizaStr;
	}

	public void setPolizaStr(List<PolizaModel> polizaStr) {
		this.polizaStr = polizaStr;
	}

	public TramitesObjecto getTramitesStr() {
		return tramitesStr;
	}

	public void setTramitesStr(TramitesObjecto tramitesStr) {
		this.tramitesStr = tramitesStr;
	}

	public List<Pago> getProximosPagos() {
		return proximosPagos;
	}

	public void setProximosPagos(List<Pago> list) {
		this.proximosPagos = list;
	}

	public DetalleDeSaldo getDetalleDeSaldo() {
		return detalleDeSaldo;
	}

	public void setDetalleDeSaldo(DetalleDeSaldo detalleDeSaldo) {
		this.detalleDeSaldo = detalleDeSaldo;
	}

	public List<NotificacionModel> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<NotificacionModel> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public JSONObject getFamiliasParaLaRuleta() {
		return familiasParaLaRuleta;
	}

	public void setFamiliasParaLaRuleta(JSONObject familiasParaLaRuleta) {
		this.familiasParaLaRuleta = familiasParaLaRuleta;
	}

	public List<Vigencias> getVigencias() {
		return vigencias;
	}

	public void setVigencias(List<Vigencias> vigencias) {
		this.vigencias = vigencias;
	}

	public String getVersion_portal() {
		return version_portal;
	}

	public void setVersion_portal(String version_portal) {
		this.version_portal = version_portal;
	}

	public WhatsapModel getInfoWhatsApp() {
		return InfoWhatsApp;
	}

	public void setInfoWhatsApp(WhatsapModel infoWhatsApp) {
		InfoWhatsApp = infoWhatsApp;
	}

	public ResumenSaldos getSumasPolizas() {
		return sumasPolizas;
	}

	public void setSumasPolizas(ResumenSaldos resumenSaldos) {
		this.sumasPolizas = resumenSaldos;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getIsContratante() {
		return isContratante;
	}

	public void setIsContratante(String isContratante) {
		this.isContratante = isContratante;
	}

	public String getRfcEncript() {
		return rfcEncript;
	}

	public void setRfcEncript(String rfcEncript) {
		this.rfcEncript = rfcEncript;
	}

	public ExpedienteEstatusRfcDTO getExpedienteCompleto() {
		return expedienteCompleto;
	}

	public void setExpedienteCompleto(ExpedienteEstatusRfcDTO expedienteCompleto) {
		this.expedienteCompleto = expedienteCompleto;
	}

	public List<ComunicadoJson> getListaDeAvisos() {
		return listaDeAvisos;
	}

	public void setListaDeAvisos(List<ComunicadoJson> listaDeAvisos) {
		this.listaDeAvisos = listaDeAvisos;
	}

	public String getUrlSiniestros() {
		return urlSiniestros;
	}

	public void setUrlSiniestros(String urlSiniestros) {
		this.urlSiniestros = urlSiniestros;
	}

	public String getProductoPagoLineaSuceptibles() {
		return productoPagoLineaSuceptibles;
	}

	public void setProductoPagoLineaSuceptibles(String productoPagoLineaSuceptibles) {
		this.productoPagoLineaSuceptibles = productoPagoLineaSuceptibles;
	}

	public String getProductosProgramarPago() {
		return productosProgramarPago;
	}

	public void setProductosProgramarPago(String productosProgramarPago) {
		this.productosProgramarPago = productosProgramarPago;
	}

	public String getProductosEnvioCobro() {
		return productosEnvioCobro;
	}

	public void setProductosEnvioCobro(String productosEnvioCobro) {
		this.productosEnvioCobro = productosEnvioCobro;
	}

	public String getProductoAhorros() {
		return ProductoAhorros;
	}

	public void setProductoAhorros(String productoAhorros) {
		ProductoAhorros = productoAhorros;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getProductosSuceptiblesEdoCuentaSaldos() {
		return productosSuceptiblesEdoCuentaSaldos;
	}

	public void setProductosSuceptiblesEdoCuentaSaldos(String productosSuceptiblesEdoCuentaSaldos) {
		this.productosSuceptiblesEdoCuentaSaldos = productosSuceptiblesEdoCuentaSaldos;
	}

	public String getProductosEmpresariales() {
		return productosEmpresariales;
	}

	public void setProductosEmpresariales(String productosEmpresariales) {
		this.productosEmpresariales = productosEmpresariales;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public ClientePensiones getClientePensiones() {
		return clientePensiones;
	}

	public void setClientePensiones(ClientePensiones clientePensiones) {
		this.clientePensiones = clientePensiones;
	}

	@Override
	public String toString() {
		return "JsonParseModel [jsonString=" + jsonString + ", cliente=" + cliente + ", polizaStr=" + polizaStr
				+ ", tramitesStr=" + tramitesStr + ", proximosPagos=" + proximosPagos + ", detalleDeSaldo="
				+ detalleDeSaldo + ", notificaciones=" + notificaciones + ", familiasParaLaRuleta="
				+ familiasParaLaRuleta + ", vigencias=" + vigencias + ", version_portal=" + version_portal
				+ ", InfoWhatsApp=" + InfoWhatsApp + ", sumasPolizas=" + sumasPolizas + ", tipoPersona=" + tipoPersona
				+ ", rfc=" + rfc + ", rfcEncript=" + rfcEncript + ", expedienteCompleto=" + expedienteCompleto
				+ ", isContratante=" + isContratante + ", listaDeAvisos=" + listaDeAvisos + ", urlSiniestros="
				+ urlSiniestros + ", productoPagoLineaSuceptibles=" + productoPagoLineaSuceptibles
				+ ", productosProgramarPago=" + productosProgramarPago + ", productosEnvioCobro=" + productosEnvioCobro
				+ ", ProductoAhorros=" + ProductoAhorros + ", correoUsuario=" + correoUsuario
				+ ", productosSuceptiblesEdoCuentaSaldos=" + productosSuceptiblesEdoCuentaSaldos
				+ ", productosEmpresariales=" + productosEmpresariales + ", codCli=" + codCli + ", clientePensiones="
				+ clientePensiones + "]";
	}

}

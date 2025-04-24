package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services")
public class ServicesConfiguration {

	private String servicioLogin;
	private String servicioCifrado;
	private String urlRegistrarBitacoraAcceso;
	private String urlConsultarUsuarioBitacora;
	private String urlConsultarAllImagenes;
	private String urlServicioRecuperaPassword;
	private String portalUrlParametros;
	private String servicioEstatusSiniestroEmail;
	private String usuarioAuthorizationServices;
	private String passworAuthorizationServices;
	private String consultarServicioUsuarioEmail;
	private String securityLoginContratante;
	private String servicioPolizas;
	private String servicioPolizasGmm;
	private String urlConsultarNotificacion;
	private String urlConsultarImagenPerfil;
	private String urlConsultarTramites;
	private String servicioPensiones;
	private String urlExpedienteCompletoRfc;
	private String servicioAvisos;
	private String urlConsultarAvisos;

	public String getUrlConsultarTramites() {
		return urlConsultarTramites;
	}

	public void setUrlConsultarTramites(String urlConsultarTramites) {
		this.urlConsultarTramites = urlConsultarTramites;
	}

	public String getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(String servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	public String getServicioCifrado() {
		return servicioCifrado;
	}

	public void setServicioCifrado(String servicioCifrado) {
		this.servicioCifrado = servicioCifrado;
	}

	public String getUrlRegistrarBitacoraAcceso() {
		return urlRegistrarBitacoraAcceso;
	}

	public void setUrlRegistrarBitacoraAcceso(String urlRegistrarBitacoraAcceso) {
		this.urlRegistrarBitacoraAcceso = urlRegistrarBitacoraAcceso;
	}

	public String getUrlConsultarUsuarioBitacora() {
		return urlConsultarUsuarioBitacora;
	}

	public void setUrlConsultarUsuarioBitacora(String urlConsultarUsuarioBitacora) {
		this.urlConsultarUsuarioBitacora = urlConsultarUsuarioBitacora;
	}

	public String getUrlConsultarAllImagenes() {
		return urlConsultarAllImagenes;
	}

	public void setUrlConsultarAllImagenes(String urlConsultarAllImagenes) {
		this.urlConsultarAllImagenes = urlConsultarAllImagenes;
	}

	public String getUrlServicioRecuperaPassword() {
		return urlServicioRecuperaPassword;
	}

	public void setUrlServicioRecuperaPassword(String urlServicioRecuperaPassword) {
		this.urlServicioRecuperaPassword = urlServicioRecuperaPassword;
	}

	public String getPortalUrlParametros() {
		return portalUrlParametros;
	}

	public void setPortalUrlParametros(String portalUrlParametros) {
		this.portalUrlParametros = portalUrlParametros;
	}

	public String getServicioEstatusSiniestroEmail() {
		return servicioEstatusSiniestroEmail;
	}

	public void setServicioEstatusSiniestroEmail(String servicioEstatusSiniestroEmail) {
		this.servicioEstatusSiniestroEmail = servicioEstatusSiniestroEmail;
	}

	public String getUsuarioAuthorizationServices() {
		return usuarioAuthorizationServices;
	}

	public void setUsuarioAuthorizationServices(String usuarioAuthorizationServices) {
		this.usuarioAuthorizationServices = usuarioAuthorizationServices;
	}

	public String getPassworAuthorizationServices() {
		return passworAuthorizationServices;
	}

	public void setPassworAuthorizationServices(String passworAuthorizationServices) {
		this.passworAuthorizationServices = passworAuthorizationServices;
	}

	public String getConsultarServicioUsuarioEmail() {
		return consultarServicioUsuarioEmail;
	}

	public void setConsultarServicioUsuarioEmail(String consultarServicioUsuarioEmail) {
		this.consultarServicioUsuarioEmail = consultarServicioUsuarioEmail;
	}

	public String getSecurityLoginContratante() {
		return securityLoginContratante;
	}

	public void setSecurityLoginContratante(String securityLoginContratante) {
		this.securityLoginContratante = securityLoginContratante;
	}

	public String getServicioPolizas() {
		return servicioPolizas;
	}

	public void setServicioPolizas(String servicioPolizas) {
		this.servicioPolizas = servicioPolizas;
	}

	public String getServicioPolizasGmm() {
		return servicioPolizasGmm;
	}

	public void setServicioPolizasGmm(String servicioPolizasGmm) {
		this.servicioPolizasGmm = servicioPolizasGmm;
	}

	public String getUrlConsultarImagenPerfil() {
		return urlConsultarImagenPerfil;
	}

	public void setUrlConsultarImagenPerfil(String urlConsultarImagenPerfil) {
		this.urlConsultarImagenPerfil = urlConsultarImagenPerfil;
	}

	public String getUrlConsultarNotificacion() {
		return urlConsultarNotificacion;
	}

	public void setUrlConsultarNotificacion(String urlConsultarNotificacion) {
		this.urlConsultarNotificacion = urlConsultarNotificacion;
	}

	public String getServicioPensiones() {
		return servicioPensiones;
	}

	public void setServicioPensiones(String servicioPensiones) {
		this.servicioPensiones = servicioPensiones;
	}

	public String getUrlExpedienteCompletoRfc() {
		return urlExpedienteCompletoRfc;
	}

	public void setUrlExpedienteCompletoRfc(String urlExpedienteCompletoRfc) {
		this.urlExpedienteCompletoRfc = urlExpedienteCompletoRfc;
	}

	public String getServicioAvisos() {
		return servicioAvisos;
	}

	public void setServicioAvisos(String servicioAvisos) {
		this.servicioAvisos = servicioAvisos;
	}

	public String getUrlConsultarAvisos() {
		return urlConsultarAvisos;
	}

	public void setUrlConsultarAvisos(String urlConsultarAvisos) {
		this.urlConsultarAvisos = urlConsultarAvisos;
	}

}

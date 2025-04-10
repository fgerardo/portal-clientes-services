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

}

package mx.com.allianz.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBElement;
import mx.com.allianz.central.comunicados.service.ObtenerComunicadoRequest;
import mx.com.allianz.central.comunicados.service.ObtenerComunicadoResponse;
import mx.com.allianz.cipher.service.Crypt;
import mx.com.allianz.cipher.service.CryptResponse;
import mx.com.allianz.cipher.service.CryptWithHtmlEscape;
import mx.com.allianz.cipher.service.CryptWithHtmlEscapeResponse;
import mx.com.allianz.cipher.service.CryptWithUrlEscape;
import mx.com.allianz.cipher.service.CryptWithUrlEscapeResponse;
import mx.com.allianz.cipher.service.Decrypt;
import mx.com.allianz.cipher.service.DecryptResponse;
import mx.com.allianz.cipher.service.DecryptWithUrlUnEscape;
import mx.com.allianz.cipher.service.DecryptWithUrlUnEscapeResponse;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.login.service.LoginResponseDto;
import mx.com.allianz.login.service.LoginService;
import mx.com.allianz.login.service.LoginServiceResponse;
import mx.com.allianz.recupera.password.service.RecuperarContrasena;
import mx.com.allianz.recupera.password.service.RecuperarContrasenaResponse;
import mx.com.allianz.recupera.password.service.RecuperarContrasenaResponseDto;

@Service
public class SoapClient {

	/**
	 * Permite realizar el logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);

	@Autowired
	@Qualifier("login")
	private Jaxb2Marshaller marshaller;

	@Autowired
	@Qualifier("recuperaContrasena")
	private Jaxb2Marshaller marshallerRecuperaContrasena;

	@Autowired
	@Qualifier("cipher")
	private Jaxb2Marshaller marshallerCipher;
	
	@Autowired
	@Qualifier("centralComunicados")
	private Jaxb2Marshaller marshallerCipherCentralComunicados;

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	private WebServiceTemplate template;

	@PostConstruct
	public void init() {
		// Configurar template una vez
		this.template = new WebServiceTemplate(marshallerRecuperaContrasena);
		this.template.setMarshaller(marshallerRecuperaContrasena);
		this.template.setUnmarshaller(marshallerRecuperaContrasena);
	}

	public CryptResponse getEncrypt(Crypt p) {
		return invokeCipherService(p, marshallerCipher);
	}

	public DecryptResponse getDecrypt(Decrypt p) {
		return invokeCipherServiceDecrypt(p, marshallerCipher);
	}
	
	public ObtenerComunicadoResponse getComunicado(ObtenerComunicadoRequest p) {
		return invokeComunicadosService(p, marshallerCipherCentralComunicados);
	}

	private CryptResponse invokeCipherService(Crypt p, Jaxb2Marshaller marshaller) {
		template.setMarshaller(marshaller);
		template.setUnmarshaller(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioCifrado(),
				p);
		return (CryptResponse) obj.getValue();
	}

	/**
	 * Metodo para enviar correo, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/temp-mailsender/services/TemplateMailSenderWs
	 * 
	 * @param p Objeto con la cadena a con los parametros en texto plano
	 * @return boolean
	 */
	public LoginResponseDto inicarSesion(LoginService p) {
		try {
			template.setMarshaller(marshaller);
			template.setUnmarshaller(marshaller);

			LoginServiceResponse loginServiceResponse = (LoginServiceResponse) template
					.marshalSendAndReceive(servicesConfiguration.getServicioLogin(), p);

			LoginResponseDto response = loginServiceResponse.getLoginServiceReturn();
			LOGGER.info("LoginResponseDto--> " + response.toString());

			return response;
		} catch (Exception e) {
			LOGGER.error("Error while calling SOAP service", e);
			throw new RuntimeException("SOAP call failed", e);
		}
	}

	/**
	 * Metodo para encriptar una cadena, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/cipher/services/CipherWs
	 * 
	 * @param p Objeto con la cadena a encriptar en texto plano
	 * @return Objeto con la cadena encriptada
	 */
	public CryptWithUrlEscapeResponse getEncryptUrlEscape(CryptWithUrlEscape p) {
		template = new WebServiceTemplate(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioCifrado(),
				p);
		CryptWithUrlEscapeResponse response = (CryptWithUrlEscapeResponse) obj.getValue();
		return response;
	}

	/**
	 * Metodo para encriptar una cadena, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/cipher/services/CipherWs
	 * 
	 * @param p Objeto con la cadena a encriptar en texto plano
	 * @return Objeto con la cadena encriptada
	 */
	public CryptWithHtmlEscapeResponse getEncryptHtml(CryptWithHtmlEscape p) {
		template = new WebServiceTemplate(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioCifrado(),
				p);
		CryptWithHtmlEscapeResponse response = (CryptWithHtmlEscapeResponse) obj.getValue();
		return response;
	}

	/**
	 * Metodo para desencriptar una cadena, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/cipher/services/CipherWs
	 * 
	 * @param p Objeto con la cadena encriptada a desencriptar
	 * @return objeto con la cadena desencriptada
	 */
	private DecryptResponse invokeCipherServiceDecrypt(Decrypt p, Jaxb2Marshaller marshaller) {
		template.setMarshaller(marshaller);
		template.setUnmarshaller(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioCifrado(),
				p);
		return (DecryptResponse) obj.getValue();
	}

	/**
	 * Metodo para desencriptar una cadena enviada por URL, se invoca el servicio
	 * SOAP https://portalb.allianz.com.mx/cipher/services/CipherWs
	 * 
	 * @param p Objeto con la cadena encriptada a desencriptar
	 * @return objeto con la cadena desencriptada
	 */
	public DecryptWithUrlUnEscapeResponse getDecryptWithUrlUnEscape(DecryptWithUrlUnEscape p) {
		template = new WebServiceTemplate(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioCifrado(),
				p);
		DecryptWithUrlUnEscapeResponse response = (DecryptWithUrlUnEscapeResponse) obj.getValue();
		return response;
	}

	/**
	 * Metodo para enviar correo, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/temp-mailsender/services/TemplateMailSenderWs
	 * 
	 * @param p Objeto con la cadena a con los parametros en texto plano
	 * @return boolean
	 */
	public RecuperarContrasenaResponseDto recuperaContrasena(RecuperarContrasena p) {
		try {
			// Realiza la solicitud SOAP
			RecuperarContrasenaResponse loginServiceResponse = (RecuperarContrasenaResponse) template
					.marshalSendAndReceive(servicesConfiguration.getUrlServicioRecuperaPassword(), p);

			// Obtén la respuesta
			RecuperarContrasenaResponseDto response = loginServiceResponse.getRecuperarContrasenaReturn();
			if (response != null) {
				LOGGER.info("RecuperarContrasenaResponseDto--> " + response.toString());
				return response;
			} else {
				LOGGER.warn("La respuesta de recuperar contraseña es nula.");
			}
		} catch (Exception e) {
			LOGGER.error("Error while calling SOAP service", e);
			throw new RuntimeException("SOAP call failed", e);
		}
		return null;
	}
	
	
	/**
	 * Metodo para desencriptar una cadena, se invoca el servicio SOAP
	 * https://portalb.allianz.com.mx/cipher/services/CipherWs
	 * 
	 * @param p Objeto con la cadena encriptada a desencriptar
	 * @return objeto con la cadena desencriptada
	 */
	private ObtenerComunicadoResponse invokeComunicadosService(ObtenerComunicadoRequest p, Jaxb2Marshaller marshaller) {
		template.setMarshaller(marshaller);
		template.setUnmarshaller(marshaller);
		JAXBElement<?> obj = (JAXBElement<?>) template.marshalSendAndReceive(servicesConfiguration.getServicioAvisos(),
				p);
		return (ObtenerComunicadoResponse) obj.getValue();
	}
	

}

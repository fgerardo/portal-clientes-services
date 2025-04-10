package mx.com.allianz.commons.owasp;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.allianz.exception.XSSException;
import mx.com.allianz.exception.ZeroException;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.commons.owasp
 * @Clase: UtilsOWASP.java <br/>
 *         Utilerias para tratar lineamientos de OWASP
 * @version 1.0.0
 */
public final class UtilsOWASP {

	/**
	 * Logger para la aplicacion y registro de informacion
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilsOWASP.class);
	/**
	 * Caracter para formato de correos
	 */
	private static final String ARROBA = "&#64;";

	// http://owasp-java-html-sanitizer.googlecode.com/svn/trunk/distrib/javadoc/org/owasp/html/HtmlPolicyBuilder.html
	// builder is not thread safe, so make local
	public static final PolicyFactory DISALLOW_ALL = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

	/**
	 * Constructor de la clase
	 */
	private UtilsOWASP() {
		super();
	}

	/**
	 * Limpia el valor de un posible ataque de XSS
	 * 
	 * @param value  valor a limpiar
	 * @param permit caracteres permitidos
	 * @return valor limpio
	 */
	public static String sanitize(String value, String... permit) {
		String valueSanitized = DISALLOW_ALL.sanitize(value).replaceFirst(ARROBA, "@");
		for (String charPermit : permit) {
			String charPermitSanitized = DISALLOW_ALL.sanitize(charPermit);
			valueSanitized = valueSanitized.replaceAll(charPermitSanitized, charPermit);
		}
		return valueSanitized;
	}

	/**
	 * Valida si una cadena está libre de XSS
	 * 
	 * @param value  valor a revisar
	 * @param permit caracteres permitidos
	 * @return true si es valido false en caso contrario
	 */
	public static boolean isValid(String value, String... permit) {
		if (value == null) {
			return true;
		}

		String arroba = DISALLOW_ALL.sanitize("@");
		value = value.replaceFirst("@", arroba);

		for (String charPermit : permit) {
			String charPermitSanitized = DISALLOW_ALL.sanitize(charPermit);
			value = value.replaceAll(charPermit, charPermitSanitized);
		}

		String sanitized = DISALLOW_ALL.sanitize(value);
		return sanitized.equals(value);
	}

	/**
	 * Valida el valor proporcionado y en caso de encontrar un error lanza una
	 * excepción
	 * 
	 * @param value valor para realizar validación
	 */
	public static void validateXSS(String value) {
		if (!isValid(value)) {
			throw new XSSException("El valor contiene caracteres html no permitidos. Origen[" + value + "]:: Sanitized["
					+ sanitize(value) + "]");
		}
	}

	/**
	 * Valida el server-side request forgery (ssrf)
	 * 
	 * @param uri url a validar
	 * @throws MalformedURLException en caso de que no sea una url la proporcionada
	 */
	public static URL validateSSRF(String uri) throws MalformedURLException {
		try {
			URL url = new URL(uri);
			if (!url.getProtocol().startsWith("http")) {
				LOGGER.debug("Protocolo no permitido, {}", url.getProtocol());
				throw new ZeroException("Protocolo no permitido, solo se permite http o https.");
			}

			InetAddress inetAddress = InetAddress.getByName(url.getHost());

			LOGGER.debug("isAnyLocalAddress: {}", inetAddress.isAnyLocalAddress());
			LOGGER.debug("isLoopbackAddress: {}", inetAddress.isLoopbackAddress());
			LOGGER.debug("isLinkLocalAddress: {}", inetAddress.isLinkLocalAddress());
			if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()
					|| inetAddress.isLinkLocalAddress()) {
				throw new ZeroException("URL local detectada, debe configurar el archivo host con un dominio valido.");
			}

			return url;
		} catch (UnknownHostException e) {
			throw new ZeroException("URL con host incorrecto detectada.");
		}
	}

	/**
	 * Obtiene una url valida
	 * 
	 * @param strURL url a validar
	 * @return url valida
	 * @throws MalformedURLException en caso de que no sea correcta la url
	 */
	public static String validURL(URL url) {
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		String query = url.getQuery();
		String uri;
		// if the port is not explicitly specified in the input, it will be -1.
		if (port == -1) {
			uri = String.format("%s://%s", protocol, host);
		} else {
			uri = String.format("%s://%s:%d", protocol, host, port);
		}
		if (query != null) {
			uri += "?" + query;
		}
		return uri;
	}
}

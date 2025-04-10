package mx.com.allianz.exception;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.allianz.commons.Codes;

/**
 * @Proyecto: incode-services
 * @Paquete: com.allianz.exception
 * @Clase: XSSException.java <br/>
 *         Excepcion de utilerías para manejo de validacion XSS
 * @version 1.0.0
 */
public class XSSException extends RuntimeException {

    /**
     * Logger de clase
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(XSSException.class);

    /**
     * Serializador
     */
    private static final long serialVersionUID = 7146463504543763427L;

    /**
     * Almacena los valores de los parametros para ser enviados al mensaje
     */
    private final String[] params;

    /**
     * Constructor de la clase
     * 
     * @param message
     *            mensaje del error
     * @param params
     *            parametros del mensaje
     */
    public XSSException(final String message, final String... params) {
        super(Codes.formatMsg(message, (Object[]) params));
        LOGGER.warn("Error registrado de programacion en utilerias - Detalle: {}",
                Codes.formatMsg(message, (Object[]) params));
        this.params = Arrays.copyOf(params, params.length);
    }

    /**
     * Constructor de la clase
     * 
     * @param e
     *            excepcion origen
     * @param message
     *            mensaje del error
     * @param params
     *            parametros del mensaje
     */
    public XSSException(Exception e, final String message, final String... params) {
        super(Codes.formatMsg(message, (Object[]) params));
        LOGGER.error("Error registrado en utilerias Isban-Commons - Detalle: {} - Exception: {}",
                Codes.formatMsg(message, (Object[]) params), e);
        this.params = Arrays.copyOf(params, params.length);
    }

    /**
     * Obtener valor.
     * 
     * @return El valor de params.
     */
    public String[] getParams() {
        return Arrays.copyOf(params, params.length);
    }

}

package mx.com.allianz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.ResponseCode;

/**
 * @Proyecto: incode-services
 * @Paquete: com.allianz.exception
 * @Clase: DataAccessException.java <br/>
 *         Excepcion de acceso a datos
 * @version 1.0.0
 */
public class DataAccessException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataAccessException.class);

    /**
     * Numero serial
     */
    private static final long serialVersionUID = -6654256023230766060L;

    /**
     * Excepcion original
     */
    private final Exception originalException;

    /**
     * Codigo de respuesta
     */
    private final ResponseCode responseCode;

    /**
     * Constructor de la clase
     * 
     * @param responseCode
     *            mensaje de la exepcion
     * @param params
     *            parametros para el mensaje
     */
    public DataAccessException(final ResponseCode responseCode, final Object... params) {
        super(Codes.formatMsg(responseCode.getMessage(), params));
        responseCode.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
        this.responseCode = responseCode;
        this.originalException = null;
        LOGGER.info("Procesando error de acceso a datos. Detalle {}", responseCode.getMessage());
    }

    /**
     * Constructor de la clase
     * 
     * @param message
     *            mensaje de la exepcion
     * @param params
     *            parametros para el mensaje
     */
    public DataAccessException(final String message, final Object... params) {
        super(Codes.formatMsg(message, params));
        this.responseCode = null;
        this.originalException = null;
        LOGGER.info("Procesando error de acceso a datos. Detalle {}", message);
    }

    /**
     * Constructor de la clase
     * 
     * @param e
     *            excepcion original
     * @param responseCode
     *            mensaje de la excepcion
     * @param params
     *            parametros para el mensaje
     */
    public DataAccessException(final Exception e, final ResponseCode responseCode, final Object... params) {
        super(Codes.formatMsg(responseCode.getMessage(), params));
        this.responseCode = responseCode;
        this.originalException = e;
        LOGGER.warn("Procesando error externo de acceso a datos. Detalle {}", e.getMessage());
        LOGGER.error("Error de acceso a datos. Detalle {}", e);
    }

    /**
     * Constructor de la clase
     * 
     * @param e
     *            excepcion original
     * @param message
     *            mensaje de la excepcion
     * @param params
     *            parametros para el mensaje
     */
    public DataAccessException(final Exception e, final String message, final Object... params) {
        super(Codes.formatMsg(message, params));
        this.responseCode = null;
        this.originalException = e;
        LOGGER.warn("Procesando error externo de acceso a datos. Detalle {}", e.getMessage());
        LOGGER.error("Error de acceso a datos. Detalle {}", e);
    }

    /**
     * Obtener valor.
     * 
     * @return El valor de originalException.
     */
    public Exception getOriginalException() {
        return originalException;
    }

    /**
     * @return the responseCode
     */
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}

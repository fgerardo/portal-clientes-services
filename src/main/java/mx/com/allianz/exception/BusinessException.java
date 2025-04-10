package mx.com.allianz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.ResponseCode;

/**
 * @Proyecto: incode-services
 * @Paquete: com.allianz.exception
 * @Clase: BusinessException.java <br/>
 *         Excepcion de negocio generada en validaciones
 * @version 1.0.0
 */
public class BusinessException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

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
    public BusinessException(final ResponseCode responseCode, final Object... params) {
        super(Codes.formatMsg(responseCode.getMessage(), params));
        responseCode.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
        this.responseCode = responseCode;
        this.originalException = null;
        LOGGER.info("Procesando error de negocio. Detalle {}.", responseCode.getMessage());
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
    public BusinessException(final Exception e, final ResponseCode responseCode, final Object... params) {
        super(Codes.formatMsg(responseCode.getMessage(), params));
        this.responseCode = responseCode;
        this.originalException = e;
        LOGGER.error("Procesando error.", e);
        LOGGER.error("Procesando error externo. Detalle {}.", e.getMessage());
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

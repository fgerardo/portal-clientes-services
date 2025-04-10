package mx.com.allianz.commons;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @Proyecto: incode-services
 * @Paquete: mx.com.allianz.commons
 * @Clase: CodesProperties.java <br/>
 *         Clase encargada del procesamiento de insumos de archivos de
 *         propiedades
 * @version 1.0.0
 */
public class CodesProperties {

    /**
     * Logger para definir mensajes en la aplicacion
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CodesProperties.class);

    /**
     * Mensaje para codigo no encontrado
     */
    protected static final String MESSAGE_CODE_NOT_FOUND = "C\u00f3digo no encontrado. Code not found. {} Error: {} {}";

    /**
     * Mensaje para formato numerico invalido
     */
    protected static final String MESSAGE_CODE_NUMBER_FORMAT = "El mensaje no tiene formato num\u00e9rico, Code: {}, Error: {} {}";

    /**
     * Mensaje para formato json invalido
     */
    protected static final String MESSAGE_CODE_JSON_FORMAT = "El mensaje no tiene formato json v\u00e1lido, Code: {}, Error: {} {}";

    @Autowired
    protected Properties messageSource;

    /**
     * Obtiene todas las llaves y mensajes
     * 
     * @return mapa de mensajes
     */
    public Map<String, String> getMessages() {
        final Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getKeyValues("messages/messages", locale);
    }

    /**
     * Metodo que obtiene un mensaje
     * 
     * @param code
     *            codigo de mensaje
     * @return mensaje en texto
     */
    public String getMessage(final String code) {
        try {
            final Locale locale = LocaleContextHolder.getLocale();
            LOGGER.debug("Locale en el ContextHolder {}", locale.getLanguage());
            return messageSource.getMessage(code, null, locale);
        } catch (final NoSuchMessageException e) {
            LOGGER.warn(MESSAGE_CODE_NOT_FOUND, code, e.getMessage(), e);
            return "C\u00f3digo no encontrado. Code not found. " + code;
        }
    }

    /**
     * Metodo que obtiene un mensaje
     * 
     * @param code
     *            codigo del mensaje en el archivo properties
     * @return regresa el numero entero correspondiente al codigo
     */
    public int getIntMessage(final String code) {
        try {
            final Locale locale = LocaleContextHolder.getLocale();
            final String message = messageSource.getMessage(code, null, locale);
            return Integer.parseInt(message);
        } catch (final NoSuchMessageException e) {
            LOGGER.warn(MESSAGE_CODE_NOT_FOUND, code, e.getMessage(), e);
            return 0;
        } catch (NumberFormatException e) {
            LOGGER.warn(MESSAGE_CODE_NUMBER_FORMAT, code, e.getMessage(), e);
            return 0;
        }
    }

    /**
     * Metodo que obtiene un mensaje
     * 
     * @param code
     *            codigo del mensaje en el archivo properties
     * @return regresa el numero long correspondiente al codigo
     */
    public long getLongMessage(final String code) {
        try {
            final Locale locale = LocaleContextHolder.getLocale();
            final String message = messageSource.getMessage(code, null, locale);
            return Long.parseLong(message);
        } catch (final NoSuchMessageException e) {
            LOGGER.warn(MESSAGE_CODE_NOT_FOUND, code, e.getMessage(), e);
            return 0L;
        } catch (final NumberFormatException e) {
            LOGGER.warn(MESSAGE_CODE_NUMBER_FORMAT, code, e.getMessage(), e);
            return 0;
        }
    }

    /**
     * Metodo que obtiene un mensaje
     * 
     * @param code
     *            codigo del mensaje en el archivo properties
     * @return regresa el numero long correspondiente al codigo
     */
    public boolean getBooleanMessage(final String code) {
        try {
            final Locale locale = LocaleContextHolder.getLocale();
            final String message = messageSource.getMessage(code, null, locale);
            return Boolean.parseBoolean(message);
        } catch (final NoSuchMessageException e) {
            LOGGER.warn(MESSAGE_CODE_NOT_FOUND, code, e.getMessage(), e);
            return false;
        }
    }
}

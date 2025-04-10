package mx.com.allianz.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;

import mx.com.allianz.commons.model.ResponseCode;
import mx.com.allianz.commons.model.SerializerResponseCode;
import mx.com.allianz.util.ZeroJsonXml;

/**
 * @Proyecto: incode-services
 * @Paquete: mx.com.allianz.commons
 * @Clase: Codes.java <br/>
 *         Clase que se encarga del manejo de codigos de respuesta
 * @version 1.0.0
 */
public class Codes extends CodesProperties {
    /**
     * Logger para definir mensajes en la aplicacion
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Codes.class);

    /**
     * Codigo generico de no econtrado
     */
    private String codNotFound = "EGBL000";

    /**
     * Constructor de la clase
     * 
     */
    public Codes() {
        super();
    }

    /**
     * Metodo que dado un codigo obtiene un objeto json en properties y lo convierte
     * a ResponseCode
     * 
     * @param code
     *            codigo del mensaje
     * @param params
     *            parametros para el mensaje del ResponseCode
     * @return objeto de Responsecode
     */
    public ResponseCode getResponseCode(final String code, final Object... params) {
        LOGGER.info("Codes --> getResponseCode --> {}", code);

        return getResponseCodeProperties(code, params);
    }

    /**
     * Metodo que dado un codigo obtiene un objeto json en properties y lo convierte
     * a ResponseCode
     * 
     * @param code
     *            codigo del mensaje
     * @param params
     *            parametros para el mensaje del ResponseCode
     * @return objeto de Responsecode
     */
    private ResponseCode getResponseCodeProperties(final String code, final Object... params) {
        LOGGER.info("Codes --> getResponseCodeProperties --> {}", code);

        try {
            final Locale locale = LocaleContextHolder.getLocale();
            String message = messageSource.getMessage(code, null, locale).trim();
            // no contiene serialización y su longitud es valida
            if (message.indexOf("ResponseCode") < 0 && message.length() > 2) {
                int inicio = message.indexOf('{');
                String objetoInicio = message.substring(0, inicio + 1);
                String objetoFin = message.substring(inicio + 1, message.length());
                message = objetoInicio + " \"type\" : \"" + SerializerResponseCode.class.getName() + "\", " + objetoFin;
            }
            SerializerResponseCode responseCode = new SerializerResponseCode();
            responseCode = ZeroJsonXml.toObject(responseCode, message);

            ResponseCode response = new ResponseCode();
            if (responseCode.getDescription().contains("{}")) {
            	response.setDescription(Codes.formatMsg(responseCode.getDescription(), params));
            } else {
            	response.setDescription(Codes.formatMsg(responseCode.getDescription()));
            }
            response.setLevel(responseCode.getLevel());
            response.setMoreInfo(responseCode.getMoreInfo());
            response.setCode(code);
            if (responseCode.getMessage().contains("{}")) {
            	response.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
            } else {
            	response.setMessage(Codes.formatMsg(responseCode.getMessage()));
            }
            return response;
        } catch (final NoSuchMessageException e) {
            LOGGER.warn(MESSAGE_CODE_NOT_FOUND, code, e.getMessage(), e);
            return new ResponseCode(codNotFound, "No se ha podido recuperar el mensaje del archivo de propiedades.",
                    "WARN", "", "");
        } catch (IOException e) {
            LOGGER.warn(MESSAGE_CODE_JSON_FORMAT, code, e.getMessage(), e);
            return new ResponseCode(codNotFound,
                    "No se ha podido recuperar el mensaje del archivo de propiedades, formato json no valido.", "WARN",
                    "", "");
        }

    }

    /**
     * Metodo que convierte un FieldError a ResponseCode, de acuerdo a los
     * estandares de manejo de errores
     * 
     * @param fieldErrors
     *            lista de validaciones con Spring Validation
     * @param code
     *            codigo del mensaje usado para dar formato al mensaje de
     *            requeridos, puede recibir los parametros: codigo de error
     *            validator default message campo human readable
     * 
     * @return lista de codigos de repuesta
     */
    public List<ResponseCode> getValidations(List<FieldError> fieldErrors) {
        LOGGER.info("Codes --> getValidations(List<FieldError> fieldErrors, final String code)");
        List<ResponseCode> listResponse = new ArrayList<>();
        for (FieldError field : fieldErrors) {
            String campo = "";
            if (field.getField() != null && field.getField().length() > 1) {
                campo = toHumanReadable(field.getField());
            }
            String defaultMessage = field.getDefaultMessage();
            LOGGER.info("VALIDATIONS --> field.getDefaultMessage() --> {}", defaultMessage);
            String codeTemplate = "{campo}";
            String code = null;
            List<Object> params = new ArrayList<>();
            if (defaultMessage.startsWith("[") && defaultMessage.endsWith("]")) {
                // contiene parametros el mensaje
                String codigo = defaultMessage.substring(1, defaultMessage.length() - 1).replace(codeTemplate, campo);
                LOGGER.debug("Codigo procesado --> {}", codigo);
                String[] codigoParams = codigo.split(Pattern.quote("|"));

                LOGGER.debug("codigoParams --> {}", Arrays.toString(codigoParams));

                // obteniendo codigo
                if (codigoParams.length > 0) {
                    code = codigoParams[0];
                    LOGGER.debug("Code obtenido de split --> {}", code);
                } else {
                    code = codigo;
                    LOGGER.debug("Code obtenido de codigo --> {}", code);
                }

                // obteniendo parametros
                for (int i = 1; i < codigoParams.length; i++) {
                    params.add(codigoParams[i]);
                }

                listResponse.add(getResponseCode(code, params.toArray()));

            } else {
                code = defaultMessage;
                LOGGER.debug("Code obtenido de defaultMessage --> {}", code);
                listResponse.add(new ResponseCode(field.getCode(), code.replace(codeTemplate, campo), "WARN",
                        code.replace(codeTemplate, campo), null));
            }

        }
        return listResponse;
    }

    /**
     * 
     * Metodo que da formato a una cadena dada
     * 
     * @param message
     *            mensaje al cual se le dara formato, los parametros deben ir
     *            anotados como {}
     * @param params
     *            parametros para el mensaje
     * @return mensaje formateado
     */
    public static String formatMsg(final String message, final Object... params) {
        String mensaje = message;
        if (message != null) {
            for (final Object param : params) {
                mensaje = mensaje.replaceFirst("\\{\\}", "" + param);
            }
        }
        return mensaje;
    }

    /**
     * Metodo para realizar un human readable de una propiedad de un codigo
     * 
     * @param s
     *            string a convertir
     * @return cadena human readable
     */
    public static String toHumanReadable(String s) {
        String aplitString = s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
        return aplitString.substring(0, 1).toUpperCase() + aplitString.substring(1);
    }

}

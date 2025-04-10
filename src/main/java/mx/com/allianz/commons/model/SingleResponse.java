package mx.com.allianz.commons.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.ApiModelProperty;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.exception.BusinessException;

/**
 * @Proyecto: incode-services
 * @Paquete: mx.com.allianz.commons.model
 * @Clase: SingleResponse.java
 * @param <R>
 *            Tipo de la respuesta<br>
 *            Modelo de respuesta general
 * 
 * @version 1.0.0
 */
public class SingleResponse<R> implements Serializable {
	/**
	 * Numero de srializacion
	 */
	private static final long serialVersionUID = -8083211585525204680L;

	/**
	 * Logger para definir mensajes en la aplicacion
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SingleResponse.class);

	/**
	 * Codigo de respuesta emitido
	 */
	@ApiModelProperty(value = "C\u00f3digo de respuesta emitido, puede ser de \u00e9xito, error o validaciones", required = true)
	private ResponseCode responseCode;

	/**
	 * Objeto de la respuesta
	 */
	@ApiModelProperty(value = "Objeto de la respuesta", required = true)
	private transient R response;
	/**
	 * Determina la respuesta es correcta(true) o contiene errores o
	 * validaciones(false)
	 */
	@ApiModelProperty(value = "Determina la respuesta es correcta o no", notes = "En caso de \u00e9xito : true, En caso de errores: false, En caso de validaciones: false", required = true)
	private boolean ok = false;
	/**
	 * Lista de validaciones en la respuesta
	 */
	@ApiModelProperty(value = "Lista de validaciones de negocio.")
	private List<ResponseCode> validationsCodes;

	/**
	 * Constructor de la clase
	 */
	public SingleResponse() {
		super();
	}

	/**
	 * Metodo que ingresa a la respuesta la lista de validaciones, este metodo
	 * determinara que la respuesta no es correcta y que deben revisarse los
	 * elementos
	 * 
	 * @param validationsCodes
	 *            lista de validaciones
	 */
	public void validations(final List<ResponseCode> validationsCodes) {
		this.validationsCodes = new ArrayList<>(validationsCodes);
		this.response = null;
		this.ok = false;
	}

	/**
	 * Metodo que determina que la respuesta es exitosa y su mensaje, puede estar
	 * con formato {} para usar los parametros en la cadena
	 * 
	 * @param response
	 *            Objeto de respuesta, es obligatorio almenos un true o string
	 * @param responseCode
	 *            mensaje de exito de la respuesta. Ej. "Operacion realizada
	 *            exitosamente."
	 * @param params
	 *            parametros para el mensaje.
	 */
	public void done(final R response, final ResponseCode responseCode, final Object... params) {
		this.response = response;
		this.ok = true;
		responseCode.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
		this.responseCode = responseCode;
	}

	/**
	 * Metodo que determina que la respuesta es incorrecta. El mensaje se determina
	 * en el metodo getMessage() de Exception o su implementacion
	 * 
	 * @param responseCode
	 *            codigo de respuesta de la operacion
	 * @param exception
	 *            excepcion que provoco el error
	 * @param params
	 *            parametros a colocar en el mensaje de error
	 */
	public void error(final R response, final ResponseCode responseCode, final Exception exception, final Object... params) {
		this.ok = false;
		this.response = response;
		if (exception instanceof BusinessException) {
			LOGGER.warn("Error de negocio--> Detalle {} ", exception.getMessage());
		} else {
			LOGGER.error("Error no controlado--> Detalle {} -- Error {} ", exception.getMessage(), exception);
		}
		if (responseCode == null) {
			LOGGER.error("Debe proporcionar un responseCode a la Excepcion de Negocio");
		} else {
			responseCode.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
		}
		this.responseCode = responseCode;
	}

	/**
	 * Metodo que determina que la respuesta es incorrecta. El mensaje se determina
	 * en el metodo getMessage() de Exception o su implementacion
	 * 
	 * @param responseCode
	 *            codigo de respuesta de la operacion
	 * @param params
	 *            parametros a colocar en el mensaje de error
	 */
	public void error(final ResponseCode responseCode, final Object... params) {
		this.ok = false;
		this.response = null;
		responseCode.setMessage(Codes.formatMsg(responseCode.getMessage(), params));
		this.responseCode = responseCode;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de response.
	 */
	public R getResponse() {
		return response;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de isOk.
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * Obtener valor.
	 * 
	 * @return El valor de validations.
	 */
	public List<ResponseCode> getValidations() {
		if (validationsCodes == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(validationsCodes);
	}

	/**
	 * @return the responseCode
	 */
	public ResponseCode getResponseCode() {
		return responseCode;
	}

}

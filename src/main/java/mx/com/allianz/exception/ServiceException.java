package mx.com.allianz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author iborja
 * @version 1.0.0
 * Descripcion: Clase que ejecutara excepciones en la capa de servicios
 */
public class ServiceException extends Exception{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de la excepción
	 */
	private final String message;

	/**
	 * Excepción generada
	 */
	private final Exception error;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceException.class);

	/**
	 * Constuctor encargado de generar una excepción, en donde la capa de servicios indica el error generado e imprime
	 * en el log el error
	 * @param exceptionMessage - Error generado en la capa de servicios
	 */
	public ServiceException(String exceptionMessage){
		message = exceptionMessage;
		//Logger.error(exceptionMessage);
		error = null;
	}
	/**
	 * Constuctor encargado de generar una excepción, en donde la capa de servicios indica el error generado e imprime
	 * en el log el error
	 * @param exceptionMessage Error generado en la capa de negocio
	 */
	public ServiceException(String exceptionMessage, String customLoggerMessage) {
		message = exceptionMessage;
		LOGGER.error(exceptionMessage);
		if(!customLoggerMessage.isEmpty()){
			LOGGER.error("CUSTOM LOG ERROR:" + customLoggerMessage);
		}
		error = null;
	}

	/**
	 * Constuctor encargado de generar una excepción, en donde la capa de servicios indica el error generado
	 * y la excepción not checked e imprime en el log la excepción
	 * @param exceptionMessage - Mensaje de la excepción generada proporcionado por la capa de servicios
	 * @param exception - Excepción generada
	 */
	public ServiceException(String exceptionMessage, Exception exception){
		message = exceptionMessage;
		error = exception;
		//Logger.error(exceptionMessage, exception);
	}

	/**
	 * Se obtiene el error proporcionado por la capa de servicios
	 * @return message - Mensaje que proporciona la capa de servicios
	 */
	public String getMensaje() {
		return message;
	}

	/**
	 * Se obtiene la excepción que se genero
	 * @return error - Excepción generada en la ejecución
	 */
	public Exception getOrigenError() {
		return error;
	}


}

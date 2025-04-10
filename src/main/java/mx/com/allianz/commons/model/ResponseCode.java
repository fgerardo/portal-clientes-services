package mx.com.allianz.commons.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.commons.model
 * @Clase: ResponseCode.java <br/>
 *         Clase que mapea un codigo de respuesta completo
 * @version 1.0.0
 */
public class ResponseCode implements Serializable {
	/**
	 * Identificador de serializacion
	 */
	private static final long serialVersionUID = -6482142863347903326L;
	/**
	 * Codigo de respuesta unico
	 */
	@ApiModelProperty(value = "C\u00f3digo de respuesta \u00fanico. CODIGO_MENSAJE.NNN", allowableValues = "SSSS.NNN", required = true)
	private String code;
	/**
	 * Mensaje de respuesta descrito
	 */
	@ApiModelProperty(value = "Mensaje de respuesta descrito.", required = true)
	private String message;
	/**
	 * Nivel de error
	 */
	@ApiModelProperty(value = "Nivel de error", allowableValues = "ERROR, INFO, WARN", required = true)
	private String level;
	/**
	 * Descripcion detallada del error
	 */
	@ApiModelProperty(value = "Descripci\u00f3n detallada del error.", required = true)
	private String description;
	/**
	 * Url en donde se ubica la informacion del error
	 */
	@ApiModelProperty(value = "Url en donde se ubica la informaci\u00f3n del error.", required = true)
	private String moreInfo;

	/**
	 * Constructor de la clase
	 */
	public ResponseCode() {
		super();
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param code
	 *            codigo de respuesta
	 * @param message
	 *            mensaje de respuesta
	 * @param level
	 *            nivel de respuesta
	 * @param description
	 *            descripcion de la respuesta
	 * @param moreInfo
	 *            url donde puede encontrar ayuda sobre la respuesta
	 */
	public ResponseCode(String code, String message, String level, String description, String moreInfo) {
		super();
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * @param moreInfo
	 *            the moreInfo to set
	 */
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

}

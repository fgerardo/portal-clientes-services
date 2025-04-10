package mx.com.allianz.commons.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.commons.model
 * @Clase: SerializerResponseCode.java <br/>
 *         Clase que mapea un codigo de respuesta completo
 * @version 1.0.0
 */
@JsonTypeInfo(use = Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class SerializerResponseCode implements Serializable {
    /**
     * Identificador de serializacion
     */
    private static final long serialVersionUID = -6482142863347903326L;
    /**
     * Codigo de respuesta unico
     */
    private String code;
    /**
     * Mensaje de respuesta descrito
     */
    private String message;
    /**
     * Nivel de error
     */
    private String level;
    /**
     * Descripcion detallada del error
     */
    private String description;
    /**
     * Url en donde se ubica la informacion del error
     */
    private String moreInfo;

    /**
     * Constructor de la clase
     */
    public SerializerResponseCode() {
        super();
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

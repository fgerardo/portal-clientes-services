package mx.com.allianz.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.util
 * @Clase: ZeroJsonXml.java <br/>
 *         Clase que se encarga de utilerías relacionadas con JSON y XML
 * @version 1.0.0
 */
public final class ZeroJsonXml {

	/**
	 * Formatter estandar
	 */
	private static final String FORMAT_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	/**
	 * Constructor de la clase
	 */
	private ZeroJsonXml() {
		super();
	}

	/**
	 * Convierte un xml a un objeto json
	 * 
	 * @param xml
	 *            xml de entrada
	 * @return json equivalente al xml
	 * @throws IOException
	 *             Error en caso de que no se pueda convertir
	 */
	public static String xmlToJson(String xml) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode node = xmlMapper.readTree(xml.getBytes("UTF-8"));
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.writeValueAsString(node);
	}

	/**
	 * Convierte una cadena json a Objeto
	 * 
	 * @param <T>
	 *            tipo del objeto
	 * @param obj
	 *            objeto en donde se colocara el json
	 * @param jsonInString
	 *            cadena json
	 * @throws IOException
	 *             excepcion posible
	 * @return regresa el objeto lleno
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(final T obj, final String jsonInString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATE);
		mapper.setDateFormat(format);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// JSON from String to Object
		return (T) mapper.readValue(jsonInString, obj.getClass());
	}

	/**
	 * Convierte una cadena json a Objeto
	 * 
	 * @param <T>
	 *            tipo del objeto
	 * @param obj
	 *            Tipo de referencia del objeto en donde se colocara el json
	 * @param jsonInString
	 *            cadena json
	 * @throws IOException
	 *             excepcion posible
	 * @return regresa el objeto lleno
	 */
	public static <T> T toObject(final TypeReference<T> obj, final String jsonInString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATE);
		mapper.setDateFormat(format);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// JSON from String to Object
		return mapper.readValue(jsonInString, obj);
	}

	/**
	 * Convierte un objeto a json
	 * 
	 * @param obj
	 *            objeto de java
	 * @return cadena json
	 * @throws IOException
	 *             en caso de no poder convertirse el objeto
	 */
	public static <T> String toJson(final T obj) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat(FORMAT_DATE));
		// Object to JSON in String
		return mapper.writeValueAsString(obj);
	}

	/**
	 * Convierte un objeto a xml
	 * 
	 * @param obj
	 *            objeto de java
	 * @return cadena xml
	 * @throws JsonProcessingException
	 *             en caso de no soportar el xml
	 * @throws IOException
	 *             en caso de no poder convertirse el objeto
	 */
	public static <T> String toXml(final T obj) throws JsonProcessingException {
		final XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDateFormat(new SimpleDateFormat(FORMAT_DATE));
		return xmlMapper.writeValueAsString(obj);
	}

	/**
	 * Convierte un xml a objeto
	 * 
	 * @param xml
	 *            xml
	 * @param obj
	 *            object
	 * @return objeto objeto
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws JsonProcessingException
	 * @throws IOException
	 *             en caso de no poder convertirse el objeto
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToObject(final T obj, final String xml) throws IOException {
		final XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDateFormat(new SimpleDateFormat(FORMAT_DATE));
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return (T) xmlMapper.readValue(xml, obj.getClass());
	}
}
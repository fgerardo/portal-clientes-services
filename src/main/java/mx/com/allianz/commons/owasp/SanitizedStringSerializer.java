package mx.com.allianz.commons.owasp;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.commons.owasp
 * @Clase: SanitizedStringSerializer.java <br/>
 *         Serializador de jackson para limpiar respuestas de XSS
 * @version 1.0.0
 */
public class SanitizedStringSerializer extends JsonSerializer<String> {

	private String[] permit;

	/**
	 * Serializador para XSS
	 */
	public SanitizedStringSerializer() {
		super();
		this.permit = new String[] { "@", "+", "=", "&", "'" };
	}

	/**
	 * Constructor
	 * @param permit caracteres que permite
	 */
	public SanitizedStringSerializer(String... permit) {
		super();
		this.permit = permit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(
	 * Object, com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		String sanitize = UtilsOWASP.sanitize(value, this.permit);
		jgen.writeRawValue("\"" + sanitize + "\"");
	}

}

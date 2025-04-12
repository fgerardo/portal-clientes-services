package mx.com.allianz.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseGenerica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4320912553678893352L;
	private boolean exitoso;
	private Map<String, String> errores;
	private ContenidoModel contenido;

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}

	public ContenidoModel getContenido() {
		return contenido;
	}

	public void setContenido(ContenidoModel contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "ResponseGenerica [exitoso=" + exitoso + ", errores=" + errores + ", contenido=" + contenido + "]";
	}

}

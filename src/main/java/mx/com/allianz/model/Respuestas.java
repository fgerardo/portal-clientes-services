package mx.com.allianz.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Respuestas", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "datosRespuesta" })
public class Respuestas {

	@XmlElement(name = "datosRespuesta", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private DatosRespuestaModel datosRespuesta;

	public DatosRespuestaModel getDatosRespuesta() {
		return datosRespuesta;
	}

	public void setDatosRespuesta(DatosRespuestaModel datosRespuesta) {
		this.datosRespuesta = datosRespuesta;
	}

	@Override
	public String toString() {
		return "Respuestas [datosRespuesta=" + datosRespuesta + "]";
	}

}

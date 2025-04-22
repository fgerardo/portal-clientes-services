package mx.com.allianz.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
@XmlRootElement(name = "datosRespuesta", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
public class DatosRespuestaModel implements Serializable {
	private static final long serialVersionUID = -4725259499078633011L;
	@XmlElement(name = "fecnac", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String fecnac;
	@XmlElement(name = "nomter", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String nomter;
	@XmlElement(name = "telef1", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String telef1;
	@XmlElement(name = "codcli", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String codcli;
	@XmlElement(name = "apematter", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String apematter;
	@XmlElement(name = "direccion", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String direccion;
	@XmlElement(name = "tipoclie", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String tipoclie;
	@XmlElement(name = "apeter", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String apeter;
	@XmlElement(name = "sexo", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String sexo;
	@XmlElement(name = "email", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String email;
	@XmlElement(name = "rfc", namespace = "mx.com.allianz/call_autos_devolver_inf_contr")
	private String rfc;

	public String getFecnac() {
		return fecnac;
	}

	public void setFecnac(String fecnac) {
		this.fecnac = fecnac;
	}

	public String getNomter() {
		return nomter;
	}

	public void setNomter(String nomter) {
		this.nomter = nomter;
	}

	public String getTelef1() {
		return telef1;
	}

	public void setTelef1(String telef1) {
		this.telef1 = telef1;
	}

	public String getCodcli() {
		return codcli;
	}

	public void setCodcli(String codcli) {
		this.codcli = codcli;
	}

	public String getApematter() {
		return apematter;
	}

	public void setApematter(String apematter) {
		this.apematter = apematter;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoclie() {
		return tipoclie;
	}

	public void setTipoclie(String tipoclie) {
		this.tipoclie = tipoclie;
	}

	public String getApeter() {
		return apeter;
	}

	public void setApeter(String apeter) {
		this.apeter = apeter;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "DatosRespuestaModel [fecnac=" + fecnac + ", nomter=" + nomter + ", telef1=" + telef1 + ", codcli="
				+ codcli + ", apematter=" + apematter + ", direccion=" + direccion + ", tipoclie=" + tipoclie
				+ ", apeter=" + apeter + ", sexo=" + sexo + ", email=" + email + ", rfc=" + rfc + "]";
	}

}

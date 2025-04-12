package mx.com.allianz.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contratante implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = -5805917788529547989L;
    @JsonProperty("IdCliente")
	public String idCliente;
	@JsonProperty("CodCliIntegrador")
	public String codCliIntegrador;
	@JsonProperty("TipoPersona")
	public String tipoPersona;
	@JsonProperty("SexoPersona")
	public String sexoPersona;
	@JsonProperty("RFC")
	public String rFC;
	@JsonProperty("NombreCompleto")
	public String nombreCompleto;
	@JsonProperty("Nombre")
	public String nombre;
	@JsonProperty("ApellidoPaterno")
	public String apellidoPaterno;
	@JsonProperty("ApellidoMaterno")
	public String apellidoMaterno;
	@JsonProperty("FechaAntiguedad")
	public String fechaAntiguedad;
	@JsonProperty("FechaNacimiento")
	public String fechaNacimiento;
	@JsonProperty("Email")
	public String email;
	@JsonProperty("TelParticular")
	public String telParticular;
	@JsonProperty("TelCelular")
	public String telCelular;
	@JsonProperty("DomicilioCompleto")
	public String domicilioCompleto;
	@JsonProperty("Calle")
	public String calle;
	@JsonProperty("NumExterior")
	public String numExterior;
	@JsonProperty("NumInterior")
	public String numInterior;
	@JsonProperty("Colonia")
	public String colonia;
	@JsonProperty("Municipio")
	public String municipio;
	@JsonProperty("Estado")
	public String estado;
	@JsonProperty("CodigoPostal")
	public String codigoPostal;
	@JsonProperty("Pais")
	public String pais;
	@JsonProperty("FechaUltimaActualizacion")
	public String fechaUltimaActualizacion;
	@JsonProperty("NumCert")
	public String numCert;
	@JsonProperty("UsApp")
	public String usApp;
	@JsonProperty("IdClientePoliza")
	public String idClientePoliza;
	@JsonProperty("EsContratante")
	public String esContratante;
	@JsonProperty("IDESCONTRATANTEPOLIZA")
	public String iDESCONTRATANTEPOLIZA;
	public String _id;
	@JsonProperty("Contratante")
	public Contratante contratante;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodCliIntegrador() {
		return codCliIntegrador;
	}

	public void setCodCliIntegrador(String codCliIntegrador) {
		this.codCliIntegrador = codCliIntegrador;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getSexoPersona() {
		return sexoPersona;
	}

	public void setSexoPersona(String sexoPersona) {
		this.sexoPersona = sexoPersona;
	}

	public String getrFC() {
		return rFC;
	}

	public void setrFC(String rFC) {
		this.rFC = rFC;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFechaAntiguedad() {
		return fechaAntiguedad;
	}

	public void setFechaAntiguedad(String fechaAntiguedad) {
		this.fechaAntiguedad = fechaAntiguedad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelParticular() {
		return telParticular;
	}

	public void setTelParticular(String telParticular) {
		this.telParticular = telParticular;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}

	public void setDomicilioCompleto(String domicilioCompleto) {
		this.domicilioCompleto = domicilioCompleto;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNumCert() {
		return numCert;
	}

	public void setNumCert(String numCert) {
		this.numCert = numCert;
	}

	public String getUsApp() {
		return usApp;
	}

	public void setUsApp(String usApp) {
		this.usApp = usApp;
	}

	public String getIdClientePoliza() {
		return idClientePoliza;
	}

	public void setIdClientePoliza(String idClientePoliza) {
		this.idClientePoliza = idClientePoliza;
	}

	public String getEsContratante() {
		return esContratante;
	}

	public void setEsContratante(String esContratante) {
		this.esContratante = esContratante;
	}

	public String getiDESCONTRATANTEPOLIZA() {
		return iDESCONTRATANTEPOLIZA;
	}

	public void setiDESCONTRATANTEPOLIZA(String iDESCONTRATANTEPOLIZA) {
		this.iDESCONTRATANTEPOLIZA = iDESCONTRATANTEPOLIZA;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	@Override
	public String toString() {
		return "Contratante [idCliente=" + idCliente + ", codCliIntegrador=" + codCliIntegrador + ", tipoPersona="
				+ tipoPersona + ", sexoPersona=" + sexoPersona + ", rFC=" + rFC + ", nombreCompleto=" + nombreCompleto
				+ ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", fechaAntiguedad=" + fechaAntiguedad + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email
				+ ", telParticular=" + telParticular + ", telCelular=" + telCelular + ", domicilioCompleto="
				+ domicilioCompleto + ", calle=" + calle + ", numExterior=" + numExterior + ", numInterior="
				+ numInterior + ", colonia=" + colonia + ", municipio=" + municipio + ", estado=" + estado
				+ ", codigoPostal=" + codigoPostal + ", pais=" + pais + ", fechaUltimaActualizacion="
				+ fechaUltimaActualizacion + ", numCert=" + numCert + ", usApp=" + usApp + ", idClientePoliza="
				+ idClientePoliza + ", esContratante=" + esContratante + ", iDESCONTRATANTEPOLIZA="
				+ iDESCONTRATANTEPOLIZA + ", _id=" + _id + ", contratante=" + contratante + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;

public class GeneralesModel implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 5224930797377894957L;
	private String nombreCliente;
	private String clienteDesde;
	private String idCliente;
	private String email;
	private String fotoCliente;
	private String FechaUltimaActualizacion;
	private String tipoPersona;
	private String rfc;
	private String folletoProducto;
	private String numeroPoliza;
	private String estatus;
	private String tipoPoliza;
	private String fechaInicioVigencia;
	private String fechaEmision;
	private String sumaAsegurada;
	private String saldo;
	private String etiqueta;
	private String formaPago;
	private String familiaPoliza;
	private String codMoneda;
	private String fechaTerminoVigencia;
	private String caratulaPoliza;
	private String IDEPOL;
	private boolean esContratante;
	private GeneralesEmpresarialModel generalesEmpresarial;

	public boolean isEsContratante() {
		return esContratante;
	}

	public void setEsContratante(boolean esContratante) {
		this.esContratante = esContratante;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(String clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFotoCliente() {
		return fotoCliente;
	}

	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

	public String getFechaUltimaActualizacion() {
		return FechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		FechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getFolletoProducto() {
		return folletoProducto;
	}

	public void setFolletoProducto(String folletoProducto) {
		this.folletoProducto = folletoProducto;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoPoliza() {
		return tipoPoliza;
	}

	public void setTipoPoliza(String tipoPoliza) {
		this.tipoPoliza = tipoPoliza;
	}

	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getFamiliaPoliza() {
		return familiaPoliza;
	}

	public void setFamiliaPoliza(String familiaPoliza) {
		this.familiaPoliza = familiaPoliza;
	}

	public String getCodMoneda() {
		return codMoneda;
	}

	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}

	public String getFechaTerminoVigencia() {
		return fechaTerminoVigencia;
	}

	public void setFechaTerminoVigencia(String fechaTerminoVigencia) {
		this.fechaTerminoVigencia = fechaTerminoVigencia;
	}

	public String getCaratulaPoliza() {
		return caratulaPoliza;
	}

	public void setCaratulaPoliza(String caratulaPoliza) {
		this.caratulaPoliza = caratulaPoliza;
	}

	public String getIDEPOL() {
		return IDEPOL;
	}

	public void setIDEPOL(String iDEPOL) {
		IDEPOL = iDEPOL;
	}

	public GeneralesEmpresarialModel getGeneralesEmpresarial() {
		return generalesEmpresarial;
	}

	public void setGeneralesEmpresarial(GeneralesEmpresarialModel generalesEmpresarial) {
		this.generalesEmpresarial = generalesEmpresarial;
	}

	@Override
	public String toString() {
		return "GeneralesModel [nombreCliente=" + nombreCliente + ", clienteDesde=" + clienteDesde + ", idCliente="
				+ idCliente + ", email=" + email + ", fotoCliente=" + fotoCliente + ", FechaUltimaActualizacion="
				+ FechaUltimaActualizacion + ", tipoPersona=" + tipoPersona + ", rfc=" + rfc + ", folletoProducto="
				+ folletoProducto + ", numeroPoliza=" + numeroPoliza + ", estatus=" + estatus + ", tipoPoliza="
				+ tipoPoliza + ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaEmision=" + fechaEmision
				+ ", sumaAsegurada=" + sumaAsegurada + ", saldo=" + saldo + ", etiqueta=" + etiqueta + ", formaPago="
				+ formaPago + ", familiaPoliza=" + familiaPoliza + ", codMoneda=" + codMoneda
				+ ", fechaTerminoVigencia=" + fechaTerminoVigencia + ", caratulaPoliza=" + caratulaPoliza + ", IDEPOL="
				+ IDEPOL + ", esContratante=" + esContratante + ", generalesEmpresarial=" + generalesEmpresarial + "]";
	}

}

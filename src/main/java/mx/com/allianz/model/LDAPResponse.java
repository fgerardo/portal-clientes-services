package mx.com.allianz.model;

import java.io.Serializable;

public class LDAPResponse implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 8391082128131832103L;

	private String uid;
	private String email;
	private String cn;
	private String sn;
	private String userpassword;
	private String givenname;
	private String companyName;
	private String tipoAut;
	private String cveAgente;
	private String cveAgente6Pos;
	private String cveEmpleado;
	private String cveCliente;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getGivenname() {
		return givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTipoAut() {
		return tipoAut;
	}

	public void setTipoAut(String tipoAut) {
		this.tipoAut = tipoAut;
	}

	public String getCveAgente() {
		return cveAgente;
	}

	public void setCveAgente(String cveAgente) {
		this.cveAgente = cveAgente;
	}

	public String getCveAgente6Pos() {
		return cveAgente6Pos;
	}

	public void setCveAgente6Pos(String cveAgente6Pos) {
		this.cveAgente6Pos = cveAgente6Pos;
	}

	public String getCveEmpleado() {
		return cveEmpleado;
	}

	public void setCveEmpleado(String cveEmpleado) {
		this.cveEmpleado = cveEmpleado;
	}

	public String getCveCliente() {
		return cveCliente;
	}

	public void setCveCliente(String cveCliente) {
		this.cveCliente = cveCliente;
	}

	@Override
	public String toString() {
		return "LDAPResponse [uid=" + uid + ", email=" + email + ", cn=" + cn + ", sn=" + sn + ", userpassword="
				+ userpassword + ", givenname=" + givenname + ", companyName=" + companyName + ", tipoAut=" + tipoAut
				+ ", cveAgente=" + cveAgente + ", cveAgente6Pos=" + cveAgente6Pos + ", cveEmpleado=" + cveEmpleado
				+ ", cveCliente=" + cveCliente + "]";
	}

}

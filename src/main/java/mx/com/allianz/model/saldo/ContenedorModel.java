package mx.com.allianz.model.saldo;

import java.io.Serializable;

public class ContenedorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2997764898689672243L;
	private String producto;
	private String codMoneda;
	private String emisor;
	private String familia;
	private String saldo;

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCodMoneda() {
		return codMoneda;
	}

	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContenedorModel [producto=" + producto + ", codMoneda=" + codMoneda + ", emisor=" + emisor
				+ ", familia=" + familia + ", saldo=" + saldo + "]";
	}

}

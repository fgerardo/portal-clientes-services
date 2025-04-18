package mx.com.allianz.model;

import java.io.Serializable;

public class Vigencias implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4831310023294359894L;

	private String fechaHasta;
	private String fechaDesde;
	private String producto;
	private String familia;

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "Vigencias [fechaHasta=" + fechaHasta + ", fechaDesde=" + fechaDesde + ", producto=" + producto
				+ ", familia=" + familia + "]";
	}

}

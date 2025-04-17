package mx.com.allianz.model;

import java.io.Serializable;

public class Pago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 204110677018137399L;

	private String producto;
	private String importeAPagar;
	private String fechaVencimiento;

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getImporteAPagar() {
		return importeAPagar;
	}

	public void setImporteAPagar(String importeAPagar) {
		this.importeAPagar = importeAPagar;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return "Pago [producto=" + producto + ", importeAPagar=" + importeAPagar + ", fechaVencimiento="
				+ fechaVencimiento + "]";
	}

}

package mx.com.allianz.model;

public class Producto {

	private FamiliaProducto familiaProducto;
	private String idProducto;
	private String descripcion;

	public Producto(FamiliaProducto familiaProducto, String idProducto, String descripcion) {
		super();
		this.familiaProducto = familiaProducto;
		this.idProducto = idProducto;
		this.descripcion = descripcion;
	}

	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	public void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

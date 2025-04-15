package mx.com.allianz.model;

public class FamiliaProducto {

	private String idFamilia;
	private String descripcionFamilia;
	private String colorHexadecimal;

	public FamiliaProducto() {
	}

	public FamiliaProducto(String idFamilia, String descripcionFamilia, String colorHexadecimal) {
		super();
		this.idFamilia = idFamilia;
		this.descripcionFamilia = descripcionFamilia;
		this.colorHexadecimal = colorHexadecimal;
	}

	public String getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getDescripcionFamilia() {
		return descripcionFamilia;
	}

	public void setDescripcionFamilia(String descripcionFamilia) {
		this.descripcionFamilia = descripcionFamilia;
	}

	public String getColorHexadecimal() {
		return colorHexadecimal;
	}

	public void setColorHexadecimal(String colorHexadecimal) {
		this.colorHexadecimal = colorHexadecimal;
	}
}

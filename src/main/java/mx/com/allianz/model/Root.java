package mx.com.allianz.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 6271966405896411464L;
	public ArrayList<Row> rows;
	public Meta _meta;

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	public Meta get_meta() {
		return _meta;
	}

	public void set_meta(Meta _meta) {
		this._meta = _meta;
	}

	@Override
	public String toString() {
		return "Root [rows=" + rows + ", _meta=" + _meta + "]";
	}

}

package mx.com.allianz.model;

import java.io.Serializable;

public class Meta implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 2491136444850926022L;
	int page;
	public int max_results;
	public int total;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMax_results() {
		return max_results;
	}

	public void setMax_results(int max_results) {
		this.max_results = max_results;
	}

	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Meta [page=" + page + ", max_results=" + max_results + ", total=" + total + "]";
	}

	public void setTotal(int total) {
		this.total = total;
	}

}

package mx.com.allianz.model;

import java.io.Serializable;
import java.util.List;

public class ResumenSaldos implements Serializable {

	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 4000885419412940656L;

	private List<SumaSaldo> resumenAhorro;
	private List<SumaSaldo> resumenSalud;
	private String resumenAutos;

	public List<SumaSaldo> getResumenAhorro() {
		return resumenAhorro;
	}

	public void setResumenAhorro(List<SumaSaldo> resumenAhorro) {
		this.resumenAhorro = resumenAhorro;
	}

	public List<SumaSaldo> getResumenSalud() {
		return resumenSalud;
	}

	public void setResumenSalud(List<SumaSaldo> resumenSalud) {
		this.resumenSalud = resumenSalud;
	}

	public String getResumenAutos() {
		return resumenAutos;
	}

	public void setResumenAutos(String resumenAutos) {
		this.resumenAutos = resumenAutos;
	}

	@Override
	public String toString() {
		return "ResumenSaldos [resumenAhorro=" + resumenAhorro + ", resumenSalud=" + resumenSalud + ", resumenAutos="
				+ resumenAutos + "]";
	}

}

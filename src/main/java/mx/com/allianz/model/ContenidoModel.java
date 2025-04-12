package mx.com.allianz.model;

import java.io.Serializable;

public class ContenidoModel implements Serializable {
	/**
	 * Serializador
	 */
	private static final long serialVersionUID = 6461195645977782297L;
	private TipoCliente tipoCliente;

	public static class TipoCliente implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7120154070070680981L;
		private String codCli;
		private String codCliIntegrador;
		private String esContratante;

		public String getCodCli() {
			return codCli;
		}

		public void setCodCli(String codCli) {
			this.codCli = codCli;
		}

		public String getCodCliIntegrador() {
			return codCliIntegrador;
		}

		public void setCodCliIntegrador(String codCliIntegrador) {
			this.codCliIntegrador = codCliIntegrador;
		}

		public String getEsContratante() {
			return esContratante;
		}

		public void setEsContratante(String esContratante) {
			this.esContratante = esContratante;
		}

		@Override
		public String toString() {
			return "TipoCliente [codCli=" + codCli + ", codCliIntegrador=" + codCliIntegrador + ", esContratante="
					+ esContratante + "]";
		}
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "ContenidoModel [tipoCliente=" + tipoCliente + "]";
	}
}
package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "roles")
public class RolesConfiguration {

	private String clienteTipo;
	private String agenteTipo;
	private String empleadoTipo;

	public String getClienteTipo() {
		return clienteTipo;
	}

	public void setClienteTipo(String clienteTipo) {
		this.clienteTipo = clienteTipo;
	}

	public String getAgenteTipo() {
		return agenteTipo;
	}

	public void setAgenteTipo(String agenteTipo) {
		this.agenteTipo = agenteTipo;
	}

	public String getEmpleadoTipo() {
		return empleadoTipo;
	}

	public void setEmpleadoTipo(String empleadoTipo) {
		this.empleadoTipo = empleadoTipo;
	}

}

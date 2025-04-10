package mx.com.allianz;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PortalClientesServices {

	public static void main(String[] args) {
		SpringApplication.run(PortalClientesServices.class, args);
	}

	/**
	 * Bean que se ocupa para el consumo de servicios rest
	 * 
	 * @return RestTemplate como instancia para inyeccion
	 */
	@Bean
	public RestTemplate restTemplate() {
		ObjectMapper objectMapper = new ObjectMapper();
		// Configuración adicional de ObjectMapper si es necesario.
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
		return new RestTemplate(Collections.singletonList(converter));
	}
}

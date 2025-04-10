package mx.com.allianz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.config
 * @Clase: CorsConfig.java <br/>
 *          Clase que establece los metodos http permitidos.
 * @version 1.0.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOriginPatterns("*") // Permite cualquier origen con credenciales
        .allowCredentials(true)
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}

}

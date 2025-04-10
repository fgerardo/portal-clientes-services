package mx.com.allianz.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.Properties;
import mx.com.allianz.commons.owasp.SanitizedStringSerializer;

/**
 * @Proyecto: bitacora-service
 * @Paquete: com.bitacora.config
 * @Clase: AppConfiguration.java <br/>
 *         Clase de la configuracion del microservicio para cargar dependencias
 *         y configuraciones necesarias
 * @version 1.0.0
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {
    /**
     * Logger de la aplicacion
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    /**
     * Bean que se encarga del manejo de mensajes, extension de
     * ResourceBundleMessageSource
     * 
     * @return Clase personanilizada para el manejor de archivos properties
     */
    @Bean
    public Properties messageSource() {
        LOGGER.info("Creando bean de mensajes properties");
        Properties source = new Properties();
        source.setDefaultEncoding("UTF-8");
        // name of the resource bundle
        source.setBasenames("i18n/validation-messages", "i18n/codes");
        return source;
    }

    /**
     * Bean encargado de administrador los codigos a traves de archivos properties,
     * se extiende la funcionalidad para lectura de mensajes
     * 
     * @return instancia de clase para ser usada en lectura de codigos
     */
    @Bean
    public Codes codes() {
        LOGGER.info("Creando bean de Codes.");
        return new Codes();
    }

    /**
     * Validator para peticiones post y manejar la internacionalizacion
     * 
     * @param messageSource
     *            codigos de mensaje de donde obtendra los mensajes
     * @return LocalValidatorFactoryBean con los mensajes configurados
     */
    @Bean
    public LocalValidatorFactoryBean validator(Properties messageSource) {
        LOGGER.info("Registrando validator para peticiones post.");
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);

        return factory;
    }
    

/*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
     * configureMessageConverters(java.util.List)
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // the list is empty, so we just add our converter
        converters.add(jsonConverter());
    }

    /**
     * Sanitiza el contenido del response
     * 
     * @return mensaje limpio de XSS
     */
    @Bean
    public HttpMessageConverter<Object> jsonConverter() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .serializerByType(String.class, new SanitizedStringSerializer()).build();
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}

package mx.com.allianz.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapConfig {

	@Bean
	@Qualifier("login")
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("mx.com.allianz.login.service");
		return marshaller;
	}

	@Bean
	@Qualifier("recuperaContrasena")
	public Jaxb2Marshaller marshallerRecuperaContrasena() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("mx.com.allianz.recupera.password.service");
		return marshaller;
	}

	@Bean
	@Qualifier("cipher")
	public Jaxb2Marshaller marshallerCipher() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("mx.com.allianz.cipher.service");
		return marshaller;
	}
	
	@Bean
	@Qualifier("centralComunicados")
	public Jaxb2Marshaller marshallerComunicados() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("mx.com.allianz.central.comunicados.service");
		return marshaller;
	}

	
	@Bean
    public WebServiceTemplate webServiceTemplate(@Qualifier("cipher") Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        return template;
    }
}

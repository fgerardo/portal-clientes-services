//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.07 a las 04:26:25 PM CST 
//


package mx.com.allianz.login.service;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.com.allianz.login.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.com.allianz.login.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginService }
     * 
     */
    public LoginService createLoginService() {
        return new LoginService();
    }

    /**
     * Create an instance of {@link LoginServiceResponse }
     * 
     */
    public LoginServiceResponse createLoginServiceResponse() {
        return new LoginServiceResponse();
    }

    /**
     * Create an instance of {@link LoginResponseDto }
     * 
     */
    public LoginResponseDto createLoginResponseDto() {
        return new LoginResponseDto();
    }

    /**
     * Create an instance of {@link CookieDto }
     * 
     */
    public CookieDto createCookieDto() {
        return new CookieDto();
    }

}

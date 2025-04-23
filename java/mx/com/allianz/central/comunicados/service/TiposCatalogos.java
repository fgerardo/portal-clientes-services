//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.04.23 a las 01:25:46 PM CST 
//


package mx.com.allianz.central.comunicados.service;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TiposCatalogos.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>
 * &lt;simpleType name="TiposCatalogos"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACTIVOS"/&gt;
 *     &lt;enumeration value="CANALES"/&gt;
 *     &lt;enumeration value="TIPOS_AUDIENCIAS"/&gt;
 *     &lt;enumeration value="COLUMNAS_CONTACTOS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TiposCatalogos")
@XmlEnum
public enum TiposCatalogos {

    ACTIVOS,
    CANALES,
    TIPOS_AUDIENCIAS,
    COLUMNAS_CONTACTOS;

    public String value() {
        return name();
    }

    public static TiposCatalogos fromValue(String v) {
        return valueOf(v);
    }

}

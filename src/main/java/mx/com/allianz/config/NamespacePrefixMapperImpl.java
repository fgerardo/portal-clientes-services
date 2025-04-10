package mx.com.allianz.config;

import org.eclipse.persistence.internal.oxm.NamespacePrefixMapper;

public class NamespacePrefixMapperImpl extends NamespacePrefixMapper {
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if ("http://services.admincontrasenas.web.habil.com".equals(namespaceUri)) {
            return "ns";  // Prefijo del namespace
        }
        return null;  // Deja los otros namespaces sin cambio
    }
}

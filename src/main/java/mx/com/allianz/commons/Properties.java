package mx.com.allianz.commons;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @Proyecto: incode-services
 * @Paquete: mx.com.allianz.commons
 * @Clase: Properties.java <br/>
 *         Clase que carga y manipula los archivos .properties
 * @version 1.0.0
 */
public class Properties extends ResourceBundleMessageSource {
	/**
	 * cache para almacenar los datos previamente cargados
	 */
	private Map<String, Map<String, String>> cachedData = new HashMap<>();

	/**
	 * Obtiene las llaves de los archivos properties
	 * 
	 * @param basename
	 *            nombre del archivo properties
	 * @param locale
	 *            idioma en el que lo obtendra
	 * @return Lista de llaves
	 */
	public Set<String> getKeys(final String basename, final Locale locale) {
		ResourceBundle bundle = getResourceBundle(basename, locale);
		return bundle.keySet();
	}

	/**
	 * Obtiene las llaves y valores de un archivo properties
	 * 
	 * @param basename
	 *            nombre del archivo
	 * @param locale
	 *            idioma del archivo
	 * @return mapa de llave valor
	 */
	public Map<String, String> getKeyValues(final String basename, final Locale locale) {
		String cacheKey = basename + locale.getLanguage() + locale.getCountry();
		if (cachedData.containsKey(cacheKey)) {
			return cachedData.get(cacheKey);
		}
		ResourceBundle bundle = getResourceBundle(basename, locale);
		Map<String, String> treeMap = new TreeMap<>();

		for (String key : bundle.keySet()) {
			treeMap.put(key, getMessage(key, null, locale));
		}
		cachedData.put(cacheKey, (TreeMap<String, String>) treeMap);
		return treeMap;
	}
}
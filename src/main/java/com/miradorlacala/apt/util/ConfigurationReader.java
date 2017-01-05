package com.miradorlacala.apt.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ConfiguracionInformesReader.
 */
public class ConfigurationReader {

	/**
	 * Método que devuelve un mapa de valores, con un prefijo igual, de un
	 * fichero de propiedades.
	 * <dl>
	 * Ej:
	 * <dt>Fichero Propiedades:</dt>
	 * <dd>informes.usuario=alcampo</dd>
	 * <dd>informes.password=alcampoPwd1!</dd>
	 * <dd>informes.url=remote://smart.integracion.alcampo.es:4447</dd>
	 * <dd>informes.nombreInforme.maxLineas=20000</dd>
	 * <dd>informes.nombreInforme.titulo=PROVEEDORES</dd>
	 * <dd>informes.nombreInforme.columnas=PROVEEDOR=PROVEEDOR</dd>
	 * </dl>
	 * Si ponemos de patrón "^(informes.nombreInforme.*)" y clave a remover
	 * "informes.nombreInforme", tendremos el siguiente mapa: <dd>
	 * [maxLineas=20000]; [titulo=PROVEEDORES]; [columnas=PROVEEDOR=PROVEEDOR]</dd>
	 * 
	 * @param props Fichero de propiedades que contienen la configuración de los
	 *            informes planificados.
	 * @param idPatternString Parte de las propiedades común formateado para ser
	 *            utilizado en al tarea de seleccionar que propiedades deben
	 *            incluirse en el mapa.
	 * @param removeKeyValue Parte de las propiedades común, usado para eliminar
	 *            la parte común de las propiedades seleccionadas.
	 * @return El mapa de propiedades que contengan el patrón indicado
	 */
	public static Map<String, String> propsToMap(Properties props,
			String idPatternString, String removeKeyValue) {

		Map<String, String> map = new HashMap<String, String>();

		Pattern idPattern = Pattern.compile(idPatternString);

		for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
			String key = (String) en.nextElement();
			String keyValue = (String) props.getProperty(key);

			if (keyValue != null) {
				Matcher idMatcher = idPattern.matcher(key);
				if (idMatcher.matches()) {
					map.put(key.replace(removeKeyValue, ""), keyValue);
				}
			}
		}

		return map;
	}

	/**
	 * Props to map by id.
	 * 
	 * @param props the props
	 * @param idPatternString the id pattern string
	 * @param removeKeyValue the remove key value
	 * @return the map
	 */
	public static Map<String, Map<String, String>> propsToMapById(
			Properties props, String idPatternString, String removeKeyValue) {

		Map<String, Map<String, String>> idMap = new HashMap<String, Map<String, String>>();

		Pattern idPattern = Pattern.compile(idPatternString);

		for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
			String key = (String) en.nextElement();
			String keyValue = (String) props.getProperty(key);

			if (keyValue != null) {
				Matcher idMatcher = idPattern.matcher(key);
				if (idMatcher.matches()) {
					String property = key.replace(removeKeyValue, "");

					if (property.contains(".")) {
						String id = property
								.substring(0, property.indexOf("."));
						String field = property
								.substring(property.indexOf(".") + 1);
						Map<String, String> fieldMap = null;
						if (idMap.containsKey(id)) {
							fieldMap = idMap.get(id);
						} else {
							fieldMap = new HashMap<String, String>();
							idMap.put(id, fieldMap);
						}
						fieldMap.put(field, keyValue);
					}
				}
			}
		}

		return idMap;
	}
}
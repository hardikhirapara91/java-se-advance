package com.hardik.jdbc.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Property Util
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class PropertyUtil {

	private static Properties prop = null;

	public PropertyUtil() {
		if (prop == null) {
			try {
				prop = new Properties();
				prop.load(PropertyUtil.class.getClassLoader().getResourceAsStream("db.properties"));
				System.out.println("Property file loaded successfully.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Get Property
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		new PropertyUtil();

		if (prop != null) {
			return prop.getProperty(key);
		}

		return null;
	}
}

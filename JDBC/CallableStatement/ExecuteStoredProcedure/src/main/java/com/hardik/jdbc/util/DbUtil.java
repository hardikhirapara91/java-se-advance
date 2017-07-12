package com.hardik.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB Util
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DbUtil {

	private static Connection connection = null;

	/**
	 * Get Connection
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(
						PropertyUtil.getProperty("URL") + PropertyUtil.getProperty("DB_NAME"),
						PropertyUtil.getProperty("USERNAME"), PropertyUtil.getProperty("PASSWORD"));
				System.out.println("DB Connection Created Successfully...");
			} catch (SQLException ex) {
				System.out.println("ERROR: DB Connection: " + ex);
			}
		}

		return connection;
	}

}

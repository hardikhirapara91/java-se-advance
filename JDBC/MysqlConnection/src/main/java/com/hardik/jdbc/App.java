package com.hardik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Application Main Class
 *
 */
public class App {

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_Name = "employee";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "admin";

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL + DB_Name, USERNAME, PASSWORD);

			if (connection != null) {
				System.out.println("Connection created successfully: " + connection);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception: " + ex);
		} catch (SQLException ex) {
			System.out.println("Exception: " + ex);
		}
	}
}

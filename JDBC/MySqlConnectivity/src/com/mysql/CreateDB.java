package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * CreateDB Class
 * 
 * Create Database Using PrepareStatemente Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class CreateDB {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement psts = null;
		String query = "CREATE DATABASE emp1";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306", "root", "admin");
			System.out.println("Connection created successfully.");
			psts = (PreparedStatement) connection.prepareStatement(query);

			int result = psts.executeUpdate();
			if (result > 0) {
				System.out.println("Database created successfully.");
			} else {
				System.out.println("Database not created.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection is closed.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

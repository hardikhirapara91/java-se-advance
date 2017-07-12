package com.hardik.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hardik.jdbc.util.DbUtil;

/**
 * Application Main Class
 *
 */
public class App {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Connection connection = DbUtil.getConnection();

		if (connection != null) {
			try {
				String sql = "SELECT * FROM `emp`";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					System.out.println("ID: " + resultSet.getInt("id"));
					System.out.println("Name: " + resultSet.getString("name"));
					System.out.println("Salary: " + resultSet.getInt("salary"));
					System.out.println("Department: " + resultSet.getString("dept"));
				}

				connection.close();
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
			}
		}
	}
}

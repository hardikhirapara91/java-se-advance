package com.hardik.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				String sql = "INSERT INTO `emp`(`name`,`salary`,`dept`) VALUES(?,?,?)";
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, "Hardik Hirapara");
				statement.setInt(2, 568956);
				statement.setString(3, "Computer");
				statement.executeUpdate();

				// Get Generated Keys
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet != null && resultSet.next()) {
					System.out.println("Last Inserted ID: " + resultSet.getInt(1));
				}

				connection.close();
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
			}
		}
	}
}

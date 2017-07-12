package com.hardik.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				String sql = "UPDATE `emp` SET `name`=? WHERE `id`=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, "XXX");
				statement.setInt(2, 1);

				int result = statement.executeUpdate();
				if (result == 1) {
					System.out.println("Record Updated Successfully.");
				} else {
					System.out.println("Record is not updated.");
				}

				connection.close();
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
			}
		}
	}
}

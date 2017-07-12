package com.hardik.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
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
				CallableStatement statement = connection.prepareCall("{call myprocedure(?,?)}");
				statement.setString(1, "Hardik Hirapara");
				statement.setInt(2, 568956);
				statement.execute();
				System.out.println("Executed stored procedure!!!");
			} catch (SQLException ex) {
				System.out.println("SQL Exception: " + ex);
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println("ERROR: Exception: " + ex);
					}
				}
			}
		}
	}
}

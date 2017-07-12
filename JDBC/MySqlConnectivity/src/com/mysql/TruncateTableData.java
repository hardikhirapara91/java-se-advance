package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruncateTableData {

	public static void main(String[] args) {
		String query = "TRUNCATE TABLE `user`";
		Connection connection = null;
		PreparedStatement psts = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			psts = connection.prepareStatement(query);
			psts.executeUpdate();
			System.out.println("Table Truncated Successfully.");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

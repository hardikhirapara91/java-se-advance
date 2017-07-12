package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * DeleteData Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DeleteData {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psts = null;
		String query = "DELETE FROM `user` WHERE `id`=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			psts = (PreparedStatement) connection.prepareStatement(query);
			psts.setInt(1, 1);
			psts.executeUpdate();
			System.out.println("Record deleted successfully.");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

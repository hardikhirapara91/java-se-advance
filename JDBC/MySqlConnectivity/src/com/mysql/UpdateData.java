package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * UpdateData Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class UpdateData {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psts = null;
		String query = "UPDATE `user` SET `uname`=? WHERE id=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			psts = (PreparedStatement) connection.prepareStatement(query);
			psts.setString(1, "Hirapara");
			psts.setInt(2, 1);
			psts.executeUpdate();
			System.out.println("Record updated successfully.");
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

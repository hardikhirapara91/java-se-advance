package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * InsertData Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class InsertData {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement psts = null;
		String query = "INSERT INTO `user`(`uname`) VALUES (?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			psts = (PreparedStatement) connection.prepareStatement(query);
			psts.setString(1, "Hardik");

			int result = psts.executeUpdate();
			if (result > 0) {
				System.out.println("Record added successfully.");
			} else {
				System.out.println("Record is not added.");
			}
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

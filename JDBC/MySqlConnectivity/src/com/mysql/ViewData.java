package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * View Data Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class ViewData {
	public static void main(String[] args) throws SQLException {

		String query = "SELECT * FROM `user`";
		Connection connectionn = null;
		PreparedStatement psts = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			psts = connectionn.prepareStatement(query);
			ResultSet result = psts.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("uname");

				System.out.println(id + " : " + name);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			connectionn.close();
		}
	}
}

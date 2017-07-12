package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * Create Table Class
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class CreateTable {

	private static Connection connection = null;
	private static PreparedStatement psts = null;

	public static void main(String[] args) throws SQLException {

		String query = "CREATE TABLE IF NOT EXISTS `user` ("
				+ "`id` int(10) NOT NULL AUTO_INCREMENT,"
				+ "`uname` varchar(255) NOT NULL," + "PRIMARY KEY (`id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp1", "root", "admin");
			System.out.println("Connection created successfully.");
			psts = (PreparedStatement) connection.prepareStatement(query);
			psts.execute();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			connection.close();
		}

	}
}

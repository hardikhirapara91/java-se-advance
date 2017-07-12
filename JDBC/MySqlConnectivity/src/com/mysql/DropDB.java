package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DropDB {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "silent");
			st = (Statement) con.createStatement();
			st.execute("DROP DATABASE emp1");
			st.close();
			con.close();
		} catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
		}
	}
}

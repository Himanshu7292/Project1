package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	private static Connection connection;

	private MysqlConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/online_shopping_data";
		String username = "root";
		String password = "123456";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}

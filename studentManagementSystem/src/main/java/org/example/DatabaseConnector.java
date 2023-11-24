package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	/**
	 *
	 *
	 * @name: DatabaseConnector
	 * @author: IhaveBB
	 * @date: 2023-11-24 21:32
	 **/

	private static final String URL = "jdbc:mysql://localhost:3306/students";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}

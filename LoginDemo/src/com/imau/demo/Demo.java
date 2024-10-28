package com.imau.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		
		// 1
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2
		String url = "jdbc:mysql://localhost:3306/userdb";
		String user = "root";
		String password = "1";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3
//		Statement stmt = conn.createStatement();
//		String sql = "select id, code, name, grade from student";
		
		//4
//		ResultSet rs = stmt.executeQuery(sql);
		
		//5.
//		while(rs.next()) {
//			String name = rs.getString("name");
//			int grade = rs.getInt("grade");
//			System.out.println(name + grade);
//		}

		//3
		String sql = "select * from student";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
	}
	
}

package com.nicebao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
/** @description: 连接数据库
		* @param:
		* @return:
		* @author: IhaveBB
		* @date: 2023/11/25
		*/

	private static final String URL = "jdbc:mysql://mysql.sqlpub.com:3306/student1125";
	private static final String USERNAME = "awfdgesw";
	private static final String PASSWORD = "aa6e90fa392cf0d9";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	public static void createTable() throws SQLException {
		Connection connection =  getConnection();
		String query =	"CREATE TABLE IF NOT EXISTS students ( studentId BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL, gender VARCHAR(10) NOT NULL, birthdate DATE, address VARCHAR(100), phoneNumber VARCHAR(15));";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeUpdate();
	}
}

/** @description: 数据库名称	student1125
数据库用户	awfdgesw
数据库密码	aa6e90fa392cf0d9
数据库地址	mysql.sqlpub.com:3306
注册邮箱	ihavebb@outlook.com
注意	密码只显示一次，请注意保存。
为保障数据库运行安全，密码严禁泄漏到公共环境！！！（如：csdn、zhihu、github等）发现即永久锁定。
 * @param:
 * @return:
 * @author: IhaveBB
 * @date: 2023/11/25
 */
package com.nicebao.util;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 处理数据库连接的工具类
 * @author: IhaveBB
 * @date: 2024/11/6
 **/
public class Conn implements AutoCloseable {

	private static final Logger logger = LoggerFactory.getLogger(Conn.class);

	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/petclinic?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "123456";

	public Connection cn = null;
	public PreparedStatement pr = null;
	public ResultSet rs = null;

	public Connection getCn() {
		return cn;
	}

	public Conn() {
		try {
			Class.forName(JDBC_DRIVER);
			cn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			logger.error("数据库连接失败", e);
		}
	}

	public Connection getConnection() {
		return cn;
	}

	@Override
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pr != null) {
				pr.close();
			}
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			logger.error("关闭数据库资源失败", e);
		}
	}
}

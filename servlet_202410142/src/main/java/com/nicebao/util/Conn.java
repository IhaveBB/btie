package com.nicebao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/6
**/
public class Conn {

    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/petclinic?useSSL=false&serverTimezone=UTC";
    final String USER = "root";
    final String PASS = "123456";

    public Connection cn = null;
    public PreparedStatement pr = null;
    public ResultSet rs = null;

    public Conn() {

        try {
            Class.forName(JDBC_DRIVER);
            cn = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void close(){
        try {
            if (cn!=null) {
				cn.close();
			}
            if (pr!=null) {
				pr.close();
			}
            if (rs!=null) {
				rs.close();
			}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

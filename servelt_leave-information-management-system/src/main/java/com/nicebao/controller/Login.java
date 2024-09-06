package com.nicebao.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//表示该类处理 /login 请求：http://localhost:8080/helloword/login,即响应login.html中的表单请求
@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		System.out.println("接收到的用户名：" + userName + ", 密码为：" + password);
	}

}

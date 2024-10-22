package com.nicebao.controller;

import com.nicebao.Service.UserService;
import com.nicebao.model.LoginResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @name: LoginServlet
 * @author: IhaveBB
 * @date: 2024-10-19 22:14
 **/
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.isEmpty()) {
			ip = request.getRemoteAddr();
		}
		LoginResult result = userService.login(username, password, ip);
		System.out.println(ip);

		if (result.isSuccess()) {
			HttpSession session = request.getSession();
			session.setAttribute("user", result.getUser());
			response.sendRedirect("welcome.jsp");

		} else {
			request.setAttribute("errorMessage", result.getErrorMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}	
	}
}

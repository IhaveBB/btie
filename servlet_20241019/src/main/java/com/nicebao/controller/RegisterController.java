package com.nicebao.controller;

import com.nicebao.Service.UserService;
import com.nicebao.model.RegistrationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name: RegisterServlet
 * @author: IhaveBB
 * @date: 2024-10-19 22:14
 **/
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		RegistrationResult result = userService.register(username, password);

		if (result.isSuccess()) {
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("errorMessage", result.getErrorMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}

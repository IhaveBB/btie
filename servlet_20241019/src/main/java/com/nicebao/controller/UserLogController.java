package com.nicebao.controller;

import com.nicebao.Service.UserService;
import com.nicebao.model.LoginLog;
import com.nicebao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @name: UserLogController
 * @author: IhaveBB
 * @date: 2024-10-20 21:10
 **/
@WebServlet("/logs")
public class UserLogController extends HttpServlet {
	private UserService userService;

	@Override
	public void init() {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				List<LoginLog> logs = userService.getLoginLogs(user.getId());
				request.setAttribute("logs", logs);
				request.getRequestDispatcher("userLogs.jsp").forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}

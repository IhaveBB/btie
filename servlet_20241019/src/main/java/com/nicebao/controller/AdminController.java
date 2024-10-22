package com.nicebao.controller;

import com.nicebao.Service.UserService;
import com.nicebao.model.LoginLog;
import com.nicebao.model.OperationLog;
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
 * @name: AdminController
 * @author: IhaveBB
 * @date: 2024-10-21 15:12
 **/
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private UserService userService;

	@Override
	public void init()   {
		userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user != null && user.isAdmin()) {
			List<LoginLog> allLogs = userService.getAllLoginLogs();
			List<OperationLog> allOperationLogs = userService.getAllOperationLogs();
			request.setAttribute("allLogs", allLogs);
			request.setAttribute("allOperationLogs", allOperationLogs);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
package com.nicebao.servlet;

import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class LoginLogServlet extends HttpServlet {

	private EmpDAO empDAO;

	public LoginLogServlet(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public LoginLogServlet() {
		this.empDAO = new EmpDAO(new Conn());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("name");

		List<String> loginLogs = empDAO.getLoginLogs(username);

		request.setAttribute("loginLogs", loginLogs);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginLogs.jsp");
		dispatcher.forward(request, response);
	}
}

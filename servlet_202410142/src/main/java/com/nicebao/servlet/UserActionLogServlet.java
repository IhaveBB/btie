package com.nicebao.servlet;

import com.nicebao.Dao.EmpDAO;

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
public class UserActionLogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("name");

		EmpDAO empDAO = new EmpDAO();
		List<String> actionLogs = empDAO.getUserActionLogs(username);

		request.setAttribute("actionLogs", actionLogs);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/userActionLogs.jsp");
		dispatcher.forward(request, response);
	}
}

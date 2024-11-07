package com.nicebao.servlet;

import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class UserActionLogServlet extends HttpServlet {

	private EmpDAO empDAO;


	public UserActionLogServlet(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}


	public UserActionLogServlet() {
		this.empDAO = new EmpDAO(new Conn());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("name");

		// 调用EmpDAO获取用户操作日志
		List<String> actionLogs = empDAO.getUserActionLogs(username);

		request.setAttribute("actionLogs", actionLogs);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/userActionLogs.jsp");
		dispatcher.forward(request, response);
	}
}

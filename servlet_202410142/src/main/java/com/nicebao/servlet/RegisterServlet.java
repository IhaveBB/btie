package com.nicebao.servlet;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;
import com.nicebao.util.FBK;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/7
**/
public class RegisterServlet extends HttpServlet {

	private EmpDAO empDAO;
	private FBK fbk;

	public RegisterServlet(EmpDAO empDAO, FBK fbk) {
		this.empDAO = empDAO;
		this.fbk = fbk;
	}

	public RegisterServlet() {
		this.empDAO = new EmpDAO(new Conn());
		this.fbk = new FBK();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Employee ep = new Employee();
		ep.setName(req.getParameter("username"));
		ep.setPassword(req.getParameter("password"));

		String confirmPassword = req.getParameter("confirmPassword");

		if (!ep.getPassword().equals(confirmPassword)) {
			fbk.setFeedBack("密码和确认密码不一致，请重新输入！", req);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}

		boolean success = empDAO.register(ep);

		if (success) {
			fbk.setFeedBack("注册成功！请登录", req);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			fbk.setFeedBack("用户名已存在，请选择其他用户名", req);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}

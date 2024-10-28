package com.nicebao.service;

import com.nicebao.mapper.UserMapper;
import com.nicebao.model.User;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// 简单的输入验证
		if (userName == null || userName.trim().isEmpty() ||
				password == null || password.trim().isEmpty()) {

			request.setAttribute("errorMessage", "请输入用户名和密码。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.selectUserByName(userName);

			if (user != null && user.getPassword().equals(password)) {
				// 设置会话属性
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setMaxInactiveInterval(30 * 60); // 会话超时时间30分钟

				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("errorMessage", "用户名或密码错误。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "登录过程中出现错误，请稍后再试。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}

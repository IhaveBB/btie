package com.nicebao.service;

import com.nicebao.mapper.UserMapper;
import com.nicebao.model.User;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// 简单的输入验证
		if (userName == null || userName.trim().isEmpty() ||
				password == null || password.trim().isEmpty() ||
				!password.equals(confirmPassword)) {

			request.setAttribute("errorMessage", "请输入有效的用户名和密码，且两次密码必须一致。");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User existingUser = userMapper.selectUserByName(userName);

			if (existingUser != null) {
				request.setAttribute("errorMessage", "用户已存在，请使用其他用户名。");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password); // 直接存储密码（明文）

				userMapper.register(user);
				sqlSession.commit();

				request.setAttribute("successMessage", "注册成功，请登录。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "注册过程中出现错误，请稍后再试。");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
}

package com.nicebao.service;

import com.nicebao.mapper.UserMapper;
import com.nicebao.model.User;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User existingUser = userMapper.selectUserByName(userName);

			if (existingUser != null) {
				request.setAttribute("errorMessage", "用户已存在，请使用其他用户名");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);

				userMapper.register(user);
				sqlSession.commit();

				response.sendRedirect("login.jsp");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
}

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.selectUserByName(userName);

			if (user != null && user.getPassword().equals(password)) {
				request.getSession().setAttribute("userName", userName);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}

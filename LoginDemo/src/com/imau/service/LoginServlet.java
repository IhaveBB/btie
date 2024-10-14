package com.imau.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		if("admin".equals(username) && "123123".equals(password)) {
			System.out.println("Success");
			
			// 1 
//			request.setAttribute("login_status", "OK");
//			request.setAttribute("username", "admin");
			// 2 
//			response.addCookie(new Cookie("login_status", "OK"));
//			response.addCookie(new Cookie("username", "admin"));
//			response.sendRedirect("index.jsp");
			// 3
			
			HttpSession session = req.getSession();
			session.setAttribute("loginStatus", "OK");
			session.setAttribute("loginUser", "Super Admin");
			
			if("on".equals(remember)) {
				session.setMaxInactiveInterval(60*60*24*7);
				Cookie cookie = new Cookie("JSESSIONID", req.getSession().getId());
				cookie.setMaxAge(60*60*24*7);
				resp.addCookie(cookie);
			}
			
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("errorMessage", "your password is wrong! please try again!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	
	}

	
}

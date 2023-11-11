package com.nicebao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
/**
 *
 *
 * @name: HelloServlet
 * @author: IhaveBB
 * @date: 2023-11-11 13:18
 **/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello World");
		resp.getWriter().write("Hello World");
	}
}

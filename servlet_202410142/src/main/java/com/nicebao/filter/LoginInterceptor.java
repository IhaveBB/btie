package com.nicebao.filter;

import com.nicebao.servlet.UserActionLogServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class LoginInterceptor implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requestURI = req.getRequestURI();
		if (requestURI.endsWith("register.jsp")
				|| requestURI.endsWith("servlet.RegisterServlet")
				|| requestURI.endsWith("login.jsp")
				|| requestURI.endsWith("servlet.EmpServlet")) {
			chain.doFilter(request, response);
		} else {
			if (req.getSession().getAttribute("name") == null) {
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
			} else {

				String userRole = (String) req.getSession().getAttribute("role");

				if ("user".equals(userRole)) {
					if (requestURI.contains("UserActionLogServlet")
					) {
						resp.sendRedirect(req.getContextPath() + "/petsearch.jsp");
						return;
					}
				}

				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}
}

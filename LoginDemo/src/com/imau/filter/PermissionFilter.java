package com.imau.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class PermissionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		
		HttpSession session = request.getSession();
		
		Object status = session.getAttribute("loginStatus");
		
		String servletPath = request.getServletPath();
		
		if(servletPath.contains("index.jsp") || 
				servletPath.contains("login.jsp") ||
				servletPath.contains("register.jsp") ||
				servletPath.contains("login") || 
				servletPath.endsWith(".css") || 
				servletPath.endsWith(".js")) {
			chain.doFilter(req, resp);
		} else if("OK".equals(status)) {
			chain.doFilter(req, resp);
		} else {
			req.setAttribute("errorMessage", "you need to login frist!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

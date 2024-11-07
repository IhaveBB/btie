package com.nicebao.filter;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class UserActionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String username = (String) req.getSession().getAttribute("name");
		String ip = req.getRemoteAddr();
		String url = req.getRequestURL().toString();
		EmpDAO ed = new EmpDAO();
		ed.recordUserAction(username, ip, url);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}


}

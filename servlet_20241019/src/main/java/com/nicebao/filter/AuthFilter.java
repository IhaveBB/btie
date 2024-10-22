package com.nicebao.filter;


import com.nicebao.mapper.UserMapper;
import com.nicebao.model.User;
import com.nicebao.model.UserActionLog;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @name: AuthFilter
 * @author: IhaveBB
 * @date: 2024-10-20 12:27
 **/
@WebFilter("/*")
public class AuthFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		String loginURI = httpRequest.getContextPath() + "/login.jsp";
		String registerURI = httpRequest.getContextPath() + "/register.jsp";
		String loginActionURI = httpRequest.getContextPath() + "/login";
		String registerActionURI = httpRequest.getContextPath() + "/register";
		String adminURI = httpRequest.getContextPath() + "/admin.jsp";
		String adminActionURI = httpRequest.getContextPath() + "/admin";

		String welcomeURL = httpRequest.getContextPath()+"/welcome.jsp";
		boolean loggedIn = (session != null && session.getAttribute("user") != null);
		User user = (loggedIn) ? (User) session.getAttribute("user") : null;
		//已经登录了，不拦截
		if (loggedIn ||
				httpRequest.getRequestURI().equals(loginURI) ||
				httpRequest.getRequestURI().equals(registerURI) ||
				httpRequest.getRequestURI().equals(loginActionURI) ||
				httpRequest.getRequestURI().equals(registerActionURI)) {
			if ((httpRequest.getRequestURI().equals(adminURI)||httpRequest.getRequestURI().equals(adminActionURI)) && (user == null || !user.isAdmin())) {
				// 普通用户访问管理员页面，重定向
				((HttpServletResponse) response).sendRedirect(welcomeURL);
				return;
			}
			//记录登录用户的访问记录
			logUserAction((HttpServletRequest) request);
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath() + "/login.jsp");
		}
	}


	private void logUserAction(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					UserActionLog actionLog = new UserActionLog();
					actionLog.setUserId(user.getId());
					actionLog.setActionTime(new Date());
					actionLog.setIp(request.getRemoteAddr());
					actionLog.setUrl(request.getRequestURI());

					userMapper.insertUserActionLog(actionLog);
					sqlSession.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void destroy() {

	}
}

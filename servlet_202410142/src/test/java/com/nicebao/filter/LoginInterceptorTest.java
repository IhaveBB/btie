package com.nicebao.filter;

import 	org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoginInterceptorTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private FilterChain filterChain;

	@Mock
	private HttpSession session;

	private LoginInterceptor loginInterceptor;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this); // 初始化 Mockito 注解
		loginInterceptor = new LoginInterceptor();
	}

	@Test
	public void testDoFilter_LoggedInUser_ShouldProceed() throws Exception {
		// 模拟请求的 URI
		when(request.getRequestURI()).thenReturn("/somepage.jsp");

		// 模拟 session 中的 "name" 和 "role" 属性
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("name")).thenReturn("testUser");
		when(session.getAttribute("role")).thenReturn("user");

		// 调用 doFilter 方法
		loginInterceptor.doFilter(request, response, filterChain);

		// 验证 chain.doFilter 是否被调用
		verify(filterChain).doFilter(request, response);
	}

	@Test
	public void testDoFilter_UserRole_ShouldRedirectToPetSearch() throws Exception {
		// 模拟请求的 URI
		when(request.getRequestURI()).thenReturn("/servlet.UserActionLogServlet");

		// 模拟 session 中的 "name" 和 "role" 属性
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("name")).thenReturn("testUser");
		when(session.getAttribute("role")).thenReturn("user");

		// 模拟 getContextPath 方法
		when(request.getContextPath()).thenReturn("");  // 或者返回"/yourapp" 视情况而定

		// 调用 doFilter 方法
		loginInterceptor.doFilter(request, response, filterChain);

		// 验证重定向是否被调用
		verify(response).sendRedirect("/petsearch.jsp");
	}

	@Test
	public void testDoFilter_NotLoggedIn_ShouldRedirectToLogin() throws Exception {
		// 模拟请求的 URI
		when(request.getRequestURI()).thenReturn("/somepage.jsp");

		// 模拟 session 中没有 "name" 属性
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("name")).thenReturn(null);

		// 模拟 getContextPath 方法
		when(request.getContextPath()).thenReturn("");

		// 调用 doFilter 方法
		loginInterceptor.doFilter(request, response, filterChain);

		// 验证重定向是否被调用
		verify(response).sendRedirect("/login.jsp");
	}


	@Test
	public void testDoFilter_AllowAccessToPublicPages() throws Exception {
		// 模拟请求的 URI
		when(request.getRequestURI()).thenReturn("/login.jsp");
		// 调用 doFilter 方法
		loginInterceptor.doFilter(request, response, filterChain);
		// 验证 chain.doFilter 是否被调用
		verify(filterChain).doFilter(request, response);
	}
}

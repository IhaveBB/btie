package com.nicebao.filter;

import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.mockito.Mockito.*;
/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/6
**/
public class UserActionFilterTest {

	@Mock
	private EmpDAO empDAO;

	@Mock
	private HttpServletRequest request;

	@Mock
	private FilterChain filterChain;

	@Mock
	private ServletResponse response;

	private UserActionFilter userActionFilter;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this); // 初始化 Mockito 注解
		userActionFilter = new UserActionFilter(empDAO); // 创建 UserActionFilter 实例
	}

	@Test
	public void testDoFilter_ShouldRecordUserAction() throws Exception {
		// 模拟请求中的 session 属性
		when(request.getSession()).thenReturn(mock(javax.servlet.http.HttpSession.class));
		when(request.getSession().getAttribute("name")).thenReturn("testUser");
		when(request.getRemoteAddr()).thenReturn("127.0.0.1");
		when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost/somePage"));

		// 执行 doFilter 方法
		userActionFilter.doFilter(request, response, filterChain);

		// 验证 empDAO.recordUserAction 方法是否被调用，参数应为用户名、IP 地址和 URL
		verify(empDAO).recordUserAction("testUser", "127.0.0.1", "http://localhost/somePage");

		// 验证 filterChain.doFilter 是否被调用，表示过滤链继续执行
		verify(filterChain).doFilter(request, response);
	}

	@Test
	public void testDoFilter_WithoutUsername_ShouldNotRecordAction() throws Exception {
		// 模拟请求中的 session 属性为空，表示没有用户登录
		when(request.getSession()).thenReturn(mock(javax.servlet.http.HttpSession.class));
		when(request.getSession().getAttribute("name")).thenReturn(null);
		when(request.getRemoteAddr()).thenReturn("127.0.0.1");
		when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost/somePage"));

		// 执行 doFilter 方法
		userActionFilter.doFilter(request, response, filterChain);

		// 验证 empDAO.recordUserAction 没有被调用
		verify(empDAO, never()).recordUserAction(anyString(), anyString(), anyString());

		// 验证 filterChain.doFilter 是否被调用，表示过滤链继续执行
		verify(filterChain).doFilter(request, response);
	}
}

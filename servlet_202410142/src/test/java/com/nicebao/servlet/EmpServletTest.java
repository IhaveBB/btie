package com.nicebao.servlet;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.FBK;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EmpServletTest {

	@Mock
	private EmpDAO empDAO;

	@Mock
	private FBK fbk;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private HttpSession session;

	@Mock
	private RequestDispatcher requestDispatcher;

	@InjectMocks
	private EmpServlet empServlet;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDoPost_LoginSuccess() throws ServletException, IOException {
		// 模拟请求参数
		when(request.getParameter("username")).thenReturn("testUser");
		when(request.getParameter("password")).thenReturn("testPassword");
		when(request.getHeader("X-Forwarded-For")).thenReturn(null);
		when(request.getRemoteAddr()).thenReturn("127.0.0.1");

		// 模拟EmpDAO.verify返回true表示登录成功
		Employee employee = new Employee();
		employee.setName("testUser");
		employee.setPassword("testPassword");
		when(empDAO.verify(any(Employee.class), eq("127.0.0.1"))).thenReturn(true);

		// 模拟session和forward
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("petsearch.jsp")).thenReturn(requestDispatcher);

		// 执行doPost方法
		empServlet.doPost(request, response);

		// 验证session属性设置和转发
		verify(session).setAttribute("name", "testUser");
		verify(fbk).setFeedBack("登录成功", request);
		verify(requestDispatcher).forward(request, response);
	}

	@Test
	public void testDoPost_LoginFailure() throws ServletException, IOException {
		// 模拟请求参数
		when(request.getParameter("username")).thenReturn("testUser");
		when(request.getParameter("password")).thenReturn("wrongPassword");
		when(request.getHeader("X-Forwarded-For")).thenReturn(null);
		when(request.getRemoteAddr()).thenReturn("127.0.0.1");

		// 模拟EmpDAO.verify返回false表示登录失败
		when(empDAO.verify(any(Employee.class), eq("127.0.0.1"))).thenReturn(false);

		// 模拟forward
		when(request.getRequestDispatcher("login.jsp")).thenReturn(requestDispatcher);

		// 执行doPost方法
		empServlet.doPost(request, response);

		// 验证反馈信息和转发
		verify(fbk).setFeedBack("登录失败，请检查用户名和密码，或者账户已被锁定。", request);
		verify(requestDispatcher).forward(request, response);
	}
}

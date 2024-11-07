package com.nicebao.servlet;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;
import com.nicebao.util.FBK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

class EmpServletTest {

	@InjectMocks
	private EmpServlet empServlet;

	@Mock
	private HttpServletRequest req;

	@Mock
	private HttpServletResponse resp;

	@Mock
	private HttpSession session;

	@Mock
	private RequestDispatcher dispatcher;

	@Mock
	private EmpDAO empDAO;

	@Mock
	private FBK fbk;

	@Mock
	private Conn conn;

	private Employee employee;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		empServlet = new EmpServlet();
		employee = new Employee();
		employee.setName("testUser");
		employee.setPassword("testPassword");
	}

	@Test
	void testDoPostSuccess() throws Exception {
		when(req.getParameter("username")).thenReturn("testUser");
		when(req.getParameter("password")).thenReturn("testPassword");
		when(req.getSession()).thenReturn(session);
		when(req.getHeader("X-Forwarded-For")).thenReturn(null);
		when(req.getRemoteAddr()).thenReturn("127.0.0.1");
		when(empDAO.verify(any(Employee.class), anyString())).thenReturn(true);
		when(req.getRequestDispatcher("petsearch.jsp")).thenReturn(dispatcher);

		empServlet.doPost(req, resp);

		verify(session).setAttribute("name", "testUser");
		verify(fbk).setFeedBack("登录成功", req);
		verify(dispatcher).forward(req, resp);
	}

	@Test
	void testDoPostFailure() throws Exception {
		when(req.getParameter("username")).thenReturn("testUser");
		when(req.getParameter("password")).thenReturn("wrongPassword");
		when(req.getSession()).thenReturn(session);
		when(req.getHeader("X-Forwarded-For")).thenReturn(null);
		when(req.getRemoteAddr()).thenReturn("127.0.0.1");
		when(empDAO.verify(any(Employee.class), anyString())).thenReturn(false);
		when(req.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);

		empServlet.doPost(req, resp);

		verify(fbk).setFeedBack("登录失败，请检查用户名和密码，或者账户已被锁定。", req);
		verify(dispatcher).forward(req, resp);
	}

	@Test
	void testDoGet() throws IOException, ServletException {
		empServlet.doGet(req, resp);
		verify(req).setCharacterEncoding("UTF-8");
		verify(empServlet).doPost(req, resp);
	}
}

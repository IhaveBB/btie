package com.nicebao.Dao;

import org.junit.Test;
import static org.junit.Assert.*;
import com.nicebao.Bean.Employee;
import com.nicebao.util.Conn;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/6
**/
public class EmpDAOTest {

	@Mock
	private Conn conn;

	@Mock
	private Connection sqlConnection;

	@Mock
	private PreparedStatement preparedStatement;

	@Mock
	private ResultSet resultSet;

	@InjectMocks
	private EmpDAO empDAO;

	@Before
	public void setUp() throws SQLException {
		MockitoAnnotations.initMocks(this);
		when(conn.getCn()).thenReturn(sqlConnection);
	}

	@Test
	public void testVerify_SuccessfulLogin() throws SQLException {
		Employee employee = new Employee();
		employee.setName("testUser");
		employee.setPassword("testPassword");

		// 模拟查询成功返回
		when(sqlConnection.prepareStatement(anyString())).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString("password")).thenReturn("testPassword");
		when(resultSet.getString("role")).thenReturn("user");
		when(resultSet.getInt("failed_attempts")).thenReturn(0);
		when(resultSet.getTimestamp("last_failed_time")).thenReturn(new Timestamp(System.currentTimeMillis()));

		// 执行方法
		boolean result = empDAO.verify(employee, "127.0.0.1");

		// 验证行为
		assertTrue(result);
		assertEquals("user", employee.getRole());
		verify(preparedStatement).executeQuery();
	}

	@Test
	public void testVerify_FailedLogin() throws SQLException {
		Employee employee = new Employee();
		employee.setName("testUser");
		employee.setPassword("wrongPassword");

		// 模拟查询成功返回但密码错误
		when(sqlConnection.prepareStatement(anyString())).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);
		when(resultSet.getString("password")).thenReturn("correctPassword");
		when(resultSet.getInt("failed_attempts")).thenReturn(3);
		when(resultSet.getTimestamp("last_failed_time")).thenReturn(new Timestamp(System.currentTimeMillis()));

		// 执行方法
		boolean result = empDAO.verify(employee, "127.0.0.1");

		// 验证结果
		assertFalse(result);
		verify(preparedStatement).executeQuery();
	}

	@Test
	public void testRegister_Success() throws SQLException {
		Employee employee = new Employee();
		employee.setName("newUser");
		employee.setPassword("newPassword");

		// 模拟查询用户是否存在
		when(sqlConnection.prepareStatement(anyString())).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(false);  // 用户不存在

		// 模拟注册成功
		when(preparedStatement.executeUpdate()).thenReturn(1);  // 执行插入操作

		boolean result = empDAO.register(employee);

		// 验证结果
		assertTrue(result);
		verify(preparedStatement, times(1)).executeQuery();  // 确保查询被调用了一次
		verify(preparedStatement, times(1)).executeUpdate();  // 确保插入操作被调用了一次
	}


	@Test
	public void testRegister_UserExists() throws SQLException {
		Employee employee = new Employee();
		employee.setName("existingUser");
		employee.setPassword("password");

		// 模拟用户已存在
		when(sqlConnection.prepareStatement(anyString())).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true);

		boolean result = empDAO.register(employee);

		// 验证结果
		assertFalse(result);
		verify(preparedStatement).executeQuery();
	}

	@Test
	public void testGetLoginLogs() throws SQLException {
		String username = "testUser";

		// 模拟返回登录日志
		when(sqlConnection.prepareStatement(anyString())).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(true, true, false);
		when(resultSet.getString("ip")).thenReturn("127.0.0.1");
		when(resultSet.getTimestamp("login_time")).thenReturn(new Timestamp(System.currentTimeMillis()));
		when(resultSet.getString("status")).thenReturn("success");

		List<String> logs = empDAO.getLoginLogs(username);

		// 验证日志内容和数量
		assertEquals(2, logs.size());
		assertTrue(logs.get(0).contains("IP: 127.0.0.1"));
		verify(preparedStatement).executeQuery();
	}
}

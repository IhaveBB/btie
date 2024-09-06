package com.nicebao.controller;

import com.nicebao.dao.AddrMapper;
import com.nicebao.model.LeaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;


/**
 * @name: UserController
 * @author: IhaveBB
 * @date: 2024-09-03 12:18
 **/
@WebServlet("/user")
@Slf4j
public class AddController extends HttpServlet  {
	private AddrMapper userMapper;
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public void init() throws ServletException {
		try {
			// 加载 MyBatis 配置文件
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			throw new ServletException("无法加载 MyBatis 配置文件", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("utf8");
		String username = req.getParameter("username");
		String studentId = req.getParameter("studentId");
		String contact = req.getParameter("contact");
		String leaveReason = req.getParameter("leaveReason");
		Date leaveStartDate = Date.valueOf(req.getParameter("leaveStartDate"));
		Date leaveEndDate = Date.valueOf(req.getParameter("leaveEndDate"));

		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setStudentName(username);
		leaveRequest.setStudentId(studentId);
		leaveRequest.setContact(contact);
		leaveRequest.setLeaveReason(leaveReason);
		leaveRequest.setLeaveStartDate(leaveStartDate);
		leaveRequest.setLeaveEndDate(leaveEndDate);

		// 使用 MyBatis 保存数据
		try (SqlSession session = sqlSessionFactory.openSession()) {
			AddrMapper mapper = session.getMapper(AddrMapper.class);
			mapper.saveLeaveRequest(leaveRequest);
			session.commit();  // 提交事务
		}
	}
}

package com.nicebao.controller;

import com.nicebao.dao.AddrMapper;
import com.nicebao.model.LeaveRequest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


/**
 * @name: UserController
 * @author: IhaveBB
 * @date: 2024-09-03 12:18
 **/
@WebServlet("/user")
public class AddController extends HttpServlet  {
	private AddrMapper userMapper;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);

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










	}
}

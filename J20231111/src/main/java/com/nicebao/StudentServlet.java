package com.nicebao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;


@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private StudentDAO studentDAO = new StudentDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
			case "add":
				addStudent(request, response);
				break;
			case "view":
				viewStudents(request, response);
				break;
			case "delete":
				deleteStudent(request, response);
				break;
			case "update":
				updateStudent(request, response);
				break;
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从请求参数中获取学生信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// 创建学生对象
		Student student = new Student(id, name, age);

		// 调用DAO层添加学生
		studentDAO.addStudent(student);

		// 跳转到成功页面或其他操作
		response.sendRedirect("success.jsp");
	}

	private void viewStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有学生信息
		List<Student> students = studentDAO.getAllStudents();

		// 将学生信息放入request中，以便在JSP页面中显示
		request.setAttribute("students", students);

		// 转发到显示学生信息的页面
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudents.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从请求参数中获取要删除的学生ID
		String studentId = request.getParameter("id");

		// 调用DAO层删除学生
		studentDAO.deleteStudent(studentId);

		// 跳转到成功页面或其他操作
		response.sendRedirect("success.jsp");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从请求参数中获取更新后的学生信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// 创建更新后的学生对象
		Student updatedStudent = new Student(id, name, age);

		// 调用DAO层更新学生信息
		studentDAO.updateStudent(updatedStudent);

		// 跳转到成功页面或其他操作
		response.sendRedirect("success.jsp");
	}
}

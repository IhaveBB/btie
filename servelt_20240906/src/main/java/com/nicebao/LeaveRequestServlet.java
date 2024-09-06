package com.nicebao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

@WebServlet("/LeaveRequestServlet")
@MultipartConfig
public class LeaveRequestServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");

		// 获取表单的文本数据
		String name = request.getParameter("name");
		String studentId = request.getParameter("studentId");
		String contact = request.getParameter("contact");
		String leaveDate = request.getParameter("date");
		String reason = request.getParameter("reason");

		// 文件上传部分
		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
		File uploadDirFile = new File(uploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdir();
		}
		String filePath = uploadDir + File.separator + fileName;
		filePart.write(filePath);

		// 将信息保存到服务器端（此处简单使用文本文件存储）
		String data = String.format("姓名: %s\n学号: %s\n联系方式: %s\n请假日期: %s\n请假原因: %s\n文件路径: %s\n",
				name, studentId, contact, leaveDate, reason, filePath);
		String recordPath = getServletContext().getRealPath("") + File.separator + "leave_records.txt";
		try (FileWriter writer = new FileWriter(recordPath, true)) {
			writer.write(data);
			writer.write("-------------------------------\n");
		}

		// 反馈信息
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>申请提交成功！</h3>");
		out.println("<p>姓名: " + name + "</p>");
		out.println("<p>学号: " + studentId + "</p>");
		out.println("<p>请假日期: " + leaveDate + "</p>");
		out.println("<p>请假原因: " + reason + "</p>");
		out.println("<p>文件已上传: " + fileName + "</p>");
	}
}

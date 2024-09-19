
/**
 * @name: messageServlet
 * @author: IhaveBB
 * @date: 2024-09-18 17:22
 **/
package com.nicebao.service;
import com.nicebao.mapper.MessageMapper;
import com.nicebao.model.Message;
import com.nicebao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

	// 插入消息
	private boolean insertMessage(String username, String content) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			int result = messageMapper.insertMessage(username, content);
			sqlSession.commit();
			return result > 0;
		}
	}

	// 获取所有消息
	private List<Message> getAllMessages() {
		System.out.println("Retrieving all messages from the database");
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			List<Message> messages = messageMapper.getAllMessages();
			System.out.println("Messages from DB: " + messages);
			return messages;
		} catch (Exception e) {
			System.out.println("Error retrieving messages: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取登录用户的用户名
		String userName = (String) request.getSession().getAttribute("userName");
		// 如果用户未登录，重定向到登录页面
		if (userName == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String content = request.getParameter("content");
		if (insertMessage(userName, content)) {
			doGet(request, response);
			response.sendRedirect("message.jsp");
		} else {
			request.setAttribute("errorMessage", "留言提交失败，请重试");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Message> messages = getAllMessages();
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}


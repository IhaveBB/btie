
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

	/** 
	* @description: 分页获取留言
	* @param: [int, int]
	* @return: java.util.List<com.nicebao.model.Message>
	* @author: IhaveBB
	* @date: 2024/10/14 
	**/
	private List<Message> getMessagesByPage(int offset, int limit) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			return messageMapper.getMessagesByPage(offset, limit);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("errorMessage", "留言提交失败，请重试");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/** 
	* @description: 计算留言总数
	* @param: []
	* @return: int
	* @author: IhaveBB
	* @date: 2024/10/14 
	**/
	private int countMessages() {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			return messageMapper.countMessages();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Message> messages = getAllMessages();
//		request.setAttribute("messages", messages);
//		response.setContentType("text/html; charset=UTF-8");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		// 获取当前页码和每页的留言数量
		int currentPage = 1;
		int pageSize = 5;
		String pageParam = request.getParameter("page");
		if (pageParam != null) {
			try {
				currentPage = Integer.parseInt(pageParam);
			} catch (Exception e) {
				//如果出现异常，默认使用第一页
				currentPage = 1;
			}
		}

		// 计算偏移量
		int offset = (currentPage - 1) * pageSize;
		// 获取分页的留言数据和总数
		List<Message> messages = getMessagesByPage(offset, pageSize);
		int totalMessages = countMessages();
		int totalPages = (int) Math.ceil((double) totalMessages / pageSize);

		// 将数据设置到请求属性中
		request.setAttribute("messages", messages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}


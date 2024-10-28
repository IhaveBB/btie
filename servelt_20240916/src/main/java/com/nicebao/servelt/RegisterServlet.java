package com.nicebao.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    // 使用一个 Map 存储注册用户信息（简单实现，实际应用中需要使用数据库）
    public static Map<String, User> users = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.trim().isEmpty() && !password.trim().isEmpty()) {
            if (users.containsKey(username)) {
                request.setAttribute("error", "用户名已存在。");
                request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            } else {
                users.put(username, new User(username, password));
                response.sendRedirect("login");
            }
        } else {
            request.setAttribute("error", "用户名和密码不能为空。");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }
    }
}

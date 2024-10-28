package com.nicebao.servelt;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && RegisterServlet.users.containsKey(username)) {
            User user = RegisterServlet.users.get(username);
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("welcome");
            } else {
                request.setAttribute("error", "密码错误。");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "用户名不存在。");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}

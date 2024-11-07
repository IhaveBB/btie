package com.nicebao.servlet;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.Conn;
import com.nicebao.util.FBK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class EmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Conn cn = new Conn();
        FBK fbk = new FBK();
        EmpDAO ed = new EmpDAO();
        Employee ep = new Employee();
        ep.setName(req.getParameter("username"));
        ep.setPassword(req.getParameter("password"));
        String ip = req.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty()) {
            ip = req.getRemoteAddr();
        }

        if (ed.verify(ep,ip)) {
            HttpSession session = req.getSession();
            session.setAttribute("name", ep.getName());
            session.setAttribute("role", ep.getRole());
            fbk.setFeedBack("登录成功", req);
            req.getRequestDispatcher("petsearch.jsp").forward(req, resp);
        } else {
            fbk.setFeedBack("登录失败，请检查用户名和密码，或者账户已被锁定。", req);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        cn.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

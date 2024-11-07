package com.nicebao.servlet;

import com.nicebao.Bean.Employee;
import com.nicebao.Dao.EmpDAO;
import com.nicebao.util.FBK;
import com.nicebao.util.Conn;

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

    private EmpDAO empDAO;
    private FBK fbk;

    public EmpServlet(EmpDAO empDAO, FBK fbk) {
        this.empDAO = empDAO;
        this.fbk = fbk;
    }

    // 默认构造函数，用于兼容现有代码
    public EmpServlet() {
        this.empDAO = new EmpDAO(new Conn());
        this.fbk = new FBK();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 从请求中获取用户信息
        Employee ep = new Employee();
        ep.setName(req.getParameter("username"));
        ep.setPassword(req.getParameter("password"));

        // 获取客户端 IP 地址
        String ip = req.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty()) {
            ip = req.getRemoteAddr();
        }

        // 验证登录
        if (empDAO.verify(ep, ip)) {
            // 登录成功，设置会话
            HttpSession session = req.getSession();
            session.setAttribute("name", ep.getName());
            session.setAttribute("role", ep.getRole());

            fbk.setFeedBack("登录成功", req);
            req.getRequestDispatcher("petsearch.jsp").forward(req, resp);
        } else {
            // 登录失败，反馈信息
            fbk.setFeedBack("登录失败，请检查用户名和密码，或者账户已被锁定。", req);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

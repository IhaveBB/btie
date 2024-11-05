package com.nicebao.web;



public class DeptServlet extends BaseServlet {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Department> page = departmentService.page(pageNo, pageSize);

        page.setUrl("deptServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Dept.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        pageNo += 100;

        Department department = WebUtils.WebUtils(req.getParameterMap(), new Department());

        departmentService.addDepartment(department);

        resp.sendRedirect(req.getContextPath() + "/deptServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        departmentService.deleteDepartment(id);

        resp.sendRedirect(req.getContextPath() + "/deptServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = WebUtils.WebUtils(req.getParameterMap(), new Department());

        departmentService.updateDepartment(department);

        resp.sendRedirect(req.getContextPath() + "/deptServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Department department = departmentService.queryDepartmentbyId(id);

        req.setAttribute("dept", department);

        req.getRequestDispatcher("/page/edit_page/Dept_edit.jsp").forward(req, resp);
    }

    protected void findByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dno = WebUtils.parseInt(req.getParameter("dno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Department> page = departmentService.findOneByNo(pageNo, pageSize, dno);

        page.setUrl("deptServlet?action=findByNo&dno=" + dno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Dept.jsp").forward(req, resp);
    }

    protected void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dno = WebUtils.parseInt(req.getParameter("dno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        String dname = new String(req.getParameter("dname").getBytes("ISO-8859-1"),"utf-8");
        String dname = req.getParameter("dname");

        Page<Department> page = departmentService.findOneByName(pageNo, pageSize, dname);

        page.setUrl("deptServlet?action=findByName&dname=" + dname);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Dept.jsp").forward(req, resp);

    }


}

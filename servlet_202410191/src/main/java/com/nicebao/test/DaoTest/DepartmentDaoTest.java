package com.nicebao.test.DaoTest;


import com.nicebao.dao.DepartmentDao;
import com.nicebao.dao.impl.DepartmentDaoImpl;
import com.nicebao.pojo.Department;

public class DepartmentDaoTest {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Test
    public void addDepartment() {
        departmentDao.addDepartment(new Department(null, "生物学院", "小红"));
    }

    @Test
    public void deleteDepartment() {
        departmentDao.deleteDepartment(404);
    }

    @Test
    public void updateDepartment() {
        departmentDao.updateDepartment(new Department(405, "美术学院", "五五开"));
    }

    @Test
    public void queryDepartmentbyId() {
        System.out.println(departmentDao.queryDepartmentbyId(400));
    }

    @Test
    public void queryDepartments() {
        for (Department d : departmentDao.queryDepartments()) {
            System.out.println(d);
        }
    }
}
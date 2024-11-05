package com.nicebao.test.ServiceTest;


import com.nicebao.dao.ManagerDao;
import com.nicebao.dao.impl.ManagerDaoImpl;
import com.nicebao.pojo.Manager;

public class ManagerServiceTest {

    ManagerDao managerDao = new ManagerDaoImpl();

    @Test
    public void querymanagerbyname() {
        System.out.println(managerDao.querymanagerbynameandpwd("bobo", "123456"));
    }

    @Test
    public void saveManager() {
        managerDao.saveManager(new Manager(null, "coco", "123456", "0"));
    }
}
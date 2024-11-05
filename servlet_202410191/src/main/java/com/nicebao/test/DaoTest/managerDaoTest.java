package com.nicebao.test.DaoTest;



public class managerDaoTest {

    ManagerDao managerDao = new ManagerDaoImpl();

    @Test
    public void querymanagerbyname() {
        if (managerDao.querymanagerbynameandpwd("bobo", "123456") != null) {
            System.out.println("找到了！");
            //System.out.println(managerDao.querymanagerbynameandpwd());
        } else {
            System.out.println("找不到！");
        }

    }

    @Test
    public void saveManager() {
        //System.out.println(managerDao.saveManager(new Manager(null, "bobo", "111111")));
        managerDao.saveManager(new Manager(null, "zxcv", "123456", "1"));
    }
}
package com.nicebao.test.DaoTest;


import com.nicebao.dao.CourseDao;
import com.nicebao.dao.impl.CourseDaoImpl;
import com.nicebao.pojo.Course;

public class CourseDaoTest {

    private CourseDao courseDao = new CourseDaoImpl();

    @Test
    public void addCourse() {
        courseDao.addCourse(new Course(null, "如何成为百万富翁", "11", 2));
    }

    @Test
    public void deleteCourse() {
        courseDao.deleteCourse(206);
    }

    @Test
    public void updateCourse() {
        courseDao.updateCourse(new Course(207, "如何成为百万富翁", "11", 6));
    }

    @Test
    public void queryCoursebyId() {
        System.out.println(courseDao.queryCoursebyId(203));
    }

    @Test
    public void queryCourses() {
        for (Course c : courseDao.queryCourses()) {
            System.out.println(c);
        }
    }
}
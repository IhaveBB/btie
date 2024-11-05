package com.nicebao.test.ServiceTest;


public class CourseServiceTest {

    private CourseService courseService = new CourseServiceImpl();

    @Test
    public void addCourse() {
        courseService.addCourse(new Course(null, "如何成为亿万富翁", "13", 4));
    }

    @Test
    public void deleteCourse() {
    }

    @Test
    public void updateCourse() {
        courseService.updateCourse(new Course(208, "如何成为十万富翁", "13", 2));
    }

    @Test
    public void queryCoursebyId() {
        System.out.println(courseService.queryCoursebyId(208));
    }

    @Test
    public void queryCourses() {
        for (Course course : courseService.queryCourses()) {
            System.out.println(course);
        }
    }
}
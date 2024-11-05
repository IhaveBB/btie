package com.nicebao.test.ServiceTest;


public class TeacherServiceTest {

    private TeacherService teacherService = new TeacherServiceImpl();

    @Test
    public void addTeacher() {
        teacherService.addTeacher(new Teacher(null, "周星辉", "男", 50, "学士", "教授", "rapper", "dance", ""));
    }

    @Test
    public void deleteTeacher() {
    }

    @Test
    public void updateTeacher() {
        teacherService.updateTeacher(new Teacher(307, "周星型", "男", 50, "学士", "教授", "rapper", "dance", ""));
    }

    @Test
    public void queryTeacherbyId() {
        System.out.println(teacherService.queryTeacherbyId(307));
    }

    @Test
    public void queryTeachers() {
    }
}
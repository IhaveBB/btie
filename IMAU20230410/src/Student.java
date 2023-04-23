class Student {
    private String name;
    private int age;
    private String gender;
    private String school;
    private String major;

    Student(String na, int ag, String ge, String sc, String ma) {
        System.out.printf("姓名:%s，年龄:%d，性别:%s，学校:%s，专业:%s\n", na, ag, ge, sc, ma);
    }

    void show() {
        System.out.printf("姓名%s，年龄%d，性别%s，学校%s，专业%s\n", name, age, gender, school, major);
    }
}
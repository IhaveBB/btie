public class Course {
    private int number;
    private String teacherName;
    private String course;
    Course(int number, String teacherName, String course){
        this.number = number;
        this.teacherName = teacherName;
        this.course = course;
    }
    public int getNumber(){
        return number;
    }
    Course(){}
    public void setNumber(int number) {
        this.number = number;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String toString(){
        return "课程名"+course+"||"+"授课教师:"+teacherName+"||"+"课程序号"+number;
    }
}

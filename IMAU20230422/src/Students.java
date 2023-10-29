import javax.swing.*;

public class Students {
    private Course[] c=new Course[8];
    private String studentName;
    int index=0;
    Students(String studentName){
        this.studentName = studentName;
    }
    public void ChooseCourses(int number, String teacherName, String course){
        c[index]=new Course(number,teacherName,course);
        index++;
        }
    public void deleteCourse(int number) {
        for(int i=0; i<index; i++) {
            if(number==c[i].getNumber()) {
                c[i]=null;
            }
        }
    }
    Students(){}
    public void showCourse(){
        for(int i=0;i<index;i++){
            if(c[i]!=null) {
                System.out.println(c[i].toString());
            }
        }
    }
}

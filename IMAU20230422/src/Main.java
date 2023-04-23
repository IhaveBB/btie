import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
        Students s1 = new Students();
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("请输入要选择的课序号，退课请输入-2（每次操作只可退一个课程)，输入-1结束操作。");
        do {
            num = sc.nextInt();
            switch (num) {
                case 100001:
                    s1.ChooseCourses(100001, "于德纲", "JAVA");
                    System.out.println("操作成功");
                    break;
                case 100002:
                    s1.ChooseCourses(100002, "于又谦", "C");
                    System.out.println("操作成功");
                    break;
                case 100003:
                    s1.ChooseCourses(100003, "于再谦", "Python");
                    System.out.println("操作成功");
                    break;
                case 100004:
                    s1.ChooseCourses(100004, "于还谦", "C++");
                    System.out.println("操作成功");
                    break;
                case 100005:
                    s1.ChooseCourses(100005, "于鞭", "数据结构");
                    System.out.println("操作成功");
                    break;
                case 100006:
                    s1.ChooseCourses(100006, "于玉菊", "数据库");
                    System.out.println("操作成功");
                    break;
                case -2:
                    System.out.println("已选课如下，退课请输入课程编号");
                    s1.showCourse();
                    num = sc.nextInt();
                    s1.deleteCourse(num);
                    break;
                default:
                    System.out.println("error");
            }
        } while (num != -1);
        s1.showCourse(); // move this line outside the loop
    }

    public static void menu() {
        System.out.println("课序号：100001||授课教师：于德纲||JAVA");
        System.out.println("课序号：100002||授课教师：于又谦||C");
        System.out.println("课序号：100003||授课教师：于再谦||Python");
        System.out.println("课序号：100004||授课教师：于还谦||C++");
        System.out.println("课序号：100005||授课教师：于鞭||数据结构");
        System.out.println("课序号：100006||授课教师：于玉菊||数据库");
    }
}
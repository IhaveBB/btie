import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(""); // 实例化学生对象
        Scanner SC = new Scanner(System.in);
        menu();
        int choice = SC.nextInt();

        while (choice != -1) { // 选课循环
            switch (choice) {
            case 1:
                s.select("java", 1);
                break;
            case 2:
                s.select("C++", 2);
                break;
            case 3:
                s.select("C", 3);
                break;
            case 4:
                s.select("AI", 4);
                break;
            case 5:
                s.select("Python", 5);
                break;
            default:
                System.out.println("无效的选课编号！");
                break;
            }
            System.out.println("请输入你想选课的序号,选完课请按-1进行后续操作");
            choice = SC.nextInt();
        }

        int option = 0;
        while (option != 3) { // 退课循环
            System.out.println("输入1进行退课,输入2查看当前已选课程,输入3退出");
            option = SC.nextInt();
            switch (option) {
            case 1:
                System.out.println("当前已选课程:");
                s.query();
                System.out.println("请输入退课的编号");
                int course = SC.nextInt();
                s.delete(course);
                System.out.println("退课成功");
                break;
            case 2:
                System.out.println("当前已选课程:");
                s.query();
                break;
            case 3:
                System.out.println("退出选课系统");
                break;
            default:
                System.out.println("无效的选项！");
                break;
            }
        }
    }

    public static void menu() {
        System.out.println("java 1");
        System.out.println("C++  2");
        System.out.println("C  3");
        System.out.println("AI   4");
        System.out.println("Python  5");
    }
}

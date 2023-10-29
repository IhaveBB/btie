import java.util.Scanner;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Birthday birth = new Birthday(2004,04,03);
        Students s1 = new Students("张三",10001,birth);
        System.out.println(s1);
        Students s2 = (Students)s1.clone();
        System.out.println("克隆s1"+s2);
        System.out.println("================================================================");
        s1.sno=10002;
        System.out.println(s1);
        System.out.println("克隆s1"+s2);
        System.out.println("================================================================");
        s1.birth.month=1;
        System.out.println(s1);
        System.out.println("克隆s1"+s2);
        System.out.println("================================================================");
    }
}
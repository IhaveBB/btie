package Circle;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
      /*  System.out.println("请输入圆的坐标和半径");
        Scanner sc = new Scanner(System.in);
        Circle c1 = new Circle(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        Circle c2 = (Circle)c1.clone();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("================================================");
        c1.setRadius(20);
        System.out.println(c1);
        System.out.println(c2);*/
        ComparableCircle c1 = new ComparableCircle();
        ComparableCircle c2 = new ComparableCircle();
        c1.setRadius(5);
        c2.setRadius(10);
        System.out.println(c1);
        System.out.println(c2);
        if (c1.compareTo(c2) == 0) {
            System.out.println("c1==c2");
        } else if (c1.compareTo(c2) > 0) {
            System.out.println("c1<c2");
        } else if (c1.compareTo(c2) < 0) {
            System.out.println("c1>c2");
        }
    }
}




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle r1 = new Rectangle();
        Circle c1 = new Circle();
        System.out.println("请输入半径");
        c1.setRadius(sc.nextDouble());
        System.out.println("圆的面积为"+c1.getArea());

        System.out.println("请输入长和宽");
        r1.setRectangle(sc.nextDouble(),sc.nextDouble());
        System.out.println("矩形的面积为"+r1.getArea());

    }
}
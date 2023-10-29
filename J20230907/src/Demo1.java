import java.util.Scanner;

public class Demo1 {
    private volatile static int isQuite = 0;
    public static void main1(String[] args) {
        Thread t = new Thread(() -> {
            while (isQuite == 0) {
                // 循环体啥也没干
                // 意味着执行速度极快，一秒钟会执行很多次
            }
            System.out.println("t线程执行完毕");
        });
        t.start();

        Scanner sc = new Scanner(System.in);
        isQuite = sc.nextInt();
        System.out.println("main线程执行完毕");
    }
}
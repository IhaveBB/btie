import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
    public static void main(String[] args) {
        ExecutorService threadPool = new newFixedThreadPool(2);
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName());
            }
        };
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        System.out.println("主线程结束");
    }
}
class Point{

}
class PointFactory(){
    public static Point makePointByXY(double x, double y){
        Point p = new Point();
        p.setX(X);
        P.setY(Y);
        return p;
    }
    public static Point makePointByA(double r,double a){
        //写一个方法
    }
}
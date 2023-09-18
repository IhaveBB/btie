import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            long begin = System.currentTimeMillis();
            try {
                TimeUnit.MICROSECONDS.sleep(1000); // 休眠1微秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println(end-begin);
        });
        t.start();
    }
}

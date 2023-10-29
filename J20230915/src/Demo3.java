import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo3 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                System.out.println("线程：" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

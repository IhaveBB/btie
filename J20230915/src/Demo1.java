import java.util.Collection;
import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,100,TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        for(int i = 0; i < 10; i++) {
            int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
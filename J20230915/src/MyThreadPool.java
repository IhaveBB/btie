import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool{
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000); // 1000 是队列的容量

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    public MyThreadPool(int n   ) {
        for(int i = 0; i < n; i++){
            Thread t = new Thread(() -> {
                try {
                    Runnable runnable  = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            int id = i;
            myThreadPool.submit(() -> {
                System.out.println("执行任务：" + id);
            });
        }
    }

}
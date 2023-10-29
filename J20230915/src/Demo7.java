import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo7 {

    public static void main(String[] args) {
        // 创建工作窃取线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();

        // 提交一些任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started  " + Thread.currentThread().getName());
                    // 模拟任务执行
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Task " + taskId + " completed  " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 等待一段时间，以确保任务有足够的时间完成
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}

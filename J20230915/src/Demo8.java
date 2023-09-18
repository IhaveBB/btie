import java.util.Date;
import java.util.concurrent.*;

public class Demo8 {

    public static void main(String[] args) {
        // 创建线程池，核心线程数为1，最大线程数为1，队列容量为1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        // 设置拒绝策略为 CallerRunsPolicy
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 任务
        Runnable runnable = () -> {
            System.out.println("当前任务被执行, 执行时间: " + new Date() +
                    " 执行线程: " + Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // 开启4个任务
        for (int i = 0; i < 4; i++) {
            threadPool.execute(runnable);
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}
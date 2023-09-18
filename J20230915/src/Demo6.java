import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo6 {

    public static void main(String[] args) {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        // 安排任务在一定的延迟后执行
        singleThreadScheduledExecutor.schedule(() -> {
            System.out.println("Task 1 executed at: " + new Date());
        }, 2, TimeUnit.SECONDS);

        // 安排任务在固定的时间间隔内重复执行
        singleThreadScheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Task 2 executed at: " + new Date());
        }, 0, 5, TimeUnit.SECONDS);

        // 在此示例中，Task 1将在2秒后执行一次，而Task 2将每隔5秒执行一次

        // 等待一段时间后关闭SingleThreadScheduledExecutor

    }
}

    import java.util.concurrent.RejectedExecutionHandler;
    import java.util.concurrent.ThreadPoolExecutor;

    public class Demo9 implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 自定义拒绝策略的处理逻辑
            System.out.println("任务被拒绝执行：" + r.toString());
            // 可以根据需求执行其他操作，例如记录日志、重新提交任务等
        }
    }

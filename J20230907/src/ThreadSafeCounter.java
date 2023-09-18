import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {
    public static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("结果：" + counter.count);
    }
}

class Counter{
    public int count = 0;

    public synchronized void increment(){
        count++;
    }
}
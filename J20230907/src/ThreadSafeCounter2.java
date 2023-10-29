public class ThreadSafeCounter2 {
    private static volatile int COUNTER = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (COUNTER % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    COUNTER++;
                    lock.notifyAll();
                }
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (COUNTER % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    COUNTER++;
                    lock.notifyAll();
                }
            }
        }, "B");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (COUNTER % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    COUNTER++;
                    lock.notifyAll();
                }
            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}

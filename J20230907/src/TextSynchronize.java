import com.sun.applet2.Applet2;

public class TextSynchronize {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("t1 acquired  lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 is waiting lock2");
                synchronized (lock2) {
                    System.out.println("t1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("t2 acquired lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 is waiting lock1");
                synchronized (lock1) {
                    System.out.println("t2 acquired lock1");
                }
            }
        });
        t1.start();
        t2.start();

    }
}


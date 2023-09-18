/*
class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                System.out.println(finalI);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("ok");
    }
}

 class Main2{
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        t.join();
        System.out.println("2");
    }

}

class Main3{
    public static void main(String[] args) throws InterruptedException {
        MyThread mythread = new MyThread();
        mythread.start();
        mythread.join();
        System.out.println("Main");
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread");
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myrunnable = new MyRunnable();
        Thread thread = new Thread(myrunnable);
        thread.start();
        thread.join();
        System.out.println("Main");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable");
    }
}*/

/*
class Main{
    public static void main(String[] args) throws InterruptedException {
        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("mythread");
            }
        });
        mythread.start();
        mythread.join();
        System.out.println("main");
    }
}*/

class Main{
    private volatile static boolean isQuite = false;
    public static void main(String[] args) throws InterruptedException {
        Thread mythread = new Thread(() -> {
            while(!isQuite) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程结束");
        });
        mythread.start();
        Thread.sleep(5000);
        System.out.println("isQuite = true");
        isQuite = true;
    }
}
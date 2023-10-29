public class Demo1{
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("");
        });
    }
}




/*public class Demo1 {
    public static void main1(String[] args) {
       Thread thread = new Thread() {
           @Override
           public void run(){
               System.out.println("Mythread");
           }
       };
        thread.start();
    }

    public static void main(String[] args) {
        Runnable run = new Runnable(){
          @Override
          public void run(){
              System.out.println("MyRunnable");
            }
        };
        Thread thread = new Thread(run);
        thread.start();
    }
}*/

/*
class MyThread extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println("MyThread");
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while(true)
            System.out.println("MyRunnable");
        }
    }
}*/


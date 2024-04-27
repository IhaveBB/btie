
public class Bank{
	private static int userNumber = 20;

	public static void main(String [] args) {
		Vip vip = new Vip();
		Thread t = new Thread(() ->{
			while(userNumber > 0) {
				System.out.println("业务正常办理中，前面等待的"+userNumber--+"人");
				if(userNumber == 10) {
					System.out.println("VIP用户进入VIP办理中");
					try {
						vip.start();
						vip.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
}

class Vip extends Thread{
	@Override
	public void run() {
		System.out.println("VIP办理中");
		for(int i = 10;  i>0; i--) {
			System.out.println(i+"秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
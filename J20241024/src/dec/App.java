package dec;

/**
 * @name: App
 * @author: IhaveBB
 * @date: 2024-10-24 20:12
 **/
public class App {
	public static void main(String[] args) {
		Cake c = new FlourCake();
		Cake c1 = new Sugar(new Vinegar(c));
		c1.make();
	}
}

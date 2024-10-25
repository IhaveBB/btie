package dec;

/**
 * @name: Salt
 * @author: IhaveBB
 * @date: 2024-10-24 20:10
 **/
public class Salt extends Decorator {
	public Salt(Cake c) {
		super(c);
	}

	@Override
	public void make() {
		System.out.println("salt");
		c.make();
	}
}

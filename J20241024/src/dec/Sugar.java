package dec;

/**
 * @name: Suger
 * @author: IhaveBB
 * @date: 2024-10-24 20:07
 **/
public class Sugar extends Decorator{
	public Sugar(Cake c) {
		super(c);
	}

	@Override
	public void make() {
		System.out.println("suger");
		c.make();
	}
}

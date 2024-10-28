package dec;

/**
 * @name: vinegar
 * @author: IhaveBB
 * @date: 2024-10-24 20:17
 **/
public class Vinegar extends Decorator{
	public Vinegar(Cake c) {
		super(c);
	}

	@Override
	public void make() {
		System.out.println("vinegar");
		c.make();
	}
}

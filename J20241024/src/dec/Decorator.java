package dec;

/**
 * @name: Decorator
 * @author: IhaveBB
 * @date: 2024-10-24 20:02
 **/
public abstract class Decorator implements Cake{
	protected Cake c;
	public Decorator(Cake c) {
		this.c = c;
	}
}

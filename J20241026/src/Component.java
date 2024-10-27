/**
 * @name: Component
 * @author: IhaveBB
 * @date: 2024-10-26 21:10
 **/
public interface Component {
	void click();
	void add(Component child);
	void remove(Component child);
	String getName();
}


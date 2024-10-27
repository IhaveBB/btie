import java.util.ArrayList;
import java.util.List;

/**
 * @name: composite
 * @author: IhaveBB
 * @date: 2024-10-26 21:09
 **/
public class Composite implements Component{
	private String name;
	private List<Component> children = new ArrayList<>();

	public Composite(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void click() {
			for (Component child : children) {
				System.out.print(child.getName() + " ");
			}
			System.out.println();
	}

	@Override
	public void add(Component child) {
		children.add(child);
	}

	@Override
	public void remove(Component child) {
		children.remove(child);
	}
}

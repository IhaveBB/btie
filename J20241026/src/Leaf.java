/**
 * @name: Leaf
 * @author: IhaveBB
 * @date: 2024-10-26 21:07
 **/
public class Leaf implements Component{
	private String name;

	public Leaf(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}


	@Override
	public void click() {
		System.out.println(getName());
	}

	@Override
	public void add(Component child) {
		System.out.println("叶子节点不能再扩展子节点");
	}

	@Override
	public void remove(Component child) {
		System.out.println("叶子节点无法删除子节点");

	}
}

/**
 * @name: HomosFactory
 * @author: IhaveBB
 * @date: 2024-10-19 12:15
 **/
public class HomosFactory implements ProductFactory {

	@Override
	public Product createProduct() {
		return new HomosVersion();
	}
}

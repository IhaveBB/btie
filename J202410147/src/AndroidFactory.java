/**
 * @name: AndroidFactory
 * @author: IhaveBB
 * @date: 2024-10-19 12:14
 **/
	public class AndroidFactory implements ProductFactory {
	@Override
	public Product createProduct() {
		return new AndroidVersion();
	}

}

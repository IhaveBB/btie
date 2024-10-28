/**
 * @name: ImauFactory
 * @author: IhaveBB
 * @date: 2024-10-23 16:48
 **/
public class ImauFactory implements ProductFactory{
	@Override
	public Product createProduct() {
		return new ImauVersion();
	}
}

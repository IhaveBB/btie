/**
 * @name: App
 * @author: IhaveBB
 * @date: 2024-10-17 20:27
 **/
public class App {
	public static void main(String[] args){
		ProductFactory  productFactory = getProductFactory();
		Product product = productFactory.createProduct();
		System.out.println(product.getVersion());

	}

		public static ProductFactory  getProductFactory(){
		String class_name = ParamRead.getParam("class_name");
		switch (class_name) {
			case "Android":
				return new AndroidFactory();
			case "Apple":
				return new AppleFactory();
			case "Homos":
				return new HomosFactory();
			case "Imau":
				return new ImauFactory();
			default:
				return null;
		}
	}
}

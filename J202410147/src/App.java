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
		if(class_name.equals("Android")){
			return new AndroidFactory();
		} else if (class_name.equals("Apple")) {
			return new AppleFactory();
		} else if (class_name.equals("Homos")) {
			return new HomosFactory();
		}else{
			return null;
		}
	}
}

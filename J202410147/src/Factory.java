/**
 * @name: Factory
 * @author: IhaveBB
 * @date: 2024-10-17 20:44
 **/
public class Factory {
	public static D getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String class_name = ParamRead.getParam("class_name");
		System.out.println("class_Name:"+class_name);
		Class c = Class.forName(class_name);
		return (D)c.newInstance();
	}
}

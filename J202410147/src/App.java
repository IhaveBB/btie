import java.sql.SQLOutput;

/**
 * @name: App
 * @author: IhaveBB
 * @date: 2024-10-17 20:27
 **/
public class App {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		D d = Factory.getInstance();
		d.say();
	}
}

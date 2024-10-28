import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @name: ParamRead
 * @author: IhaveBB
 * @date: 2024-10-17 20:13
 **/
public class ParamRead {
	public static String getParam(String name){
		String value = null;
		try {
			FileInputStream fls = new FileInputStream("param");
			BufferedReader br = new BufferedReader(new InputStreamReader(fls));
			Properties p = new Properties();
			p.load(br);
			value = p.getProperty(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return value;
	}
}

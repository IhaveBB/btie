import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");
		Map<Integer,String> map1 = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for(Integer o : map1.keySet()){
			System.out.println(map1.get(o));

		}
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("a.dat"));


	}
}
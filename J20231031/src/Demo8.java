import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo8 {
	public static void main(String [] args) throws IOException, ClassNotFoundException {

		Set<Product> set = new HashSet<Product>();
		File file = new File("product.txt");
		if (!file.exists()) {
			System.out.println("您读取的文件不存在");
			return;
		}
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] items = str.split("\\s");
			//价格转为double,清洗数据
			String price = items[1].replaceAll("[￥/kg]","").trim();
			Product product = new Product();
			product.setName(items[0]);
			product.setPrice(Double.parseDouble(price));
			product.setType(items[2]);
			product.setInfo(items[3]);
			set.add(product);
		}


		//遍历HashSet集合元素，并将通过ObjectOutputStream存储于二进制文件中
		File nFile = new File("nFile.txt");
		FileOutputStream out = new FileOutputStream(nFile);
		ObjectOutputStream output = new ObjectOutputStream(out);
		for (Product p : set) {
			output.writeObject(p);
		}
		output.writeObject(null);
		output.close();
		System.out.println("文件存储完成");
		//读取二进制文件中存储的对象，比较二进制文件中存储的对象和源文件中存储对象的个数是否一致，为什么？
		FileInputStream in = new FileInputStream(nFile);
		ObjectInputStream input2 = new ObjectInputStream(in);
		Object obj;
		while ((obj = input2.readObject()) != null) {
			System.out.println(obj);
		}

		input2.close();
	}
}
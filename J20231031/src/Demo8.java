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
			System.out.println("����ȡ���ļ�������");
			return;
		}
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] items = str.split("\\s");
			//�۸�תΪdouble,��ϴ����
			String price = items[1].replaceAll("[��/kg]","").trim();
			Product product = new Product();
			product.setName(items[0]);
			product.setPrice(Double.parseDouble(price));
			product.setType(items[2]);
			product.setInfo(items[3]);
			set.add(product);
		}


		//����HashSet����Ԫ�أ�����ͨ��ObjectOutputStream�洢�ڶ������ļ���
		File nFile = new File("nFile.txt");
		FileOutputStream out = new FileOutputStream(nFile);
		ObjectOutputStream output = new ObjectOutputStream(out);
		for (Product p : set) {
			output.writeObject(p);
		}
		output.writeObject(null);
		output.close();
		System.out.println("�ļ��洢���");
		//��ȡ�������ļ��д洢�Ķ��󣬱Ƚ϶������ļ��д洢�Ķ����Դ�ļ��д洢����ĸ����Ƿ�һ�£�Ϊʲô��
		FileInputStream in = new FileInputStream(nFile);
		ObjectInputStream input2 = new ObjectInputStream(in);
		Object obj;
		while ((obj = input2.readObject()) != null) {
			System.out.println(obj);
		}

		input2.close();
	}
}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Scanner;

public class Demo8 {

	public static void main(String[] args) throws IOException {

		File file=new File("Product.txt");
		Scanner in=new Scanner(file);
		HashSet <Product> set1=new HashSet<Product>();
		while(in.hasNext()) {
			String line=in.nextLine();
			System.out.println(line);
			String[]items=line.split("\t");
			String re="\\D*";
			String pir=items[1].replaceAll(re, "").trim();
//        System.out.println(pir);

			Product pro=new Product(items[0],Double.parseDouble(pir),items[2],items[3]);
			set1.add(pro);

		}
		in.close();


		for(Product p:set1) {
			System.out.println(p);
		}
		File nFile = new File("nProduct.txt");
		FileOutputStream out=new FileOutputStream(nFile);
		ObjectOutputStream out1=new ObjectOutputStream (out);
		for(Product p:set1) {
			out1.writeObject(p);
		}
		FileInputStream input=new  FileInputStream(nFile);
		ObjectInputStream input1=new  ObjectInputStream(input);
		Product pro1 = null;
		while (true) {
			try {
				if (((pro1 = ( Product)(input1.readObject())) != null)) break;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

			System.out.println(pro1);
		}
		out.close();
		out1.close();


	}

}


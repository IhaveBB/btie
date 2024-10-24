/**
 * @name: App
 * @author: IhaveBB
 * @date: 2024-10-24 19:42
 **/
public class App {
	public static void main(String[] args) {
		PrintSystem printSystem = new PrintSystemImpl();
		printSystem.print();
		printSystem.printReport();
	}
}

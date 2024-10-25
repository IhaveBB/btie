package adapter;

/**
 * @name: adapter.App
 * @author: IhaveBB
 * @date: 2024-10-24 19:42
 **/
public class App {
	public static void main(String[] args) {
		PrintStudent printStudent = new PrintStudent();
		PrintSystem printSystem = new PrintSystemAdapter(printStudent);
		printSystem.print();
		printSystem.printReport();
	}
}

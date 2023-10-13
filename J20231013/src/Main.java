import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyLinkedQueue queue = new MyLinkedQueue();

		while (true) {
			System.out.println("请输入操作数（0-取号, 1-叫号, 2-退出）");
			int input = sc.nextInt();
			switch (input) {
				// 取号
				case 0:
					int customerNumber = queue.add();
					System.out.println("您的号码为：" + customerNumber + "，当前您的前面还有 " + queue.size() + " 人");
					break;

				// 叫号
				case 1:
					int nextCustomer = queue.remove();
					if (nextCustomer != -1) {
						System.out.println("请客户" + nextCustomer + "到窗口办理。");
					} else {
						System.out.println("当前没有等待的客户。");
					}
					break;

				// 退出程序
				case 2:
					System.out.println("程序退出");
					return;

				default:
					System.out.println("无效操作，请重新输入。");
			}
		}
	}
}

class MyLinkedQueue {
	class Node {
		private int val;
		private Node next = null;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node rear = null;
	private Node front = null;
	private int count = 0;

	public MyLinkedQueue() {
		rear = front = null;
	}

	public int add() {
		count++;
		Node node = new Node(count);
		if (front == null && rear == null) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		return count;
	}

	public int remove() {
		if (!isEmpty()) {
			int customerNumber = front.val;
			front = front.next;
			if (front == null) {
				rear = null;
			}
			return customerNumber;
		}
		return -1;
	}

	public int size() {
		int size = 0;
		Node current = front;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size-1;
	}


	public boolean isEmpty() {
		return front == null;
	}
}

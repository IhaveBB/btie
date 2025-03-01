/**
 * @name: Customer
 * @author: IhaveBB
 * @date: 2024-11-14 22:30
 **/
public class Customer extends Observer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void update(String eventType, String message) {
		System.out.println(name + " received a notification: " + eventType + " - " + message);
	}
}


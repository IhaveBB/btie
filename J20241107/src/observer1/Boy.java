package observer1;


public class Boy extends Observer {

	@Override
	public void response(CategoryEnum category) {
		System.out.println(getName() + ": 接收到通知: " + category);
	}

}

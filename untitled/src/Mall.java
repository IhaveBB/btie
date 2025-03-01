/**
 * @name: Mall
 * @author: IhaveBB
 * @date: 2024-11-14 22:30
 **/
import java.util.ArrayList;
import java.util.List;

public class Mall extends Subject {
	private List<Observer> observers = new ArrayList<>();
	private String eventType;
	private String message;

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(eventType, message);
		}
	}

	public void newStockArrives(String message) {
		this.eventType = "New Stock Arrives";
		this.message = message;
		notifyObservers();
	}

	public void priceDrop(String message) {
		this.eventType = "Price Drop";
		this.message = message;
		notifyObservers();
	}
}



/**
 * @name: Subject
 * @author: IhaveBB
 * @date: 2024-11-14 22:30
 **/
public abstract class Subject {
	public abstract void addObserver(Observer observer);
	public abstract void removeObserver(Observer observer);
	public abstract void notifyObservers();
}


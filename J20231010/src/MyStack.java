public class MyStack<T> {
	private Object[] stackArray;
	private int maxSize;
	private int top;

	public MyStack(int size) {
		maxSize = size;
		stackArray = new Object[maxSize];
		top = -1;
	}
	public void push(T item) {
		if (top < maxSize - 1) {
			stackArray[++top] = item;
		} else {
			System.out.println("Stack is full. Cannot push " + item);
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T item = (T) stackArray[top];
			top--;
			return item;
		}
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return (T) stackArray[top];
		}
	}

	public int getTop() {
		return top+1;
	}
}

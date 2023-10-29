import java.util.Arrays;

public class MyStack {
    private int[] elem;
    private int usedSize;

    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public void push(int val) {
        //判断有没有满，满了2倍扩容
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }
    //判断有没有满
    public boolean isFull() {
        if(usedSize == elem.length)
        {
            return true;
        }
        return false;
    }

    public int pop() {
        if(isEmpty()){
            throw new EmptyException( "Stack is empty!");
        }
        //保存顶部元素
        int oldVal = elem[usedSize-1];
        //删掉顶部元素
        usedSize--;
        return oldVal;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyException( "Stack is empty!");
        }
        //保存顶部元素
        return elem[usedSize-1];
    }
    private boolean isEmpty() {
        if (usedSize == 0) {
            return true;
        }
        return false;
    }


}

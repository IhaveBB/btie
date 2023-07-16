import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        //如果栈不为空，那么minStack不必计算。只有在栈不为空且当前值小于栈顶元素时才计算minStack
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop(){
        if(!stack.empty()){
            stack.pop();
            if(minStack.peek() == stack.peek()){
                minStack.pop();
            }
        }
    }
    public int top(){
        if(stack.empty()){
            return -1;
        }
        return stack.pop();
    }
    public int getMin(){
        if(minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////


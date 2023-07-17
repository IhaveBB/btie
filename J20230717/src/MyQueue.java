import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int sign = 0;
        if(empty()){
            return -1;
        }
        int length1 = stack1.size();
        int length2 = stack2.size();
        if(!stack1.isEmpty()){
            for(int i = 0;i < length1;i++){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else if(!stack2.isEmpty()){
            for(int i = 0;i < length2;i++){
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }
        return -1;
    }


    public int peek() {
        int sign = 0;
        if(empty()){
            return -1;
        }
        int length1 = stack1.size();
        int length2 = stack2.size();
        if(!stack1.isEmpty()){
            for(int i = 0;i < length1;i++){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        else if(!stack2.isEmpty()){
            for(int i = 0;i < length2;i++){
                stack1.push(stack2.pop());
            }
            return stack1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
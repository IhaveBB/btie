class MyCircularQueue {
    private  int[] elem;
    private int front;
    private int rear;
    public MyCircularQueue(int k){
        this.elem = new int[k+1];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            throw new CircularQueueEmptyException("循环队列为空");
        }
        return elem[front];
    }

    public int Rear() {
        if(isEmpty()){
            throw new CircularQueueEmptyException("循环队列为空");
        }
        int index = (rear == 0)?elem.length-1:rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        if((rear+1)%elem.length == front ){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
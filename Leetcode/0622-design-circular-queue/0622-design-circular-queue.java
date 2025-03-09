class MyCircularQueue {
    int[] queue;
    int empty;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.empty = 0;
        this.front = 0;
        this.rear = 0;
        this.size = k;

        for(int i = 0; i < k; i++) {
            queue[i] = -1;
        }
    }
    
    public boolean enQueue(int value) {
        if(isFull() || queue[empty] != -1) {
            return false;
        }

        queue[empty] = value;
        rear = empty;
        empty = (empty + 1) % size;

        System.out.println("enque-value: " + value + ", front: " + front + ", rear: " + rear + ", empty:" + empty);
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty() || queue[front] == -1) {
            return false;
        }

        queue[front] = -1;
        front = (front + 1) % size;

        System.out.println("deque-front: " + front + ", rear: " + rear + ", empty:" + empty);
        return true;
    }
    
    public int Front() {
        if(isEmpty()) {
            return -1;
        }

        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }

        return queue[rear];
    }
    
    public boolean isEmpty() {
        return queue[rear] == -1;
    }
    
    public boolean isFull() {
        return queue[empty] != -1;
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
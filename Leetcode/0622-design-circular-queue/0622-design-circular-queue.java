class MyCircularQueue {
    int[] queue;
    int front;
    int rear = -1;
    int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }

        this.rear = (this.rear + 1) % this.queue.length;
        this.queue[rear] = value;
        this.size++;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        this.front = (this.front + 1) % this.queue.length;
        this.size--;

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
        return size == 0;
    }
    
    public boolean isFull() {
        return size == this.queue.length;
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
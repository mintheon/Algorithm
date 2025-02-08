class MyCircularQueue {
    int size;
    Deque<Integer> queue = new LinkedList<>();

    public MyCircularQueue(int k) {
        this.size = k;
    }
    
    public boolean enQueue(int value) {
        if(queue.size() >= size) {
            return false;
        }

        queue.offer(value);
        return true;
    }
    
    public boolean deQueue() {
        if(queue.isEmpty()) {
            return false;
        }

        queue.poll();
        return true;
    }
    
    public int Front() {
        if(queue.isEmpty()) {
            return -1;
        }

        return queue.peekFirst();
    }
    
    public int Rear() {
        if(queue.isEmpty()) {
            return -1;
        }

        return queue.peekLast();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public boolean isFull() {
        return queue.size() == size;
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
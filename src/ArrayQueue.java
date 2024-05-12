public class ArrayQueue {
    private int[] queue;
    private int front;
    private int back;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        back = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        back = (back + 1) % capacity;
        queue[back] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }
}

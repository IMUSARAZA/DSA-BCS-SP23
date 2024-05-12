public class StackUsingArray {
    private int[] items;
    private int top;

    public StackUsingArray(int capacity) {
        items = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full.");
        }
        items[++top] = item;
    }

    public void print(){

        for(int i=0; i<items.length; i++){
            System.out.println(items[i]);
        }

    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return items[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return items[top];
    }
}

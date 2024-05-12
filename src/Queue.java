// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry


// A class to represent a queue
// The queue, front stores the front node of LL and rear
// stores the last node of LL
class Queue {
    Node front, rear;

    public Queue() { 
        this.front = null;
        this.rear = null;
    }
    
    // Method to add a data to the queue.
    void enqueue(int data)
    {

        // Create a new LL node
        Node temp = new Node(data);

        // If queue is empty, then new node is front and
        // rear both
        if (this.rear == null) {

            this.front = temp;
            this.rear = temp;

            return;
        }

        // Add the new node at the end of queue and change
        // rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an data from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node
        // ahead
        Node temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as
        // NULL
        if (this.front == null)
            this.rear = null;
    }
}


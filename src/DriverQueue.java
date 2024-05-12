public class DriverQueue {

        public static void main(String[] args)
        {
            Queue q = new Queue();
            q.enqueue(10);
            q.enqueue(20);
            q.dequeue();
            q.dequeue();
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);
            q.dequeue();
            System.out.println("Queue Front : " + ((q.front != null) ? (q.front).data : -1));
            System.out.println("Queue Rear : " + ((q.rear != null) ? (q.rear).data : -1));
        }
    }


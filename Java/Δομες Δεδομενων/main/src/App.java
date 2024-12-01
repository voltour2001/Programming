package main.src;

public class App {
    public static void main(String[] args) {
        DoubleQueueImpl queue = new DoubleQueueImpl();

        // Enqueue elements
        queue.enqueue(1.1);
        queue.enqueue(2.2);
        queue.enqueue(3.3);

        // Print the queue
        queue.printQueue();

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Dequeue elements and print them
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Print the queue after dequeuing
        queue.printQueue();

        // Check the size of the queue
        System.out.println("Queue size: " + queue.size());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

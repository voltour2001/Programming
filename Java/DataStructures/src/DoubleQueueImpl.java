package src;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleQueueImpl {
    
    //* Constructor
    public DoubleQueueImpl(){
        this.head = null;   // First item of the queue
        this.tail = null;   // Last item of the queue
        this.size = 0;  
    }

    private static class Node{
        double data;
        Node next;

        // Constructor
        Node(double data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //* Check if the queue is empty
    public boolean isEmpty(){
        return head == null;
    }

    //* Add an element to the end of the queue
    public void enqueue(double item){
        Node newNode = new Node(item);  // Create new node with the data
        if (isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode; // Pointer assignment to the new node.
        }
        tail = newNode;
        size++;
    }

    //* Remove and return the element from the front of the queue
    public double dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        double dequeuedData = head.data;
        head = head.next;   // Assign the head of the queue to the next item in the queue
        if (head == null) { // If the head is null, the queue is empty
            tail = null;
        }
        size --;
        return dequeuedData;
    }


    //* Return the data of the first element in the queue
    public double peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        return head.data;
    }

    //* Return the size of the queue
    public int size() {
        return size;
    }

    //* Print all the elements of the queue
    public void printQueue() {
        Node current = head;
        System.out.println("Queue contents:");
        while (current != null) {
            System.out.print( "[" + current.data + "]" + ", ");
            current = current.next;
        }
        System.out.println();
    }
}
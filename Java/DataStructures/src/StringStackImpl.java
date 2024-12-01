package src;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack{

    private static class Node{
        String data;
        Node next;

        Node (String data){
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    //* Constructor
    public StringStackImpl(){
        this.top = null;
        this.size = 0;
    }

    public void push(String item){
        Node newNode = new Node(item);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    @Override
    public String pop(){
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        String poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }
    
    @Override
    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printStack(PrintStream out) {
        Node current = top;
        out.println("Stack contents: ");
        while (current != null) {
            out.print("[" + current.data + "], ");
            current = current.next;
        }
        out.println();
    }
    
}
package screencast;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CompositionBasedStack {
    // Core data structure - the basis of the new Stack
    private LinkedList<String> list;

    public CompositionBasedStack(){
        list = new LinkedList<String>();
    }

    // Build the functionality for the new Stack using the methods of the core data structure
    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(String value){
        list.add(0, value);
    }

    public String pop(){
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        return list.remove(0);
    }

    public String peek(){
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot peek from an empty stack.");
        }
        return list.get(0);
    }
}

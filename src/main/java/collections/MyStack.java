package collections;

public class MyStack {
    private Node head;
    private int numElements;

    public MyStack(){

    }

    public int count(){
        // todo: Fill in logic!
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isEmpty(){
        // todo: Fill in logic!
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int pop(){
        // todo: Fill in logic!
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int peek(){
        // todo: Fill in logic!
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void push(int value){
        // todo: Fill in logic!
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private class Node{
        protected int data;
        protected Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}

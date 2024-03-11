package collections;

public class MyStack extends MyLinkedList {
    public MyStack(){

    }

    public int count(){
        return size();
    }

    public boolean isEmpty(){
        return super.size() == 0;
    }

    public int pop(){
        return remove(0);
    }

    public int peek(){
        return get(0);
    }

    public void push(int value){
        addToStart(value);
    }
    
    @Override
    public int get(int pos){
        throw new UnsupportedOperationException("Getting from a specific position is not available in a Stack");
    }
}

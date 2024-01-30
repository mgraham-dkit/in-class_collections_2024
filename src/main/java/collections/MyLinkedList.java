package collections;

public class MyLinkedList {
    private Node head;
    private int numElements;

    public MyLinkedList(){
        head = null;
        numElements = 0;
    }

    public int size(){
        return numElements;
    }

    public void add(int num){
        Node newNode = new Node(num);
        if(numElements == 0){
            head = newNode;
        }else{
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        numElements++;
    }
    
    public int indexOf(int num){
        Node current = head;
        for(int i = 0; i < numElements; i++){
            int currentData = current.getData();
            if(currentData == num){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    protected static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }

        public void setData(int data){
            this.data = data;
        }

        public int getData(){
            return this.data;
        }
    }
}

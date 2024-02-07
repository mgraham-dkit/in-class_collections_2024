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

    public void addToStart(int num){
        Node newNode = new Node(num);

        if(head == null){
            head = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        numElements++;
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

    // Get the value from the specified position
    public int get(int pos){
        // Validate position to confirm it's GREATER THAN -1
        // AND LESS THAN number of elements
        if(pos < 0 || pos >= numElements){
            // If validation fails, throw an exception
            throw new IndexOutOfBoundsException("Illegal position supplied: " + pos);
        }

        // Build your representative node - set it to the start of the list:
        Node current = head;
        // for each element from head up to specified position:
        for(int i = 0; i < pos; i++){
            // Move to the next element in the list
            // Set current to next element in list
            current = current.getNext();
        }
        // Now we're at the right position,
        // return the data held here
        return current.getData();
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

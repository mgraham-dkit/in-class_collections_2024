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

    public void add(int value, int pos){
        // Validation

        // Create new Node (newNode) to hold data to be added
        Node newNode = new Node(value);
        // Make current Node and point to head node
        Node current = head;

        // For each node before supplied position
        for(int i = 0; i < pos; i++) {
            // Get next node and set to current (current = current.getNext())
            current = current.getNext();
        }

        // Set current's next to equal newNode
        current.setNext(newNode);
        // Set newNode's next to equal current's next
        newNode.setNext(current.getNext());

        // Increase numElements as we've added to the list
        numElements++;
    }
    
    public int remove(int pos){
        // Validate position

        // Create variable to store data to be removed (value)
        // If the position to be deleted equals 0
            // Set the value to data in head
            // Set head to node AFTER head
        // Else if the position is > 0:
            // Make current Node and point to head node
            // For each node before supplied position
                // Get next node and set to current (current = current.getNext())

            // Set value to data in node to be removed (current.getNext.getData())
            // Set current's next node to the next of the next node
            // i.e. current.setNext(current.getNext().getNext())
            
        // Decrease number of elements in the list
        // Return the deleted value
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

package collections;

public class MyLinkedList {
    private Node head;
    private Node tail;
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
            tail = newNode;
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
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        numElements++;
    }

    public void add(int value, int pos){
        // Validation
        // NEED TO HANDLE ADDING TO THE START OF THE LIST
        // If position to be added is 0
        if(pos == 0){
            // Use addToStart method to add to the start of the list
            addToStart(value);
        } else if (pos == numElements) {
            add(value);
        }else {
            // Create new Node (newNode) to hold data to be added
            Node newNode = new Node(value);
            // Make current Node and point to head node
            Node current = head;

            // For each node before supplied position
            for (int i = 0; i < pos; i++) {
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
    }
    
    public int remove(int pos){
        // Validate position

        // Create variable to store data to be removed (value)
        int removed;
        // If the position to be deleted equals 0
        if(pos == 0){
            // Set the value to data in head
            removed = head.getData();
            // Set head to node AFTER head
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        }
        // Check if position is length - 1
        else {
            // Make current Node and point to head node
            Node current = head;
            // For each node before supplied position
            for(int i = 0; i < pos-1; i++) {
                // Get next node and set to current (current = current.getNext())
                current = current.getNext();
            }
            
            // Set value to data in node to be removed (current.getNext.getData())
            removed = current.getNext().getData();
            // Check if next element is tail
            if (current.getNext() == tail)
            {
                tail = current;
            }
            // Set current's next node to the next of the next node
            // i.e. current.setNext(current.getNext().getNext())
            current.setNext(current.getNext().getNext());
        }
        // Decrease number of elements in the list
        numElements--;
        // Return the deleted value
        return removed;
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

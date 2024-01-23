package collections;

public class MyArrayList {

    private int [] data;
    private int num_elements;
    private final int capacity;

    public MyArrayList(int capacity){
        this.capacity = capacity;
        data = new int[capacity];
    }

    public MyArrayList(){
        capacity = 10;
        data = new int[capacity];
    }

    public int size(){
        return num_elements;
    }

    public void add(int num){
        if(num_elements == data.length){
            grow();
        }

        data[num_elements] = num;
        num_elements++;
    }

    // Grow
    // create new array with X extra slots
    // loop through original array and copy to new array
    // Replace the original array with the new one
    private void grow(){
        int [] tempArray = new int[data.length + 10];
        for(int i = 0; i < data.length; i++){
            tempArray[i] = data[i];
        }

        data = tempArray;
    }
}

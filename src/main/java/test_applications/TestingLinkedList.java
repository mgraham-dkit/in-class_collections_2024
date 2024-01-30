package test_applications;

import collections.MyArrayList;
import collections.MyLinkedList;

public class TestingLinkedList {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        for(int i = 0; i < 11; i++){
            myList.add(i);
        }

        System.out.println("Current size of list is: " + myList.size());
    }
}

package test_applications;

import collections.MyLinkedList;

public class TestingLinkedList {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        for(int i = 0; i < 11; i++){
            myList.add(i);
        }

        System.out.println("Current size of list is: " + myList.size());
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }

        System.out.println("Adding to the start of the list:");
        myList.addToStart(100);
        System.out.println("Current size of list is: " + myList.size());
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }

        MyLinkedList newList = new MyLinkedList();
        newList.addToStart(5);
        System.out.println("Current size of (new) list is: " + newList.size());
        for(int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i));
        }
    }
}

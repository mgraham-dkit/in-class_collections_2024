package test_applications;

import collections.MyArrayList;

public class TestingArrayList {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();
        for(int i = 0; i < 11; i++){
            myList.add(i);
        }

        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }
    }
}

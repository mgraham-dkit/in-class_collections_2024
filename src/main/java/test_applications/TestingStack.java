package test_applications;

import collections.MyStack;

public class TestingStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

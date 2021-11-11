package com.nonstriater.deepinjava.base.collect;

import java.util.Stack;

public class StackDemo {


    public static void main(String[] args){

        Stack<Integer> stack =new Stack();

        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());

    }

}

package com.nonstriater.deepinjava.algo.link;

public class LinkedNode {
    LinkedNode next;
    int value;

    LinkedNode(int v){
        value = v;
    }

    public static void printLink(LinkedNode head){
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}

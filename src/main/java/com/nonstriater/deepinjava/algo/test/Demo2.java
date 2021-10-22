package com.nonstriater.deepinjava.algo.test;

/**
 * 两个单链表 是否相交
 *       1->3->5
 * 8->1->2->3->5
 * 思路：快慢指针, 先N步
 */
public class Demo2 {
    static class LinkedNode{
        LinkedNode next;
        int value;
    }

    boolean linkJoin(LinkedNode link1, LinkedNode link2){

        LinkedNode tail1 = link1;
        LinkedNode tail2 = link2;
        while (tail1.next != null) {
            tail1 =tail1.next;
        }

        while (link2.next != null) {
            tail2 =tail2.next;
        }

        return tail1 == tail2;
    }

}













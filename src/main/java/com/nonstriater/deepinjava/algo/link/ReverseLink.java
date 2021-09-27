package com.nonstriater.deepinjava.algo.link;

/**
 * 翻转链表
 * 1. 翻转整个链表
 * 2. 翻转链表的前 n 个节点
 * 3. 翻转链表的部分区间 [m,n]
 */
public class ReverseLink {

    public static void main(String[] args){

        test2();

    }


    static void test1(){
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedNode head = reverse(node1);

        LinkedNode forword = head;
        while (forword != null) {
            System.out.println(forword.value);
            forword = forword.next;
        }
    }

    static void test2(){
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        LinkedNode head = reverseN(node1, 2);

        LinkedNode forword = head;
        while (forword != null) {
            System.out.println(forword.value);
            forword = forword.next;
        }
    }


    static class LinkedNode {
        LinkedNode next;
        int value;

        LinkedNode(int v){
            value = v;
        }
    }

    /**
     * 翻转整个链表
     * 递归思路
     * @param head
     */
    public static LinkedNode reverse(LinkedNode head){
        if (head.next == null) {//如果是尾节点，直接返回
            return head;
        }

        LinkedNode tail = reverse(head.next);

        head.next.next = head; //后n-1个节点 与 第 1 个节点 指向 翻转
        head.next = null;

        return tail;
    }

    /**
     * 翻转链表前n个节点
     * @param head
     * @return
     */
    static LinkedNode tmp;//需要一个外部的临时变量
    public static LinkedNode reverseN(LinkedNode head, int n){
        //LinkedNode tmp = null;
        if (n == 1) {
            tmp = head.next;
            return head;
        }

        LinkedNode tail = reverseN(head.next, n-1);

        head.next.next = head; //后n-1个节点 与 第 1 个节点 指向 翻转
        head.next = tmp;

        return tail;
    }

    /**
     * 翻转链表区间 [m,n] 节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static LinkedNode reversePart(LinkedNode head, int m, int n){

        // base case ：
        if (m == 1) {
            return reverseN(head, n);
        }

        // 前进到反转的起点触发 base case
        head.next = reversePart(head.next, m - 1, n - 1);
        return head;

    }

}

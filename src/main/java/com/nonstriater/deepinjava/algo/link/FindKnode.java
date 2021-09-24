package com.nonstriater.deepinjava.algo.link;

/**
 * 链表寻找倒数第k个节点
 */
public class FindKnode {

    static class LinkedNode {
        LinkedNode next;
        int value;

        LinkedNode(int v){
            value = v;
        }
    }

    public static void main(String[] args){

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(findKnode(node1, 6));
        System.out.println(findKnode(node1, 1));
        System.out.println(findKnode(node1, 2));

    }

    public static int findKnode(LinkedNode head, int k){
        LinkedNode forword = head;

        //
        for (int i = 0; i < k ; i++) {
            if (forword == null) {
                //throw new IllegalStateException("link length less than k");
                return 0;
            }
            forword = forword.next;
        }

        //
        LinkedNode back = head;
        while (forword != null) {
            forword = forword.next;
            back = back.next;
        }

        return back.value;
    }
}

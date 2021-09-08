package com.nonstriater.deepinjava.algo.link;

/**
 * 是否有环
 */
public class LinkCicleDemo {

    public static void main(String[] args){

        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(3);
        LinkNode node3 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        //node3.next = node1;

        System.out.println(hasCycle(node1));

    }

    static class LinkNode{
        LinkNode next;
        int value;

        public LinkNode(int x){
            this.value = x;
            next = null;
        }
    }

    public static boolean hasCycle(LinkNode head) {
        if(head == null) {
            return false;
        }

        LinkNode p = head, q = head;
        while(p.next != null && p.next.next != null && q.next != null) {
            p = p.next.next;
            q = q.next;
            if(p == q) {
                return true;
            }
        }
        return false;
    }
}

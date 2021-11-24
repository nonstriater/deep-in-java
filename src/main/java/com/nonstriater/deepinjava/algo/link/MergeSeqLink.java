package com.nonstriater.deepinjava.algo.link;

/**
 * 合并2个有序链表
 *
 */
public class MergeSeqLink {

    public static void main(String[] args){
        //test1();

        test2();
    }

    public static void test1(){

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        LinkedNode node6 = new LinkedNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        LinkedNode n =  mergeSeqLink(node1, node2);
        LinkedNode.printLink(n);

    }

    public static void test2(){

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        LinkedNode node6 = new LinkedNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        LinkedNode n =  mergeSeqLink2(node1, node2);
        LinkedNode.printLink(n);


    }

    /**
     * 合并2个有序链表
     * @param l1 1-》3 -》5
     * @param l2 2-》4 -》6
     */
    public static LinkedNode mergeSeqLink(LinkedNode l1, LinkedNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        LinkedNode result = new LinkedNode(0);
        LinkedNode tmp = result;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                tmp.next = l1;
                tmp = tmp.next; //tmp 指针前进
                l1 = l1.next ; //l1 前进
            } else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }

        if (l1 != null) {
            tmp.next = l1;
        }

        if (l2 != null) {
            tmp.next = l2;
        }

        return result.next;
    }

    /**
     * 合并2个有序链表， 递归实现
     * @param l1
     * @param l2
     */
    public static LinkedNode mergeSeqLink2(LinkedNode l1, LinkedNode l2){

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.value < l2.value){
            l1.next = mergeSeqLink2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeSeqLink2(l2.next,l1);
            return l2;
        }
    }


    /**
     * mt
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public LinkedNode mergeTwoLists (LinkedNode l1, LinkedNode l2) {

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        //两个都不为空
        LinkedNode head = null;
        if(l1.value < l2.value){
            head = l1;
        } else {
            head = l2;
        }
        LinkedNode tail = head;

        //大小比较
        while(l1 != null || l2 != null) {

            if(l1.value < l2.value) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        //追加剩余的
        if(l1 == null){
            tail.next = l2;
        }

        if(l2 == null) {
            tail.next = l1;
        }

        return head;
    }

}

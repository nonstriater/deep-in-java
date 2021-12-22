package com.nonstriater.deepinjava.algo.link;

import java.util.PriorityQueue;

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
     * 合并K个有序链表
     * 思路0：两两合并， 时间复杂度 k2 * n
     * 思路1：分治的方式， 合并 前一半  + 后一半 ， 使用二分法； 时间复杂度 kn * logN
     * 思路2：priority Queue(优先队列)
     * 复杂度： k*logN
     * @return
     */
    public static LinkedNode mergeKSeqLink(LinkedNode[] lists, int l, int r){

        //
        if (l == r) {
            return lists[l];//?
        }

        int mid = (r-l)/2 + l;
        LinkedNode l1 = mergeKSeqLink(lists, l, mid);
        LinkedNode l2 = mergeKSeqLink(lists, mid, r);
        return mergeSeqLink(l1,l2);

    }

    /**
     * 优先级队列实现； 时间复杂度（KN * logK）， 空间复杂读 O(K)
     * 思路：
     * 1 将 k 个链表的头结点加入最小堆
     * 2 获取最小节点，接到结果链表中; 然后将最小节点的next 节点，加入堆   复杂度 （logK）
     * 3 重复2 (复杂度 K*N)
     * @param lists
     * @return
     */
    public static LinkedNode mergeKLinks(LinkedNode[] lists){
        if (lists == null || lists.length == 0) {
            return null;
        }

        LinkedNode ret = new LinkedNode(-1);
        LinkedNode p = ret; //p 指针不断前进

        //PriorityQueue(int initialCapacity,Comparator<? super E> comparator)
        PriorityQueue<LinkedNode> pq =  new PriorityQueue<>(
                lists.length, (a, b) -> (a.value - b.value));

        //将 k 个链表的头结点加入最小堆
        for (LinkedNode head : lists) {
            if (head != null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            LinkedNode head =   pq.poll();
            p.next = head;

            if (head.next != null) {
                pq.add(head.next);
            }

            p = p.next;

        }

        return  ret.next;
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

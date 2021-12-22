package com.nonstriater.deepinjava.algo.test;


import java.util.List;

/**
 *  k个 合并有序链表
 *  尽可能低复杂度
 */
public class Demo4 {

    public class LinkedNode {
        LinkedNode next;
        int value;

        LinkedNode(int v){
            value = v;
        }

        public void printLink(LinkedNode head){
            while (head != null){
                System.out.println(head.value);
                head = head.next;
            }
        }
    }

    /**
     * k个 , 复杂度 O(K*N)
     * @param links
     * @return
     */
    public LinkedNode mergeKLink(List<LinkedNode> links){
        if (links == null || links.size() == 0) {
            return null;
        }

        if (links.size() == 1) {
            return links.get(0);
        }

        LinkedNode ret = mergeLink(links.get(0) , links.get(1));
        for (int i = 2; i < links.size(); i++) {
            ret =  mergeLink(ret, links.get(i));
        }

        return  ret;
    }


    /**
     * 2个有序链表合并 O(N)
     * @param l1
     * @param l2
     * @return
     */
    public LinkedNode mergeLink(LinkedNode l1, LinkedNode l2){

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.value > l2.value) {
            l2.next = mergeLink(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeLink(l1.next, l2);
            return l1;
        }
    }

}

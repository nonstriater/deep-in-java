package com.nonstriater.deepinjava.algo.link;

import com.nonstriater.deepinjava.algo.test.Demo2;

/**
 * 找出两个链表的第一个公共结点
 * 有没有可能一遍遍历就解决问题呢？
 * 让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
 * 空间复杂度为 O(1)，时间复杂度为 O(N), 一遍遍历就搞定
 *
 * 类似问题： 两个链表 是否 相交
 */
public class ShareNode {

    public static void main(String[] args){

        test1();

    }

    static void test1(){

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        LinkedNode node6 = new LinkedNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node4.next = node5;
        node5.next = node6;

        LinkedNode n =  firstParent(node1, node4);
        System.out.println(n.value);

    }

    public static LinkedNode firstParent(LinkedNode l1, LinkedNode l2){
        LinkedNode p1 = l1;
        LinkedNode p2 = l2;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = l2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = l1;
            } else {
                p2 = p2.next;
            }
        }

        return p1;

    }


    /**
     * 两个链表 是否 相交;  直接判断节点最后指针是否一样就可以了
     * 链表是否有环， 这个才使用快慢指针
     * @param l1
     * @param l2
     * @return
     */
    public static boolean isCross(LinkedNode l1, LinkedNode l2){

        LinkedNode tail1 = l1;
        LinkedNode tail2 = l2;
        while (tail1.next != null) {
            tail1 =tail1.next;
        }

        while (tail2.next != null) {
            tail2 =tail2.next;
        }

        return tail1 == tail2;
    }
}

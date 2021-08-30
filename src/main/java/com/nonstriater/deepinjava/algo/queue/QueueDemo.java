package com.nonstriater.deepinjava.algo.queue;

/**
 * 队列， 实现一个poll/offer, take/put ,  push/pop
 * poll 头节点取一个元素
 */
public class QueueDemo {

    public static void main(String[] args){

    }

    private static class Node {
        private int value;
        Node next;
    }

    private static class Queue {
        Node head;
        Node tail;
        int size; //队列长度

        public Queue (){

        }

        /**
         * 取头结点
         * @return
         */
        public int poll(){
            if (head == null) {
                return 0;
            }

            head = head.next;
            return head.value;
        }

        /**
         * 尾部追加
         * @param value
         */
        public void offer(int value){
            Node node = new Node();
            node.value = value;

            tail = node;

            if (head == null) {
                head = node;
            }
        }
    }
}

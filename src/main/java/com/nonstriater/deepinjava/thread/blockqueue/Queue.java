package com.nonstriater.deepinjava.thread.blockqueue;

import java.util.concurrent.*;

//阻塞队列
public class Queue {

//    LinkedBlockingDeque
//    LinkedTransferQueue
//    SynchronousQueue
//    DelayQueue
//    PriorityBlockingQueue
//    LinkedBlockingQueue
//    ArrayBlockingQueue

    public static void main(String[] args){
        try {
            test1();
        } catch (Exception e) {

        }


    }

    private static void test1() throws InterruptedException {
        ArrayBlockingQueue queue = new  ArrayBlockingQueue<String>(10);
        queue.add("hello");
        queue.put("world");
        System.out.println("test1:" + queue.take());
        queue.clear();
    }

    private static void test2(){
        LinkedBlockingQueue queue = new  LinkedBlockingQueue<String>(10);
        queue.add("hello");
        queue.clear();
    }

}

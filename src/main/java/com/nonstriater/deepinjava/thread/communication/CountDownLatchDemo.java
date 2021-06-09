package com.nonstriater.deepinjava.thread.communication;

import java.util.concurrent.CountDownLatch;

/**
 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同时运行的
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    static void print(String threadName){
        System.out.println( threadName + " work");
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            final String threadName = "thread" + String.valueOf(i);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    print(threadName);
                    countDownLatch.countDown();
                }
            });
            t.start();

        }

        countDownLatch.await();

        System.out.println("last thread work");

    }

}

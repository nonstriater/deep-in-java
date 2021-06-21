package com.nonstriater.deepinjava.thread.communication;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {

    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for (int i = 0; i < 30; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        num++;//自加操作
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();

        //前面计算完以后才开始下一步操作
        System.out.println(num);
    }
}

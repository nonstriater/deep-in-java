package com.thread.volati;

import java.util.concurrent.CountDownLatch;

/**
 * volatile 并不能保证对象的原子性
 * 执行结果： 173298，131502 各种各样都有
 */
public class MyVolatile3 {
    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                    for(int j=0;j<10000;j++){
                        num++;//自加操作， 因为num++不是个原子性的操作
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }
}

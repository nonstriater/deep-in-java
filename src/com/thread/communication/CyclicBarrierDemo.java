package com.thread.communication;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程 A B C 各自开始准备，直到三者都准备完毕 (reach a common barrier point) ，然后再同时运行
 */
public class CyclicBarrierDemo {

    static CyclicBarrier cyclicBarrier = new  CyclicBarrier(3);

    static void print(String threadName) throws InterruptedException, BrokenBarrierException {
        System.out.println(threadName + " work...");

        Random random = new Random();
        long prepareTime = random.nextInt(10000) + 100;
        Thread.sleep(prepareTime);
        System.out.printf(threadName + "work %d ms\n", prepareTime);

        cyclicBarrier.await();
        System.out.println("all prepare work done, all thread start work again");
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i < 3; i++) {
            final String threadName = "thread" + String.valueOf(i);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        print(threadName);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();


        }

    }

}

package com.nonstriater.deepinjava.thread.communication.threeThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadAtomicInteger {

    /**
     * 通过 lock 确保只有1个线程能修改 state 变量
     * 通过state的值来确定是哪个线程打印
     * state%3 == 0 线程A打印
     * state%3 == 1 线程B打印
     * state%3 == 2 线程C打印
     *
     * AtomicInteger 即可以用来计数，又可以保证线程安全
     */
    private AtomicInteger ai = new AtomicInteger(0);

    //
    private static final int MAX_SYC_VALUE = 3 * 10;

    private class RunnableA implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE-1) {
                if (ai.get() % 3 == 0) {
                    System.out.print("A");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1) {
                    System.out.print("B");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2) {
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }

        }
    }


    public static void main(String[] args) {
        ThreeThreadAtomicInteger atomic_ABC = new ThreeThreadAtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(atomic_ABC.new RunnableA());
        service.execute(atomic_ABC.new RunnableB());
        service.execute(atomic_ABC.new RunnableC());

        //会等添加的task执行完后，才结束
        service.shutdown();
    }

}

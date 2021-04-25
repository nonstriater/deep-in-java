package com.thread.communication;

/**
 * 让 两个线程按照指定方式有序交叉运行
 * 比如 A线程 在打印完 1 后，再让 B线程 打印 1, 2, 3 ， 然后A线程再打印 2, 3
 * 为什么 main 线程没有先退出，而能等到 AB 线程执行完
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("A 1");
                        lock.wait();
                        System.out.println("A 2");
                        System.out.println("A 3");
                    } catch (Exception e) {

                    }
                }
            }
        });
        A.start();

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("B 1");
                        System.out.println("B 2");
                        System.out.println("B 3");
                        lock.notify();
                    } catch (Exception e) {

                    }
                }
            }
        });
        B.start();
    }

}

/**
 *
 * 如果B先拿到锁，执行完毕。再到A，那就不会有线程去唤醒A了，A就会一直被挂起
 *
 */
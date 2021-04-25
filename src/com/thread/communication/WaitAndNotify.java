package com.thread.communication;

/**
 * 让 两个线程按照指定方式有序交叉运行
 * 比如 A线程 在打印完 1 后，再让 B线程 打印 1, 2, 3 ， 然后A线程再打印 2, 3
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A 1");
                    wait();
                    System.out.println("A 2");
                    System.out.println("A 3");
                }catch (Exception e) {

                }
            }
        });
        A.start();

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    notify();
                }catch (Exception e) {

                }
            }
        });
        B.start();
    }

}

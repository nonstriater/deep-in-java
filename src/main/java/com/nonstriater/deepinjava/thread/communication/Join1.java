package com.nonstriater.deepinjava.thread.communication;

/**
 * 如何让两个线程依次执行？一个是线程 A，另一个是线程 B，两个线程分别依次打印 1-3 三个数字即可
 */
public class Join1 {

    static public void printA() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println("A" + i);
            Thread.sleep(1*1000);
        }
    }

    static public void printB() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println("B" + i);
            Thread.sleep(1*1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printA();
                }catch (Exception e) {

                }
            }
        });
        A.start();
        A.join();

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printB();
                }catch (Exception e) {

                }
            }
        });
        B.start();
    }



}

package com.nonstriater.deepinjava.thread.interrupt;

public class InterruptDemo2 {

    public static void main(String[] args)  throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }

    static class HelloThread extends Thread {
        public volatile boolean running = true;
        public void run() {
            int n = 0;
            while (running) {
                n ++;
                System.out.println(n + " hello!");
            }
            System.out.println("end!");
        }
    }
}

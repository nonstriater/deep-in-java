package com.nonstriater.deepinjava.thread.interrupt;

public class InterruptDemo1 {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();

        Thread.sleep(1); // 暂停1毫秒, 不释放锁

        t.interrupt(); // 中断t线程，发起中断请求
        t.join(); // 等待t线程结束 ， 且让main进入等待状态
        System.out.println("end");
    }


    static class MyThread extends Thread {
        public void run() {
            int n = 0;
            while (! isInterrupted()) {
                n ++;
                System.out.println(n + " hello!");
            }
            System.out.println("MyThread Interrupted!");
        }
    }
}

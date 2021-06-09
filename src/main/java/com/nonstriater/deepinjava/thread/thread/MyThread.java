package com.nonstriater.deepinjava.thread.thread;

public class MyThread extends Thread{

    public void run() {
        System.out.println("MyThread.run()");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread.run() after sleep");
    }

    public static void main(String[] args){
        MyThread thread = new MyThread();
        thread.start();
    }

}

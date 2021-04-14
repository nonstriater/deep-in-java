package com.thread.thread;

public class MyThread extends Thread{

    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args){
        MyThread thread = new MyThread();
        thread.start();
    }

}

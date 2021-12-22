package com.nonstriater.deepinjava.thread.daemon;

public class DaemonDemo {

    public static void main(String[] args) {
        Thread t = new Thread(DaemonDemo::print);
        t.setDaemon(false);//非守护线程
        //t.setDaemon(true);//守护线程
        t.start();
        System.out.println("Exiting main  method");
    }

    //由于这个程序有一个非守护线程，JVM将继续运行应用程序，即使在main()方法完成后
    public static void print() {
        int counter = 1;
        while (true) {
            try {
                System.out.println("Counter:" + counter++);
                Thread.sleep(1000); // sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

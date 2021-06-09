package com.nonstriater.deepinjava.thread.volati;

//volatile 关键字
public class MyVolatile implements Runnable {

    private volatile boolean flags = false;

    @Override
    public void run() {
        while (!flags) {
        }
        System.out.println("thread exit.");
    }

    public void setFlags(boolean flags) {
        this.flags = flags;
    }

    public static void main(String[] args) throws InterruptedException {

        MyVolatile myVolatile = new MyVolatile();
        Thread thread1 = new Thread(myVolatile);
        thread1.start();

        Thread.sleep(2*1000);

        myVolatile.setFlags(true); //不加volatile时，并不会先thread1线程退出
    }
}

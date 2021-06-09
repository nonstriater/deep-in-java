package com.nonstriater.deepinjava.thread.volati;

/**
 * volatile 并不能保证对象的原子性
 * VolatileTest2  例子在我的电脑上 100% 跑出来 结果 100000， 奇怪，没有验证到结果
 */
public class MyVolatile2 implements Runnable {

    private volatile int i = 0;
    @Override
    public void run() {
        for (int j=0;j<1000;j++) {
            i++;
        }
    }
    public int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        MyVolatile2 v2 = new MyVolatile2();
        for (int i=0;i<100;i++){
            new Thread(v2).start();
        }
        Thread.sleep(5000);
        System.out.println(v2.getI());
    }

}

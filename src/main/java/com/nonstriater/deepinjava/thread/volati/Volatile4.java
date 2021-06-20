package com.nonstriater.deepinjava.thread.volati;

/**
 * volatile 并不能保证对象的原子性
 * Volatile4  例子在我的电脑上 100% 跑出来 结果 20,000， 奇怪，没有验证到结果
 */
public class Volatile4 {

    private static volatile int race = 0;

    public static void incrI() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyVolatile2 v2 = new MyVolatile2();
        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<200;i++)
                    incrI();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(race);
    }

}

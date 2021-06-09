package com.nonstriater.deepinjava.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest2 {

    private static AtomicInteger index = new AtomicInteger(10);
    static AtomicStampedReference<Integer> stampRef
            = new AtomicStampedReference(10, 1);
    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = stampRef.getStamp();
            System.out.println(Thread.currentThread().getName()
                    + " 第1次版本号： " + stamp);
            stampRef.compareAndSet(10, 11,stampRef.getStamp(),stampRef.getStamp()+1);
            System.out.println(Thread.currentThread().getName()
                    + " 第2次版本号： " + stampRef.getStamp());
            stampRef.compareAndSet(11, 10,stampRef.getStamp(),stampRef.getStamp()+1);
            System.out.println(Thread.currentThread().getName()
                    + " 第3次版本号： " + stampRef.getStamp());
        },"张三").start();

        new Thread(() -> {
            try {
                int stamp = stampRef.getStamp();
                System.out.println(Thread.currentThread().getName()
                        + " 第1次版本号： " + stamp);
                TimeUnit.SECONDS.sleep(2);
                boolean isSuccess =stampRef.compareAndSet(10, 12,
                        stampRef.getStamp(),stampRef.getStamp()+1);
                System.out.println(Thread.currentThread().getName()
                        + " 修改是否成功： "+ isSuccess+" 当前版本 ：" + stampRef.getStamp());
                System.out.println(Thread.currentThread().getName()
                        + " 当前实际值： " + stampRef.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"李四").start();
    }
}

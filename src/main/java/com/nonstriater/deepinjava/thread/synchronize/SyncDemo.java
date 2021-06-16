package com.nonstriater.deepinjava.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class SyncDemo {

    public void method() {
        synchronized (this) { //用于代码块, 传入对象
            System.out.println("Method 1 start");
            System.out.println(ClassLayout.parseInstance(this).toPrintable());
        }
    }

    public static void main(String[] args){
        SyncDemo sd = new SyncDemo();
        System.out.println(ClassLayout.parseInstance(sd).toPrintable());
        sd.method();
        System.out.println(ClassLayout.parseInstance(sd).toPrintable());
    }
}

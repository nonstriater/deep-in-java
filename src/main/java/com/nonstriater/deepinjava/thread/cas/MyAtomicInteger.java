package com.nonstriater.deepinjava.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger extends Object{

    public static void main(String[] args){

        AtomicInteger ai = new AtomicInteger(3);
        System.out.println(ai.compareAndSet(3,5));
        System.out.println(ai.compareAndSet(60,7));
    }

}

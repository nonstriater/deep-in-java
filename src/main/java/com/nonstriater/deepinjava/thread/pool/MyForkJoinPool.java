package com.nonstriater.deepinjava.thread.pool;

import java.util.concurrent.ForkJoinPool;

public class MyForkJoinPool {

    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool(10);
        pool.submit(() -> {
            System.out.println("hello, forkjooinpool");
        }).join();
    }




}

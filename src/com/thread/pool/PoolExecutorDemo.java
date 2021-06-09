package com.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolExecutorDemo {

    public static void main(String[] args) {
        int coreSize = 1;
        int maxSize = 10;

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,
                10,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                null,
                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }
}

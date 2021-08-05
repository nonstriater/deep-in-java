package com.nonstriater.deepinjava.thread.thread;

import com.nonstriater.deepinjava.thread.deadlock.ThreadA;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::cal);
        cf.thenAccept( (result) -> {
           System.out.println("CompletableFutureDemo :" + result);
        });

        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        Thread.sleep(2000);
    }

    public static String cal(){
        return "hello";
    }
}

package com.nonstriater.deepinjava.thread.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo2::getId);

        CompletableFuture<String> cf2 = cf.thenApplyAsync( (score) -> {
            return calInfo(score);
        });

        cf2.thenAccept( (result) -> {
            System.out.println("CompletableFutureDemo :" + result);
        });


        cf2.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        Thread.sleep(2000);
    }

    public static String calInfo(double id){
        return "100:" + id;
    }

    public static double getId(){
        return 2;
    }
}

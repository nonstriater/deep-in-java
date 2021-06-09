package com.nonstriater.deepinjava.thread.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> call =  new CallableImpl();
        //FutureTask是一个实现Runnable接口的类
        FutureTask<String> futureTask = new FutureTask<>(call);

        //新建一个线程运行 task 任务
        new Thread(futureTask).start();
        String result = futureTask.get(); //阻塞

        System.out.println("result=" + result);
    }

}

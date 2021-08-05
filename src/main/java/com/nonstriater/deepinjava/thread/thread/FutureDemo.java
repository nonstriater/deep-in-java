package com.nonstriater.deepinjava.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    static class CallableImpl implements Callable<String> {
        private String str;

        public CallableImpl(String str) {
            this.str = str;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return this.str + " append some chars and return it";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callable = new CallableImpl("test1");
        FutureTask<String> task = new FutureTask<>(callable); //定义一个 futureTask

        Long beginTime = System.currentTimeMillis();

        new Thread(task).start(); // 新建一个线程，运行 futureTask 任务
        String result = task.get();  //获得Callable任务返回的Object； 方法会阻塞，一直等到任务完毕才返回

        Long endTime = System.currentTimeMillis();
        System.out.println("hello," + result);
        System.out.println("cast:" + (endTime-beginTime)/1000);
    }


}

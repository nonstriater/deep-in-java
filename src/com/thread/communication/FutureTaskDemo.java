package com.thread.communication;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 子线程完成某件任务后，把得到的结果回传给主线程
 */
public class FutureTaskDemo {

    static class CalTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int result = 0;
            for (int i=0; i<=100; i++) {
                result += i;
            }
            return result;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(new CalTask());
        new Thread(task).start();
        Integer result = task.get();
        System.out.println(result);
    }
}

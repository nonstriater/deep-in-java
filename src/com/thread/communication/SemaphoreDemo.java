package com.thread.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 10个线程 读取文件数据(或者 kafka topic数据)
 * 3个线程写入数据库，数据库的连接只有3个
 */
public class SemaphoreDemo {

    /* 读取文件数据的线程数量,并创建此容量的线程池 */
    private static final int THREAD_COUNT = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    /* 创建Semaphore对象实例，构造函数的参数指定信号量的数目，为了方便说明问题，设为3 */
    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args){

        /* 创建线程读取数据，并尝试获取数据库连接，将数据存储到数据库中 */
        for(int i = 0;i < THREAD_COUNT;i++){
            final int index = i;

            Runnable task = new Runnable() {
                public void run() {
                    try {
                        /*从远程读数据*/
                        System.out.println("thread-"+ index + " is reading data from remote host");

                        /* 通过acquire 函数获取数据库连接，如果成功将数据存储到数据库 */
                        semaphore.acquire();
                        System.out.println("thread-"+ index + " is saving data....");
                        /*模拟存储数据耗时*/
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {

                        /* 最终使用release 函数释放信号量 */
                        semaphore.release();
                    }
                }
            };
            executorService.execute(task);
        }

        System.out.println("done");
    }

}

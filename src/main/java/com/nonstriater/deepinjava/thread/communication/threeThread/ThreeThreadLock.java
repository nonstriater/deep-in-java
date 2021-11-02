package com.nonstriater.deepinjava.thread.communication.threeThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadLock {

    private static Lock lock=new ReentrantLock();

    /**
     * 通过 lock 确保只有1个线程能修改 state 变量
     * 通过state的值来确定是哪个线程打印
     * state%3 == 0 线程A打印
     * state%3 == 1 线程B打印
     * state%3 == 2 线程C打印
     */
    private static int state=0;//

    static class ThreadA extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==0){// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;//执行一次以后，就会释放锁
                        i++;//统计执行次数
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}

package com.nonstriater.deepinjava.thread.deadlock;

public class DeadlockCase {
    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void  main(String[] args) {
        ThreadA a = new ThreadA();
        new Thread(a).start();

        ThreadB b = new ThreadB();
        new Thread(b).start();

        System.out.println("deadlock happen, will not print this line");
    }
}


/**
 Mon Jun 21 21:36:09 CST 2021 LockA 开始执行
 Mon Jun 21 21:36:09 CST 2021 LockB 开始执行
 Mon Jun 21 21:36:09 CST 2021 LockA 锁住 obj1
 Mon Jun 21 21:36:09 CST 2021 LockB 锁住 obj2
 */
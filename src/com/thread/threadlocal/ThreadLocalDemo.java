package com.thread.threadlocal;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for(int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for(int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();

    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {

        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };

    }
}

/**
* Thread name:thread - 3 , ThreadLocal hashcode:698320319, Instance hashcode:660107004, Value:0
 * Thread name:thread - 2 , ThreadLocal hashcode:698320319, Instance hashcode:25036449, Value:0
 * Thread name:thread - 1 , ThreadLocal hashcode:698320319, Instance hashcode:678493627, Value:0
 * Thread name:thread - 2 , ThreadLocal hashcode:698320319, Instance hashcode:25036449, Value:01
 * Thread name:thread - 3 , ThreadLocal hashcode:698320319, Instance hashcode:660107004, Value:01
 * Thread name:thread - 2 , ThreadLocal hashcode:698320319, Instance hashcode:25036449, Value:012
 * Thread name:thread - 1 , ThreadLocal hashcode:698320319, Instance hashcode:678493627, Value:01
 * Thread name:thread - 2 , ThreadLocal hashcode:698320319, Instance hashcode:25036449, Value:0123
 * Thread name:thread - 3 , ThreadLocal hashcode:698320319, Instance hashcode:660107004, Value:012
 * Set, Thread name:thread - 2 , ThreadLocal hashcode:698320319,  Instance hashcode:263846142, Value:hello world
 * Thread name:thread - 1 , ThreadLocal hashcode:698320319, Instance hashcode:678493627, Value:012
 * Thread name:thread - 3 , ThreadLocal hashcode:698320319, Instance hashcode:660107004, Value:0123
 * Thread name:thread - 1 , ThreadLocal hashcode:698320319, Instance hashcode:678493627, Value:0123
 * Set, Thread name:thread - 3 , ThreadLocal hashcode:698320319,  Instance hashcode:369587118, Value:hello world
 * Set, Thread name:thread - 1 , ThreadLocal hashcode:698320319,  Instance hashcode:649529029, Value:hello world
*
* */
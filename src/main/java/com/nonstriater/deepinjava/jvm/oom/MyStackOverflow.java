package com.nonstriater.deepinjava.jvm.oom;

/**
 * VM args: -Xss256k， 循环调用
 *
 * stack leng = 1972
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class MyStackOverflow {

    private int stackLen = 1;

    public void stackLeak(){
        stackLen++;
        stackLeak();
    }

    public static void main(String[] args) {

        MyStackOverflow so = new MyStackOverflow();
        try {
            so.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack leng = " + so.stackLen);
            throw e;
        }

    }
}

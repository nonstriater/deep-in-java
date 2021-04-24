package com.jvm.oom;

/**
 * 线程太多导致OOM
 * vm args: -Xss2m
 * 造成机器卡死
 */
public class StackOOM {

    private void dontStop(){
        while (true) {}
    }

    private void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args){

        StackOOM oom = new StackOOM();
        oom.stackLeakByThread();

    }

}

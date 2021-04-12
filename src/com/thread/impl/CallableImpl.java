package com.thread.impl;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello, callable";
    }
}

package com.nonstriater.deepinjava.designpattern.builder.singleton;

public class MySingleton {

    private volatile static MySingleton instance = null;

    private MySingleton() {

    }

    public static MySingleton getInstance() {
        if(instance==null) { // 1
            synchronized (MySingleton.class) {
                if(instance==null)
                    instance = new MySingleton();  //2
            }
        }
        return instance;
    }
}

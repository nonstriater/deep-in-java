package com.nonstriater.deepinjava.jvm.init;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        // 下面语句仅仅是加载Tester类
        cl.loadClass("com.nonstriater.deepinjava.jvm.init.InitDemo");
        System.out.println("系统加载Tester类");

        // 下面语句才会初始化Tester类 , static块代码才会执行
        Class.forName("com.nonstriater.deepinjava.jvm.init.InitDemo");
    }
}

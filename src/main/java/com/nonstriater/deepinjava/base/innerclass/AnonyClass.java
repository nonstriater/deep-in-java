package com.nonstriater.deepinjava.base.innerclass;

//匿名内部类实现回调功能，常见的如 Runnable 接口创建线程
public class AnonyClass {

    public void test(InnerInterfaceDemo demo){
        System.out.println("hello, anony class");
    }

    public static void main(String[] args){
        final String title =  "title1";
        AnonyClass ac = new AnonyClass();

    }
}

package com.nonstriater.deepinjava.innerclass;

public class StaticClass {
    int age = 10;
    static int age2 = 20;
    public StaticClass() {
    }

    static class Inner {
        public void method() {
            //System.out.println(age);//错误. 静态内部类只能访问静态的外部属性和方法
            System.out.println(age2);//正确
        }
    }
}


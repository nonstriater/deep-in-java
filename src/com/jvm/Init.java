package com.jvm;

class A{
    //1
    static int s = 100;
    //2
    static {
        System.out.println("A staic block");
    }

    //4
    {
        System.out.println("A block");
    }

    //5
    public A(){
        System.out.println("A constructor");
    }
}
class B extends A {
    //3
    static {
        System.out.println("B staic block");
    }

    //6
    {
        System.out.println("B block");
    }

    //7
    public B(){
        System.out.println("B constructor");
    }
}

/**
 * 探究初始化过程:  静态变量>静态块 优先级最高(从父类到子类) -> 非静态代码块>构造函数 （从父类到子类）
 */
public class Init {

    public static void main(String[] args) {
        System.out.println("main hello");
        B b = new B();
    }
}

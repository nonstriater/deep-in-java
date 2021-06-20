package com.nonstriater.deepinjava.jvm.clazz;

public class ClassFileTest {

    public static int s = 5;

    private int i ;

    public int incr(){
        return i+1;
    }

    public static void main(String[] args){
        ClassFileTest t = new ClassFileTest();
        System.out.println(t.incr());
    }
}

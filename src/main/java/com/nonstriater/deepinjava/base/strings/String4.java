package com.nonstriater.deepinjava.base.strings;

public class String4 {

    public static void main(String[] args){

        test1();

        test2();

    }

    //这里会创建3个对象 ： 1个常量池 + 2 个堆对象
    private static void test1(){
        //首先String a = new String("a");会去找一下常量池里面有没有“a”这个字面量
        //发现没有，就会在常量池创建一个
        //然后再再堆上创建一个对象，返回堆上对象的引用
        String a = new String("a");


        //这里String b = new String(“a");同样会去找一下常量池里面有没有“a”这个字面量
        //发现存在了，则不会创建了
        //然后还是会再堆上创建一个对象，并返回一个堆上对象的引用
        String b = new String("a");

        System.out.println(a==b);//false
        System.out.println(a.equals(b));//true

    }

    private static void test2(){

        String a = new String("a");
        String b = new String("a");

        //这里intern返回的就是常量池里面的引用
        System.out.println(a.intern() == b.intern());//true
    }


    // intern()
    private static void test3(){
        String a = new String("a");
        String b = new String("a");

        //这里intern返回的就是常量池里面的引用
        System.out.println(a.intern() == b.intern());//true
    }

}

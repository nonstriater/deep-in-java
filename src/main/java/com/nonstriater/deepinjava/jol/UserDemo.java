package com.nonstriater.deepinjava.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class UserDemo {

    private String name;//4字节
    private double score;//8字节
    private int age;//4字节
    private char c;
    private long l;
    private boolean sex;//1字节

    private static void testVMInfo(){
        System.out.println(VM.current().details());
    }

    private static void testUserObject(){
        UserDemo ol = new UserDemo();
        ol.name = "nonstriater";

        System.out.println(ClassLayout.parseInstance(ol).toPrintable());
    }

    private static void testUserClass(){

        System.out.println(ClassLayout.parseClass(UserDemo.class).toPrintable());
    }

    private static void testObject(){
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
    }

    /**
     * 看数组大小布局
     */
    private static void testArray(){
        char [] charArray = new char[2];
        System.out.println(ClassLayout.parseInstance(charArray).toPrintable());
    }

    private static void testString(){
        String str = "hello,world";
        System.out.println(ClassLayout.parseInstance(str).toPrintable());
    }

    private static void testStringClass(){
        System.out.println(ClassLayout.parseClass(String.class).toPrintable());
    }

    private static void testHashMap(){
        HashMap hm = new LinkedHashMap();
        hm.put("key1", "v2");
        System.out.println(GraphLayout.parseInstance(hm).toPrintable());
    }

    public static void main(String[] args){
        testVMInfo();
        testUserObject();
        testUserClass();

        testObject();
        testArray();

        testString();
        testStringClass();

        testHashMap();
    }



}



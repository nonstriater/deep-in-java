package com.nonstriater.deepinjava.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class UserDemo {

    private String name;
    private Integer age;
    private boolean sex;

    private static void test1(){
        System.out.println(VM.current().details());
    }

    private static void test2(){
        UserDemo ol = new UserDemo();
        ol.name = "nonstriater";

        System.out.println(ClassLayout.parseInstance(ol).toPrintable());
    }

    private static void test3(){

        System.out.println(ClassLayout.parseClass(UserDemo.class).toPrintable());
    }

    public static void main(String[] args){
//        test1();
        test3();
    }



}



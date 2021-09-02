package com.nonstriater.deepinjava.base.exception;

public class ExceptionDemo {
    public static void main(String[] args){
        System.out.println("hi");
        test1();
    }

    private static void test1(){
        try {

        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }

}

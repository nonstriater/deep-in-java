package com.nonstriater.deepinjava.base.lambda;

import java.util.Optional;

public class OptianalDemo {

    static private class User {

    }

    public static void main(String[] args){
        //test1();
        test2();
    }

    private static void test1(){

        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();

    }

    private static void test2(){

        Optional<String> emptyOpt = Optional.ofNullable("hello");
        System.out.println(emptyOpt.get());

    }

}

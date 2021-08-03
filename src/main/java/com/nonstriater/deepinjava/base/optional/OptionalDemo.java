package com.nonstriater.deepinjava.base.optional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args){
        test1();

    }

    private static void test1(){

        List<Integer> list = new LinkedList<>(Arrays.asList());

        Integer i =  Optional.ofNullable(list.get(0)).orElse(10);//IndexOutOfBoundsException
        System.out.println(i);
    }

}

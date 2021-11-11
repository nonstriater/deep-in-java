package com.nonstriater.deepinjava.base.collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MySet {

    public static void main(String[] args) {

        {
            Set<String> s= new HashSet<>(Arrays.asList("1","2"));
            System.out.println(s.contains("2"));
        }

        {
            Set<String> s= new HashSet<>(Arrays.asList("1","2"));
            Set<String> newS = s.stream().filter(x -> x.equals("3")).collect(Collectors.toSet());
            System.out.println(s);
            System.out.println(newS);
        }


    }


}

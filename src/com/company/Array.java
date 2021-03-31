package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Array {

    public static void main(String[] args){

        {
            List<String> ids = Arrays.asList("1","2","3");
            List<String> newIds = ids.stream().filter(x -> !x.equals("2")).collect(Collectors.toList());
            System.out.println(ids);
            System.out.println(newIds);
        }

        {
            List<String> ids = new LinkedList<>(Arrays.asList("1","2","3")) ;
            List<String> newIds = ids.stream().filter(x -> ! x.equals("2")).collect(Collectors.toList());
            System.out.println(ids);
            System.out.println(newIds);
        }

    }


}

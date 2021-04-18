package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Array {

    public static void main(String[] args){

        {
            List<String> ids = new ArrayList<>(10);
            System.out.println(ids.size()); //有个 private int size 变量标记容量大小
            ids.add("1");
            ids.add("4");
            ids.add("7");
            ids.add(2,"hi");//先 拿这里的 index（3） 与 size 比较，超过就抛异常
            System.out.println(ids);
        }

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

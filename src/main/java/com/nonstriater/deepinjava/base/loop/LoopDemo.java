package com.nonstriater.deepinjava.base.loop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LoopDemo {

    public static void main(String[] args){

        List<String> rtaids = new LinkedList<>(Arrays.asList("hi", "hello", "world"));

        rtaids.forEach(item -> {

            if (item.equals("hello")) {
                return;
            }

            System.out.println("print:" + item);
        });

    }

}

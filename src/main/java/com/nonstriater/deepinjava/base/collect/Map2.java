package com.nonstriater.deepinjava.base.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Map2 {

    private static HashMap<Long, Integer> eveModelConfig = new LinkedHashMap<>();

    static {
        eveModelConfig.put(111l, 3001);
        eveModelConfig.put(222l, 3002);
        eveModelConfig.put(22222l, 3002);
    }

    public static void main(String []args){

        System.out.println(eveModelConfig.containsKey(111)); //false
        System.out.println(eveModelConfig.containsKey(Long.valueOf(111))); //true

        System.out.println(eveModelConfig.containsKey(111l)); //true
        System.out.println(eveModelConfig.containsKey(22222l)); //true
        System.out.println(eveModelConfig.containsKey(22222)); //false

        System.out.println(eveModelConfig.containsKey(123)); //false


    }

}
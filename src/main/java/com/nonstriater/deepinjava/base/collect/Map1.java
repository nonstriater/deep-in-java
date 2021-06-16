package com.nonstriater.deepinjava.base.collect;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Map1 {

    public static void main(String[] args) {

        Map<String, String> m = new HashMap<>();
        m.put("k1", "v1");

        Map<String, String> ht = new Hashtable<>();

        Map<String, String> lhm = new LinkedHashMap<>();

        //线程安全
        Map<String, String> chp = new ConcurrentHashMap<>();
        chp.put("c1", "v1");

    }
}

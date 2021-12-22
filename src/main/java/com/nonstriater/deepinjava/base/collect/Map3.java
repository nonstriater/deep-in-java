package com.nonstriater.deepinjava.base.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map3 {

    public static void main(String []args){

        {
            Map map = new LinkedHashMap();
            map.put("f_123", 1);

            map.compute("f_123", (k, integer)-> {
                if (integer == null) {
                    return 1;
                }
                return 0;
            });

        }
    }
}

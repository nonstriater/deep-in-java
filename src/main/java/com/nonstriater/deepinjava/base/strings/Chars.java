package com.nonstriater.deepinjava.base.strings;

import java.util.HashMap;

//字符串 char[] 处理， 算法题中常用
public class Chars {

    public static void  main(String[] args) {

        {
            String str = "nonstriater";
            char[] chars = str.toCharArray();

            chars.toString();
        }


        {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('a', 1);
            map.put('b', 3);

            map.put('c', map.getOrDefault('c', 0) + 1);

            System.out.println(map);
        }

    }

}

package com.nonstriater.deepinjava.base.collect;

import java.util.Vector;

public class SafeArray {
    public static void main(String[] args){

        Vector v = new Vector();
        v.add("1");
        v.add("4");
        v.add("9");
        v.remove(2);
        System.out.println(v);
    }
}

package com.nonstriater.deepinjava.base.strings;

/**
 * StringBuffer VS StringBuilder
 */
public class String1 {

    //StringBuffer  线程安全 syn
    //StringBuilder

    StringBuffer sb = new StringBuffer("hello"); //线程安全  synchronized
    StringBuilder stringBuilder = new StringBuilder("s builder");
}

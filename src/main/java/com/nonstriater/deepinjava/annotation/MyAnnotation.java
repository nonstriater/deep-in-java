package com.nonstriater.deepinjava.annotation;

import java.lang.annotation.*;

// 定义一个注解
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation{
    String name();
    String website() default "hello";
    int revision() default 1;
}
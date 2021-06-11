package com.nonstriater.deepinjava.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {

    private static Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args){
        logger.info("hello");
    }

}

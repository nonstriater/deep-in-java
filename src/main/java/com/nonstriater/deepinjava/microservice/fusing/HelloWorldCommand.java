package com.nonstriater.deepinjava.microservice.fusing;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 使用命令模式封装依赖逻辑
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private final String name;

    public HelloWorldCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("hello@example"));
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "exeucute Falled";
    }

    @Override
    protected String run() throws Exception {
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }

    //调用实例
    public static void main(String[] args) throws Exception{
        //每个Command对象只能调用一次,不可以重复调用

        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("sync-hystrix");
        String result = helloWorldCommand.execute();
        System.out.println("result=" + result);

        //异步调用,可自由控制获取结果时机
        helloWorldCommand = new HelloWorldCommand("async-hystrix");
        Future<String> future = helloWorldCommand.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);

        System.out.println("result=" + result);
        System.out.println("mainThread=" + Thread.currentThread().getName());
    }


}

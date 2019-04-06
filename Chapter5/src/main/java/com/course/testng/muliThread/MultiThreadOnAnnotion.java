package com.course.testng.muliThread;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 10)
    //invocationCount 线程数  threadPoolSize 线程池数
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}

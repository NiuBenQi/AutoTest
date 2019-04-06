package com.course.testng.muliThread;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
public class MultThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}

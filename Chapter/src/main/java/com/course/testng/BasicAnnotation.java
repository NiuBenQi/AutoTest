package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod测试方法之后运行的");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @AfterClass
    public void AfterClass  (){
        System.out.println("AfterClass  ");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass     ");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite    ");
    }
}

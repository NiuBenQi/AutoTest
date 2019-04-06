package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by Administrator on 2019/4/6.
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suite 运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("aftersuite 运行了");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("aftertest");
    }
}

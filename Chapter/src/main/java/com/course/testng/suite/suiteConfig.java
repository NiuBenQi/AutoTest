package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class suiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suite 运行了");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("after suite 运行了");
    }
}

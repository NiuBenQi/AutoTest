package com.course.testng.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PayTest {


    @Test
    public void pay(){
        System.out.println("淘宝支付成功");
    }
}

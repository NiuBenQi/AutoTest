package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
public class ExpectedException {
    /*
        什么时候回用到异常测试
        比如：我们传入了某些不合法的参数 程序跑出异常
     */
    //这是一个会失败的测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runException(){
        System.out.println("这是一个异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runExceptionSuccess(){
        System.out.println("这是一个异常测试");
        throw new RuntimeException();

    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runExceptionSuccess2(){
        System.out.println("这是一个异常测试2");
        throw new RuntimeException();
    }
}

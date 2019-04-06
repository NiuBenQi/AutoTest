package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");
    }
    @Test(enabled = false) // 忽略测试
    public void ignore2(){
        System.out.println("ignore2 执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行");
    }
}

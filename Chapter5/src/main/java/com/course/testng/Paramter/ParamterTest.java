package com.course.testng.Paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
public class ParamterTest {
    @Test
    @Parameters({"name","age"})
    public void paramTest(String name,int age){
        System.out.println("name="+name+";age="+age);
    }
}

package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/4/6.
 */
@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("GroupsOnClass1中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass1中的stu2运行");
    }
}

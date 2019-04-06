

import org.testng.annotations.*;

/**
 * Created by Administrator on 2019/4/6.
 */
public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }
//    @Test
//    public void testCase2(){
//        System.out.println("这是测试用例2");
//    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BEforemethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Aftermethod这是在测试方法之后运行的");
    }


    @BeforeClass
    public void  beforeClass(){
        System.out.println("beforeClass这是在类运行之前的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之前的方法");
    }

    @BeforeSuite
    public void beaforeSuite(){
        System.out.println("BeforeSuite这是在类运行之前的套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite这是在类运行之前的套件");
    }

    @BeforeTest
    public void beaforeTest(){
        System.out.println("beaforeTest这是在类运行之前的套件");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest这是在类运行之前的套件");
    }
}

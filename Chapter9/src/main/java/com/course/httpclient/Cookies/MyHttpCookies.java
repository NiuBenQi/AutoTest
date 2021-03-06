package com.course.httpclient.Cookies;

import org.apache.http.HttpResponse;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2019/4/7.
 */
public class MyHttpCookies {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    //加载配置文件
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        // 配置文件中 拼接测试 rul
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;

        // 测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        // 获取cookie信息
         this.store = client.getCookieStore();
        List<Cookie> cookieList = this.store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name
                    +";  cookie value = "+value);
        }
    }

    // 依赖 testGetCookies
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(get);

        //获取响应状态码
        int statusCode  = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+statusCode);

        if (statusCode == 200){
           String result= EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }


}

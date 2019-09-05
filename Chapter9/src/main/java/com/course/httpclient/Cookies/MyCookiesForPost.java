package com.course.httpclient.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2019/4/7.
 */
public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

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
        this.store=  client.getCookieStore();
        List<Cookie> cookieList = this.store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name
                    +"cookie value = "+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethods() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;

        // 声明一个Client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("sex","man");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象，来进行相应结果的存储
        String result;

        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取相应结果
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //处理结果，就是判断返回结果是否符合预期

        //将返回的响应结果字符串转化成为json对象
        JSONObject resultjson = new JSONObject(result);

        //获取到结果值
        String success = resultjson.get("huhansan").toString();
        String status =  resultjson.get("status").toString();
        //具体的判断返回结果的值
//        System.out.println(success+status);
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }

}

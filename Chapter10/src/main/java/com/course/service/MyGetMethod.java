package com.course.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        return "恭喜获得cookies信息";
    }


    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "必须携带cookies信息";
        }
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜访问成功";
            }
        }

        return "必须携带cookies信息";
    }


    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式   url: key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){

        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",2);
        myList.put("衬衫",300);
        return myList;
    }

    /**
     *
     * 第二种实现方式   url: ip:port/get/with/param/10/20
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",2);
        myList.put("衬衫",300);
        return myList;
    }



}
















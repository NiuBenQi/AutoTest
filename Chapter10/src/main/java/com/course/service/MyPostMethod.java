package com.course.service;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "這是我全部的post請求")
@RequestMapping("/v1")
public class MyPostMethod {

    //這個變量是用來裝cookies信息
    private static Cookie cookie;

    //用戶登錄成功獲取到cookies，然後再訪問其他接口獲取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登錄接口，成功後獲取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value="userName",required = true) String userName,
                        @RequestParam(value="password",required = true) String password){
        if (userName.equals("zhangsan") && password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登錄成功了！";

        }
        return "用戶名或密碼錯誤！";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user = new User();
        //获取cookies
        Cookie [] cookies = request.getCookies();
        //验证cookies是否合法
        for(Cookie c : cookies){
            if(c.getName().equals("login") && c.getValue().equals("true") && u.getUserName().equals("zhangsan")&& u.getPasswork().equals("123456")){
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }

}

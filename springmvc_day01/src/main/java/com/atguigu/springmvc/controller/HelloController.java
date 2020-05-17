package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ouyangjie
 * @createTime 2020-02-26 15:17
 */
@Controller
@RequestMapping("/user")
public class HelloController {
//    请求映射
    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String say(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
//path和value一样都可以省略不写
    //METHOD改为post以后405提示方法不允许
    @RequestMapping(value = "/testMethod",method = {RequestMethod.POST,RequestMethod.GET})
    public String testMethod(){
        System.out.println("Hello method");
        return "success";
    }
    /*@params
    不带参数会400，有些是params={"username=hehe"}要求key和value必须一模一样不然也是400
    * */
    @RequestMapping(value = "/testParam",params = {"username"},headers = {"Accept"})
    public String testParam(){
        System.out.println("Hello param");
        return "success";
    }
    //动态参数版的
    @RequestMapping(value = "/testParam1")
    public String testParam1(String username,String password){
        System.out.println("Hello param");
        System.out.println("用户名："+username);
        System.out.println("密码: "+password);
        return "success";
    }

//    日期2010/2/27通过
    @RequestMapping(value = "/save")
    public String save(User user){
        System.out.println("Hello"+user.getName());
        System.out.println("用户名："+user.getName());
        System.out.println(user.toString());
        return "success";
    }

    //    日期2010/2/27通过
    @RequestMapping(value = "/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Hello"+request.getQueryString());
        System.out.println("路径："+request.getServletPath());
        System.out.println("地址："+request.getRequestURI());
        System.out.println(response.getCharacterEncoding());
        return "success";
    }
}

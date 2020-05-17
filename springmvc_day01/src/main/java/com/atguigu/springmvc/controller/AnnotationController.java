package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

/**
 * @author ouyangjie
 * @createTime 2020-02-27 16:40
 */
@RequestMapping("/anno")
@Controller
@SessionAttributes(value = {"msg"})
public class AnnotationController {
//@RequestMapping(params = {"username"},headers = {"Accept"})
    //@RequestParam:把请求中指定名称的形参给控制器的形参赋值
    @RequestMapping(value = "/testParam")
    public String testParam(@RequestParam(name = "username") String name){
        System.out.println("Hello param");
        System.out.println(name);
        return "success";
    }

    //@RequestBody：用于获取请求头内容，不适用get请求，得到key=value&key=value的键值对
   @RequestMapping(value = "/testResponseBody")
    public String testResponseBody( @RequestBody String name){
        System.out.println("Hello param");
        try {
            name=URLDecoder.decode(name,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        return "success";
    }

    //PathVariable:用于绑定url的占位符比如user/edit/{id}，{id}就是url占位符，
    //是springmvc支持rest风格的重要标志
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable( @PathVariable(name = "id") String id){
        System.out.println("Hello param");
        System.out.println(id);
        return "success";
    }

    //@RequestHeader:获取请求头信息，实际开发一般不用
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader( @RequestHeader(value = "Accept") String header){
        System.out.println("Hello header");
        System.out.println(header);
        return "success";
    }

    //@CookieValue:用于指定cookie名称的值传入控制器方法参数
    @RequestMapping("/testCookieValue")
    public String testCookieValue( @CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("Hello cookie");
        System.out.println(cookieValue);
        return "success";
    }


    @RequestMapping("/testModelAttribute1")
    public String testModelAttribute(User user){
        System.out.println(user.toString());
        System.out.println("Hello testModelAttribute1");
        return "success";
    }

    //@ModelAttribute表示当前方法比控制器先执行，用于不能修改的表单提交
    //还是原来数据库数据不是null
    //ModelAttribute一共两种写法第一种有返回值的
    @ModelAttribute
    public User show(String name){
        //模拟查询数据库
        User user=new User();
        user.setName(name);
        user.setAge(22);
        user.setDate(new Date());
        user.setSex(true);
        System.out.println("这个注解先执行:第一种有返回值的写法");
        return user;
    }

    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("xiaoou") User user){
        System.out.println(user.toString());
        System.out.println("Hello testModelAttribute2");
        return "success";
    }

    @ModelAttribute
    public void show(String name, Map<String,User> map){
        //模拟查询数据库
        User user=new User();
        user.setName(name);
        user.setAge(22);
        user.setDate(new Date());
        user.setSex(true);
        System.out.println("这个注解先执行，第二种写法");
        map.put("xiaoou",user);
    }

    //@SessionAttributes只能作用在类上面,用于多次执行控制器方法间的参数共享
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model){
        model.addAttribute("msg","欧少");
        System.out.println("Hello testSessionAttribute");
        return "success";
    }

//重启服务以后要先model放进去才可以拿到，不然是null
    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
       String msg= (String) modelMap.get("msg");
        System.out.println(msg);
        System.out.println("getSessionAttribute");
        return "success";
    }


    @RequestMapping("/deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status){
        System.out.println("getSessionStatus");
        status.setComplete();
        return "success";
    }
}

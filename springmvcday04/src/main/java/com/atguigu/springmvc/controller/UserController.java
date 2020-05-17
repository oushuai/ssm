package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ouyangjie
 * @createTime 2020-03-06 16:28
 * 代码快捷键Ctrl+Alt+t 包围代码try等
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("执行testException");

        try {
            int a=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("系统崩溃了。。");
        }
        return "success";
    }


    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor");
        return "success";
    }
}

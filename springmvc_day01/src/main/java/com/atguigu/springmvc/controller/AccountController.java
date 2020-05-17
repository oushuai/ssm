package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ouyangjie
 * @createTime 2020-02-26 21:29
 */
@RequestMapping("/acount")
@Controller
public class AccountController {

    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String testParam1(Account account){
        if(null!=account) {
            System.out.println("Hello!");
            System.out.println(account.toString());
            System.out.println(account.getUser().toString());
            System.out.println("用户名：" + account.getUsername());
            System.out.println("密码: " + account.getPassword());
            return "success";
        }
        return null;
    }
}

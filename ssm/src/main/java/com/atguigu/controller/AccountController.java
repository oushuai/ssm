package com.atguigu.controller;

import com.atguigu.domain.Account;
import com.atguigu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-07 18:28
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层测试成功");
        accountService.save(new Account("xiaoou",10000));

        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "userList";
    }

    @RequestMapping("/save")
    public String save(Account account){
        System.out.println("表现层1测试成功");
        accountService.save(account);

        return "redirect:/account/findAll";
    }
}

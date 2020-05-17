package com.atguigu.service;

import com.atguigu.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void save(Account account);
}

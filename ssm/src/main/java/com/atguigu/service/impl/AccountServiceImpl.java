package com.atguigu.service.impl;

import com.atguigu.dao.AccountDao;
import com.atguigu.domain.Account;
import com.atguigu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-07 18:27
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
//    @Qualifier( "accountDao")
     private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询");
        System.out.println(accountDao);
        List<Account> list=accountDao.findAll();
        return list;
    }

    @Override
    public void save(Account account) {
        System.out.println("业务层保存");
        accountDao.save(account);
    }
}

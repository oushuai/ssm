package com.atguigu.dao;

import com.atguigu.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository("accountDao1")
@Repository
public interface AccountDao {

    //mybtis提供代理对象不需要写实现类

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (name,money) values (#{name},#{money})")
    void save(Account account);
}

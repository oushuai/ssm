package com.itheima.dao;

import com.itheima.domain.Customer;
import com.itheima.domain.CustomerUser;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();

//    查询所有顾客，并且带有用户名称和地址
    List<CustomerUser> findAllCustomer();

    List<Customer> findAllbyLazy();
}



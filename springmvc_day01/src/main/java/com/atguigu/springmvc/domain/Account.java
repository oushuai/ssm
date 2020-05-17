package com.atguigu.springmvc.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author ouyangjie
 * @createTime 2020-02-26 21:23
 */
public class Account implements Serializable {
    private String username;

    private String password;

    private User user;

//    @DateTimeFormat(pattern = "")

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    private Map<String,User> map;

    public List<String> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(List<String> phoneNo) {
        this.phoneNo = phoneNo;
    }

    private List<String> phoneNo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                ", map=" + map +
                ", phoneNo=" + phoneNo +
                ", money=" + money +
                '}';
    }
}

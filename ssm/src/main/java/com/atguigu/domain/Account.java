package com.atguigu.domain;

import java.io.Serializable;

/**
 * @author ouyangjie
 * @createTime 2020-03-07 18:24
 */
public class Account implements Serializable {

    private Integer id;

    private String name;

    private  double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Account( String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
    }
}

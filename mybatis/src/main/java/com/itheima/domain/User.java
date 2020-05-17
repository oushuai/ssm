package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-09 22:15
 */
public class User implements Serializable {
    private Integer id;

    private String username;

    private Date birthday;

    private String address;

    private String sex;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    //一对多关系映射，主表实体应该包含从表实体的集合引用
    private List<Customer> customerList;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", customerList=" + customerList +
                ", roles=" + roles +
                '}';
    }

    public User() {
    }

    public User(String username, Date birthday, String address, String sex) {
        this.username = username;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

package com.atguigu.springmvc.domain;

import java.io.Serializable;

/**
 * @author ouyangjie
 * @createTime 2020-03-02 0:31
 */
public class User implements Serializable {

    //序列号理解成持久化存储？
   private String username;

   private String password;

   private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

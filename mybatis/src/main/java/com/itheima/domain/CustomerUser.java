package com.itheima.domain;

/**
 * @author ouyangjie
 * @createTime 2020-03-19 11:23
 */
public class CustomerUser extends Customer {

    private String username;

    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+"         CustomerUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-21 15:50
 */
public class Role implements Serializable {

    private Integer roleId;

    private String roleName;

    private String detail;

//    多对多的关系映射，一个角色对应多个用户
    private List<User> users;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", detail='" + detail + '\'' +
                ", users=" + users +
                '}';
    }
}

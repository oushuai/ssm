package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    @Select("select * from user")
    List<User> findAllByAnnotation();


    void save(User user);

    int update(User user);

    void delete(Integer userId);
//    包装类只有一个占位符，随便写

    User findById(int userId);
    
    List<User> findByName(String username);

    int count();


    List<User> findByQueryVo(QueryVo vo);

    List<User> findByCondition(User user);

    List<User> findByIds(QueryVo vo);

    List<User> findAllUserAccount();
//@Results()
    List<User> findAllRoleUser();

}

package com.itheima.test;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
//import com.itheima.domain.RoleUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-18 11:36
 */
public class TestRole {

    private InputStream in;

    private SqlSession sqlSession;

    private RoleDao roleDao;

    @Before
    public void init() {
        //加载配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建sessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        sqlSession = factory.openSession();
        //获取代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void TestList() throws Exception {
        List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println(role.toString());
        }
    }

    @Test
    public void TestRoleUserList() throws Exception {
        List<Role> list = roleDao.findAllUserRole();
        for (Role role : list) {
            System.out.println(role.toString());
        }
    }

}

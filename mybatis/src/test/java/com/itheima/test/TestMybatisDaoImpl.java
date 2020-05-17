package com.itheima.test;

import com.itheima.dao.UserDao;
//import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-15 19:30
 */

public class TestMybatisDaoImpl {

    private InputStream in;

    private UserDao userDao;

    @Before
    public  void init(){
        //加载配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建sessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建session对象
      //   userDao=new UserDaoImpl(factory);

    }

    @After
    public void destroy() throws Exception{
        in.close();
    }

    @Test
    public  void TestList() throws Exception{
        List<User> UserList = userDao.findAll();
        for (User user:UserList){
            System.out.println(user.toString());
        }
    }

    @Test
    public  void testSave() throws Exception{
        User user=new User("save userDaoImpl", new Date(System.currentTimeMillis()),"广华居4栋1单元602","男");

        userDao.save(user);

    }

    @Test
    public  void testFindOne() throws Exception{

        User user = userDao.findById(11);
        System.out.println(user);
    }
}

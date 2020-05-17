package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-09 23:02
 */
public class TestUser {

    private InputStream in;

    private SqlSession sqlSession;

    private UserDao userDao;

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
        userDao = sqlSession.getMapper(UserDao.class);
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
        List<User> UserList = userDao.findAllByAnnotation();
        for (User user : UserList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void TestList1() throws Exception {
        List<User> UserList = userDao.findAll();
        for (User user : UserList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void TestSave() {
        User user = new User("save", new Date(System.currentTimeMillis()), "广华居4栋1单元602", "男");
        userDao.save(user);
    }

    //更新操作必须先有这个数据
    @Test
    public void TestUpdate() {
        User user = new User("update", new Date(System.currentTimeMillis()), "广华居4栋1单元602", "男");
        user.setId(5);
        int i = userDao.update(user);
        System.out.println(i);
    }

    @Test
    public void TestDelete() {
        userDao.delete(2);
    }

    @Test
    public void findById() {
        User user = userDao.findById(5);
        System.out.println(user);
    }

    @Test
    public void findByIdTwo() {
        User user = userDao.findByIdtwo(5);
        System.out.println(user);
    }

    @Test
    public void findByName() {
        List<User> users = userDao.findByName("%ve%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void TestCount() {
        int i = userDao.count();
        System.out.println(i);
    }

    @Test
    public void TestSaveAndReturnId() {
        User user = new User("TestSaveAndReturnId", new Date(System.currentTimeMillis()), "广华居4栋1单元602", "男");
        userDao.save(user);
        System.out.println(user);
    }


    @Test
    public void findByQueryVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%ve%");
        vo.setUser(user);
        List<User> users = userDao.findByQueryVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }


    @Test
    public void findByCondition() {
        User user1 = new User();
//        user1.setUsername("");
        user1.setSex("女");
        List<User> users = userDao.findByCondition(user1);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findByIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(15);
        vo.setIds(list);
        List<User> users = userDao.findByIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findAll(){
        List<User> list=userDao.findAllUserAccount();
        for(User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void TestUserRoleList() throws Exception {
        List<User> list = userDao.findAllRoleUser();
        for (User user: list) {
            System.out.println(user.toString());
        }
    }
}

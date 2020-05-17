package com.itheima.test;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.CustomerUser;
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
public class TestCustomer {

    private InputStream in;

    private SqlSession sqlSession;

    private CustomerDao customerDao;

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
        customerDao = sqlSession.getMapper(CustomerDao.class);
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
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void TestCustomerUserList() throws Exception {
        List<CustomerUser> list = customerDao.findAllCustomer();
        for (CustomerUser customerUser : list) {
            System.out.println(customerUser.toString());
        }
    }

//    测试延迟加载

    @Test
    public void testFindAllUserAccount() throws Exception {
        List<Customer> list = customerDao.findAllbyLazy();
//        for (Customer customer : list) {
//            System.out.println(customer.toString());
//        }
    }
}

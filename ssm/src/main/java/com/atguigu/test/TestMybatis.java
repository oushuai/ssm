package com.atguigu.test;

import com.atguigu.dao.AccountDao;
import com.atguigu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-08 12:29
 */
public class TestMybatis {
    @Test
    public void test()  {
        //加载配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建sessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建session对象
        SqlSession session=factory.openSession();
        //获取代理对象
        AccountDao accountDao=session.getMapper(AccountDao.class);
        accountDao.save(new Account("wudi",15000));
        //提交事务
        session.commit();
        List<Account> accountList = accountDao.findAll();
        for (Account account:accountList){
            System.out.println(account.toString());
        }
        session.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

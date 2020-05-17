package com.atguigu.test;

import com.atguigu.controller.AccountController;
import com.atguigu.dao.AccountDao;
import com.atguigu.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ouyangjie
 * @createTime 2020-03-07 18:35
 */
//小技巧：在pom文件里面改scope范围，test-compile
public class TestSpring {

    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //SqlSessionFactoryBean sessionFactoryBean=ctx.getBean(SqlSessionFactoryBean.class);
        AccountDao accountDao=  ctx.getBean(AccountDao.class);
        System.out.println(accountDao);
        AccountServiceImpl accountService = (AccountServiceImpl) ctx.getBean("accountService");
            accountService.findAll();
        ApplicationContext ctx1=new ClassPathXmlApplicationContext("springmvc.xml");
        AccountController controller=ctx1.getBean(AccountController.class);
        System.out.println(controller.getClass());
//        System.out.println(controller.findAll());
    }
}

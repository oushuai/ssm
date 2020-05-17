package com.atguigu.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ouyangjie
 * @createTime 2020-03-06 17:29
 */
public class MyInterceptor implements HandlerInterceptor {

    //controller方法执行前处理
    //return true表示执行下一个拦截器没有执行controller方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理拦截器执行");
        return true;
    }
}

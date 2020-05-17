package com.atguigu.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ouyangjie
 * @createTime 2020-03-06 16:49
 */
public class SysExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException exception=null;
        if(exception instanceof SysException){
            exception=(SysException)e;
        } else {
            e=new SysException("系统正在维护...");
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}

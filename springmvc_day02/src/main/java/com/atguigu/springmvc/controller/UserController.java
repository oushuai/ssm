package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ouyangjie
 * @createTime 2020-03-01 20:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString..");
        User user=new User();
        user.setUsername("xiaoou");
        user.setPassword("123456");
        user.setAge(23);
        model.addAttribute("user",user);
        return "success";
    }

//    请求转发转发一次请求，不用编写项目名称
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid..");
        //1.forward请求一次不走视图解析器，不要写项目名但是要路径
//        try {
//            request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //2.redediect
        try {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.直接进行响应
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;character=UTF-8");
        response.getWriter().print("hello");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView( ){
        ModelAndView mv=new ModelAndView();
        //创建ModelAndView对象
        System.out.println("testModelAndView..");
        User user=new User();
        user.setUsername("死ju");
        user.setPassword("222");
        user.setAge(23);
        //把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user",user);
        //跳转哪个页面
        mv.setViewName("success");
        return mv;
    }


    //转发关键语法
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward..");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    //重定向关键语法
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect..");
        return "redirect:/index.jsp";
    }

    //模拟异步请求
//    @RequestMapping("/testAjax")
//    public void testAjax(@RequestBody String body){
//        System.out.println("testAjax..");
//        System.out.println(body);
//    }

    //使用responseBody注解实现将controller方法返回对象转换为json响应给客户端，springmvc
    //需要引入jackson的三个包
    @RequestMapping("/testAjax")
    public @ResponseBody  User testAjax(@RequestBody User user){
        System.out.println("testAjax..");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象
        System.out.println(user);
        //模拟查询数据库
        user.setAge(23);
        user.setPassword("12345");
        user.setUsername("欧少");
        return user;
    }
}

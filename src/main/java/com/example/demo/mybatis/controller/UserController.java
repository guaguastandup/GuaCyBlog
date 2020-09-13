package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.entity.User;
import com.example.demo.mybatis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
//RequestMapping用来映射请求,指定控制器可以处理的URL请求
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/login")
    public ModelAndView findByUsername(HttpServletRequest request, HttpSession session){
        ModelAndView mv=new ModelAndView();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+" "+password);
        User user = userService.findByUsername(username);
        if(user==null){
            mv.addObject("message","用户名不存在");
            mv.setViewName("login");
            return mv;
        }else if(!user.getPassword().equals(password)){
            mv.addObject("message","密码错误");
            mv.setViewName("login");
            return mv;
        }else{
            mv.addObject("user",user);
            mv.setViewName("showarticle");
            return mv;
        }

    }
    //@GetMapping("/users")
    @RequestMapping("/users")
    public ModelAndView users() {

        List<User> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("users");
        return mv;
    }
}



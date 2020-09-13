package com.example.demo.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 20372 on 2020/9/13.
 */
@RestController
@RequestMapping("")
public class LoginController {
    @RequestMapping("")
    public ModelAndView article() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

}

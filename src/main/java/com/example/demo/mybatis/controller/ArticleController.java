package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.entity.Article;
import com.example.demo.mybatis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 20372 on 2020/9/13.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

   @RequestMapping("/markdown")
    public ModelAndView article() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Markdown");
        return mv;
    }

    @RequestMapping("/showarticle")
    public ModelAndView showarticle() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("showarticle");
        return mv;
    }

    @RequestMapping("/addText")
    public ModelAndView article(HttpServletRequest request, HttpSession session) {

        String content = request.getParameter("content");
        Article article = new Article();
        article.setContent(content);
        articleService.addText(article);
        System.out.print(article);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Markdown");
        return mv;
    }
}

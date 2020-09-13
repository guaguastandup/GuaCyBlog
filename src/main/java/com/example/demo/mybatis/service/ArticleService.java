package com.example.demo.mybatis.service;
import com.example.demo.mybatis.entity.Article;
import java.util.List;

/**
 * Created by 20372 on 2020/9/13.
 */
public interface ArticleService {


    List<Article> getText();


    void addText(Article article);
}

package com.example.demo.mybatis.service.impl;

import com.example.demo.mybatis.entity.Article;
import com.example.demo.mybatis.mapper.ArticleMapper;
import com.example.demo.mybatis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/articleService")
public class ArticleSeviceImpl implements ArticleService{
    private ArticleMapper articleMapper;
    @Autowired
    public void setUserMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> getText() {
        return articleMapper.getText();
    }


    @Override
    public void addText(Article article) {
         articleMapper.addText(article);
    }
}

package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 20372 on 2020/9/13.
 */
@Mapper
public interface ArticleMapper {
    /**
     * 查询文本内容
     * @return
     */
    List<Article> getText();

    /**
     * 添加文本内容
     * @param content
     * @return
     */
    void addText(Article content);
}

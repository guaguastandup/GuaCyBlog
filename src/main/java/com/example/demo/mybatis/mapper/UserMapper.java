package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByUsername(String username);
}

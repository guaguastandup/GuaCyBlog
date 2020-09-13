package com.example.demo.mybatis.service;

import com.example.demo.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
}

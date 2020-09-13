package com.example.demo.mybatis.service.impl;

import com.example.demo.mybatis.entity.User;
import com.example.demo.mybatis.mapper.UserMapper;
import com.example.demo.mybatis.service.UserService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }
}

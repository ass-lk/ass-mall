package com.ass.gmall.user.service.impl;

import com.ass.gmall.user.mapper.UserMapper;
import com.ass.gmall.user.pojo.User;
import com.ass.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.selectAll();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user, String id) {

    }

    @Override
    public void removeUser(String id) {

    }

    @Override
    public User getUser(String id) {
        return null;
    }
}

package com.ass.gmall.user.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.pojo.User;
import com.ass.gmall.service.UserService;
import com.ass.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
    public boolean addUser(User user) {
        int i = userMapper.insert(user);
        return i > 0;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        return i > 0;
    }

    @Override
    public boolean removeUser(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i > 0;
    }

    @Override
    public User getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

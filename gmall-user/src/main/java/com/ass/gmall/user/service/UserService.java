package com.ass.gmall.user.service;

import com.ass.gmall.user.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 列表查询会员信息
     * @return
     */
    List<User> listUsers();

    /**
     * 保存指定用户信息
     * @param user
     */
    void addUser(User user);

    /**
     * 修改指定用户信息
     * @param user
     */
    void updateUser(User user,String id);

    /**
     * 根据id删除指定用户信息
     * @param id
     */
    void removeUser(String id);

    /**
     * 根据id获取指定用户信息
     * @param id
     * @return
     */
    User getUser(String id);


}

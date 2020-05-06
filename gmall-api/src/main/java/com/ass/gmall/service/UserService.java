package com.ass.gmall.service;



import com.ass.gmall.pojo.User;

import java.util.List;

/**
 * 会员抽象管理抽象接口
 */
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
    boolean addUser(User user);

    /**
     * 修改指定用户信息
     * @param user
     */
    boolean updateUser(User user);

    /**
     * 根据id删除指定用户信息
     * @param id
     */
    boolean removeUser(String id);

    /**
     * 根据id获取指定用户信息
     * @param id
     * @return
     */
    User getUser(String id);


}

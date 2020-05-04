package com.ass.gmall.user.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.User;
import com.ass.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") String userId){
        return userService.getUser(userId);
    }

}

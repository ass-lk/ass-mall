package com.ass.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.UserReceiveAddress;
import com.ass.gmall.service.UserReceiveAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userAddress")
public class UserReceiveAddressController {

    @Reference
    private UserReceiveAddressService userReceiveAddressService;

    @GetMapping("/list")
    public List<UserReceiveAddress> listAll(){
        return null;
    }
}

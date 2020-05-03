package com.ass.gmall.user.controller;

import com.ass.gmall.user.pojo.UserReceiveAddress;
import com.ass.gmall.user.service.UserReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userAddress")
public class UserReceiveAddressController {

    @Autowired
    private UserReceiveAddressService userReceiveAddressService;

    @GetMapping("/list")
    public List<UserReceiveAddress> listAll(){
        return null;
    }
}

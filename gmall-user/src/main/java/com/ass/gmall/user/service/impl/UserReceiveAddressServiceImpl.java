package com.ass.gmall.user.service.impl;

import com.ass.gmall.user.mapper.UserReceiveAddressMapper;
import com.ass.gmall.user.pojo.UserReceiveAddress;
import com.ass.gmall.user.service.UserReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReceiveAddressServiceImpl implements UserReceiveAddressService {

    @Autowired
    private UserReceiveAddressMapper userReceiveAddressMapper;

    @Override
    public List<UserReceiveAddress> listAll(String userId) {
        return null;
    }

    @Override
    public void saveAddress(UserReceiveAddress userReceiveAddress, String userId) {

    }

    @Override
    public void deleteAddress(String addressId) {

    }

    @Override
    public void updateAddress(String addressId, UserReceiveAddress userReceiveAddress) {

    }

    @Override
    public UserReceiveAddress getAddress(String addressId) {
        return null;
    }
}

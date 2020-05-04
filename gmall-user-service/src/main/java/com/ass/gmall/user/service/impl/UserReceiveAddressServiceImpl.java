package com.ass.gmall.user.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.pojo.UserReceiveAddress;
import com.ass.gmall.service.UserReceiveAddressService;
import com.ass.gmall.user.mapper.UserReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserReceiveAddressServiceImpl implements UserReceiveAddressService {

    @Autowired
    private UserReceiveAddressMapper userReceiveAddressMapper;

    @Override
    public List<UserReceiveAddress> listAll(String userId) {
        Example example = new Example(UserReceiveAddress.class);
        example.createCriteria().andEqualTo("member_id",userId);
        List<UserReceiveAddress> list = userReceiveAddressMapper.selectByExample(example);
        return list;
    }

    @Override
    public boolean saveAddress(UserReceiveAddress userReceiveAddress, String userId) {
        userReceiveAddress.setMember_id(userId);
        int i = userReceiveAddressMapper.insert(userReceiveAddress);
        return i > 0;
    }

    @Override
    public boolean deleteAddress(String addressId) {
        int i = userReceiveAddressMapper.deleteByPrimaryKey(addressId);
        return i > 0;
    }

    @Override
    public boolean updateAddress(UserReceiveAddress userReceiveAddress) {
        int i = userReceiveAddressMapper.updateByPrimaryKey(userReceiveAddress);
        return i > 0;

    }

    @Override
    public UserReceiveAddress getAddress(String addressId) {
        return userReceiveAddressMapper.selectByPrimaryKey(addressId);
    }
}

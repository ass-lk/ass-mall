package com.ass.gmall.user.service;

import com.ass.gmall.user.pojo.UserReceiveAddress;

import java.util.List;

public interface UserReceiveAddressService {


    /**
     * 根据用户id查询用户的地址列表信息
     * @param userId 用户id
     * @return 地址列表
     */
    List<UserReceiveAddress> listAll(String userId);

    /**
     * 根据用户id保存地址信息
     * @param userReceiveAddress 地址信息
     * @param userId 用户id
     */
    void saveAddress(UserReceiveAddress userReceiveAddress,String userId );

    /**
     * 删除指定地址信息
     * @param addressId 地址id
     */
    void deleteAddress(String addressId);

    /**
     * 修改指定地址信息
     * @param addressId
     * @param userReceiveAddress
     */
    void updateAddress(String addressId,UserReceiveAddress userReceiveAddress);


    /**
     * 获取指定的地址信息
     * @param addressId 地址id
     * @return 地址信息
     */
    UserReceiveAddress getAddress(String addressId);

}

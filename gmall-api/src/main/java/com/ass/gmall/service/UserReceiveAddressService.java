package com.ass.gmall.service;



import com.ass.gmall.pojo.UserReceiveAddress;

import java.util.List;

/**
 * 用户收获地址抽象接口
 */
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
    boolean saveAddress(UserReceiveAddress userReceiveAddress, String userId);

    /**
     * 删除指定地址信息
     * @param addressId 地址id
     */
    boolean deleteAddress(String addressId);

    /**
     * 修改指定地址信息
     * @param userReceiveAddress
     */
    boolean updateAddress(UserReceiveAddress userReceiveAddress);


    /**
     * 获取指定的地址信息
     * @param addressId 地址id
     * @return 地址信息
     */
    UserReceiveAddress getAddress(String addressId);

}

package com.ass.gmall.service;

import com.ass.gmall.pojo.ProductAttrInfo;
import com.ass.gmall.pojo.ProductAttrValue;

import java.util.List;

/**
 * 平台基本属性抽象接口
 */
public interface PmsBaseAttrInfoService {

    /**
     * 根据三级类目id查询对应的商品属性列表信息
     * @param catelog3Id 三级类目id
     * @return 商品属性列表信息
     */
    List<ProductAttrInfo> getAttrInfo(String catelog3Id);

    /**
     * 根据平台查询属性相关信息
     * @param infoId
     * @return
     */
    List<ProductAttrValue> getValue(String infoId);

    /**
     * 新增属性信息
     * @param info
     * @return
     */
    boolean addAttrInfo(ProductAttrInfo info);

    /**
     * 根据id修改指定属性名称
     * @param info
     * @return
     */
    boolean updateAttrInfo(ProductAttrInfo info);

    /**
     * 删除指定属性名
     * @param infoId
     * @return
     */
    boolean removeAttrInfo(String infoId);

    ProductAttrInfo getAttrInfoById(String id);
}

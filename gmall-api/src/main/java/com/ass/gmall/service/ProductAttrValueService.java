package com.ass.gmall.service;

import com.ass.gmall.pojo.ProductAttrValue;

import java.util.List;

public interface ProductAttrValueService {

    /**
     * 根据属性id 查询对应的属性列表
     * @param infoId
     * @return
     */
    List<ProductAttrValue> listAttrValue(String infoId);

    /**
     * 新增value值
     * @param value
     * @return
     */
    boolean addAttrValue(ProductAttrValue value);

    /**
     * 修改指定value值
     * @param value
     * @return
     */
    boolean updateAttrValue(ProductAttrValue value);

    /**
     *  删除指定value值
     * @param valueId
     * @return
     */
    boolean removeAttrValue(String valueId);

    /**
     * 获取指定的value对象
     * @param valueId
     * @return
     */
    ProductAttrValue getValue(String valueId);
}

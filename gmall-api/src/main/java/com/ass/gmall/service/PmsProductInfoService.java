package com.ass.gmall.service;

import com.ass.gmall.pojo.PmsBaseSaleAttr;
import com.ass.gmall.pojo.PmsProductInfo;

import java.util.List;

public interface PmsProductInfoService {

    /**
     * 根据三级类名id查询商品的列表信息
     * @param catalog3Id 三级类目id
     * @return 商品列表
     */
    List<PmsProductInfo> subList(String catalog3Id);

    /**
     * 新增商品
     * @param info
     * @return
     */
    String addSub(PmsProductInfo info);

    /**
     * 修改指定商品信息
     * @param info
     * @return
     */
    String updateSub(PmsProductInfo info);

    /**
     * 根据主键id查询商品信息
     * @param productId
     * @return
     */
    PmsProductInfo getSub(String productId);

    /**
     * 根据主键id删除指定商品信息
     * @param productId
     * @return
     */
    String removeSub(String productId);

    /**
     * 查询基础属性列表
     * @return
     */
    List<PmsBaseSaleAttr> baseSaleAttrList();
}

package com.ass.gmall.service;

import com.ass.gmall.pojo.*;

import java.util.List;

/**
 * 商品sku管理
 */
public interface PmsSkuService {

    /**
     * 保存商品sku信息
     * @param pmsSkuInfo
     * @return
     */
    String saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 根据skuId查询对应的sku信息
     * @param skuId
     * @return
     */
    PmsSkuInfo getSkuInfoById(String skuId) ;

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
}

package com.ass.gmall.service;

import com.ass.gmall.pojo.PmsProductImage;
import com.ass.gmall.pojo.PmsProductSaleAttr;
import com.ass.gmall.pojo.PmsProductSaleAttrValue;

import java.util.List;

/**
 * 商品spu管理
 */
public interface PmsSpuService {

    /**
     * 查询商品销售属性
     * @param spuId
     * @return
     */
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    /**
     * 查询商品图片
     * @param spuId
     * @return
     */
    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId);
}

package com.ass.gmall.manage.mapper;

import com.ass.gmall.pojo.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {

    /**
     * 根据商品id查询对应的sku信息
     * @param productId
     * @return
     */
    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(@Param("productId") String productId);
}

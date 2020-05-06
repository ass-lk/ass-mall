package com.ass.gmall.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * sku信息表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_sku_info")
public class PmsSkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;//主键id

    @Column
    String productId; //商品id

    @Transient
    String spuId;//商品所属于的spuId

    @Column
    BigDecimal price;//商品价格

    @Column
    String skuName;//商品sku名称

    @Column
    BigDecimal weight;//商品的重量

    @Column
    String skuDesc;//商品sku描述

    @Column
    String catalog3Id;//所属三级类型

    @Column
    String skuDefaultImg;//sku的默认图片

    @Transient
    List<PmsSkuImage> skuImageList;//sku图片列表

    @Transient
    List<PmsSkuAttrValue> skuAttrValueList;//sku属性列表

    @Transient
    List<PmsSkuSaleAttrValue> skuSaleAttrValueList;//sku出售属性列表


}

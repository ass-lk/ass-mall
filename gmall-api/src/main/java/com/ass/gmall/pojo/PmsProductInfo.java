package com.ass.gmall.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_product_info")
public class PmsProductInfo implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; //主键id

    @Column
    private String productName; //商品名称

    @Column
    private String description; //商品id

    @Column
    private  String catalog3Id; //所属三级分类id

    @Transient
    private List<PmsProductSaleAttr> spuSaleAttrList; //商品的销售属性列表
    @Transient
    private List<PmsProductImage> spuImageList; //商品图片列表


}



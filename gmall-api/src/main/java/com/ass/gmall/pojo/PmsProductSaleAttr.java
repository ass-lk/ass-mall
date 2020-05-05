package com.ass.gmall.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 商品销售属性表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_product_sale_attr")
public class PmsProductSaleAttr implements Serializable {

    @Id
    @Column
    String id ; //主键id

    @Column
    String productId; //商品id

    @Column
    String saleAttrId;//销售属性id （基本的销售属性)

    @Column
    String saleAttrName; //销售属性名称


    @Transient
    List<PmsProductSaleAttrValue> spuSaleAttrValueList; //销售属性值列表



}

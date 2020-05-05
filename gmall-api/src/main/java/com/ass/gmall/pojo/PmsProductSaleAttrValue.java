package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 商品销售属性值列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_product_sale_attr_value")
public class PmsProductSaleAttrValue implements Serializable {
    @Id
    @Column
    String id ; //主键id

    @Column
    String productId; //商品id

    @Column
    String saleAttrId; //销售属性id 商品对应的销售属性

    @Column
    String saleAttrValueName; //销售属性值名称

    @Transient
    String isChecked; //是否选中

}

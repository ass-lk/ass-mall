package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 商品sku属性表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_sku_attr_value")
public class PmsSkuAttrValue implements Serializable {

    @Id
    @Column
    String id; //主键id

    @Column
    String attrId; //属性id

    @Column
    String valueId; //属性值id

    @Column
    String skuId; //商品skuid


}

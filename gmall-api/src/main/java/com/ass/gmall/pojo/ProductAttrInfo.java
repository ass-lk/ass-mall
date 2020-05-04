package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 属性表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_base_attr_info")
public class ProductAttrInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private String id; //编号
    @Column
    private String attrName; //属性名称
    @Column
    private String catalog3Id;//所属三级类目id
    @Column
    private String isEnabled;//启用：1 停用：0
    @Transient
    List<ProductAttrValue> attrValueList;  //属性列表
}

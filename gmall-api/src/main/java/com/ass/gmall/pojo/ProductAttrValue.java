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
 * 属性值表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_base_attr_value")
public class ProductAttrValue implements Serializable {

    @Id
    @Column
    private String id; //属性编号
    @Column
    private String valueName; //属性值名称
    @Column
    private String attrId;//属性id
    @Column
    private String isEnabled;//启用：1 停用：0 1

    @Transient
    private String urlParam; //路径参数
}

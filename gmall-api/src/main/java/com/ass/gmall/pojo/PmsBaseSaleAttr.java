package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 基础的销售属性表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_base_sale_attr")
public class PmsBaseSaleAttr implements Serializable {

    @Id
    @Column
    String id ; //主键id

    @Column
    String name; //名称

}
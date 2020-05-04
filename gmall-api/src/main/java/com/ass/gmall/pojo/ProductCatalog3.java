package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品类目三级表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_base_catalog3")
public class ProductCatalog3 implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//主键id
    @Column
    private String name;//类目名称
    @Column
    private String catalog2Id;//所属二级类目id
}

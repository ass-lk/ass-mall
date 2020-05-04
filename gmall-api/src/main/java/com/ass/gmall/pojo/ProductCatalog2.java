package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品类目二级表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_base_catalog2")
public class ProductCatalog2 implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//主键id
    @Column
    private String name;//类目名称
    @Column
    private String catalog1Id;//所属一级类目id

    @Transient
    private List<ProductCatalog3> catalog3List;//下属三级类目列表
}

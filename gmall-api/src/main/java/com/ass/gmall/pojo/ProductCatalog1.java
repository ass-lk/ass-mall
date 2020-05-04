package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品一级分类表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_base_catalog1")
public class ProductCatalog1 implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; //主键
    @Column
    private String name;//分类名称

    @Transient
    private List<ProductCatalog2> catalog2s;//二级类目名称
}

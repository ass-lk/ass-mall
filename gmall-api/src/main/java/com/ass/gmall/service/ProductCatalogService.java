package com.ass.gmall.service;

import com.ass.gmall.pojo.ProductCatalog1;
import com.ass.gmall.pojo.ProductCatalog2;
import com.ass.gmall.pojo.ProductCatalog3;

import java.util.List;

public interface ProductCatalogService {

    /**
     * 获取所有一级类目
     * @return 一级类目列表
     */
    List<ProductCatalog1> listCatalog();

    /**
     * 根据一级类目id获取所有的二级类目
     * @param catalog1Id 一级类目id
     * @return 所有二级类目
     */
    List<ProductCatalog2> listCatalog2(String catalog1Id);

    /**
     * 根据二级类目获取所有二级类目列表
     * @param catalog2Id 二级类目id
     * @return 二级类目列表
     */
    List<ProductCatalog3> listCatalog3(String catalog2Id);
}

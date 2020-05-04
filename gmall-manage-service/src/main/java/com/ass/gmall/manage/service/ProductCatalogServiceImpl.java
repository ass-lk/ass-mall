package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.ProductCatalog1Mapper;
import com.ass.gmall.manage.mapper.ProductCatalog2Mapper;
import com.ass.gmall.manage.mapper.ProductCatalog3Mapper;
import com.ass.gmall.pojo.ProductCatalog1;
import com.ass.gmall.pojo.ProductCatalog2;
import com.ass.gmall.pojo.ProductCatalog3;
import com.ass.gmall.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    private ProductCatalog1Mapper productCatalog1Mapper;
    @Autowired
    private ProductCatalog2Mapper productCatalog2Mapper;
    @Autowired
    private ProductCatalog3Mapper productCatalog3Mapper;

    @Override
    public List<ProductCatalog1> listCatalog() {
        return productCatalog1Mapper.selectAll();
    }

    @Override
    public List<ProductCatalog2> listCatalog2(String catalog1Id) {
        Example example = new Example(ProductCatalog2.class);
        example.createCriteria().andEqualTo("catalog1Id", catalog1Id);
        List<ProductCatalog2> productCatalog2s = productCatalog2Mapper.selectByExample(example);
        return productCatalog2s;
    }

    @Override
    public List<ProductCatalog3> listCatalog3(String catalog2Id) {
        Example example = new Example(ProductCatalog3.class);
        example.createCriteria().andEqualTo("catalog2Id", catalog2Id);
        List<ProductCatalog3> productCatalog3s = productCatalog3Mapper.selectByExample(example);
        return productCatalog3s;
    }
}

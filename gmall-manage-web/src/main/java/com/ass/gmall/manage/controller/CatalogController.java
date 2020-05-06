package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.ProductCatalog1;
import com.ass.gmall.pojo.ProductCatalog2;
import com.ass.gmall.pojo.ProductCatalog3;
import com.ass.gmall.service.PmsCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品类目控制器类
 */
@RestController
@RequestMapping("/catalog")
@CrossOrigin //设置跨域处理
public class CatalogController {

    @Reference
    private PmsCatalogService pmsCatalogService;

    @GetMapping("/getCatalog1")
    public List<ProductCatalog1> listCatalog1(){
        return pmsCatalogService.listCatalog();
    }

    @GetMapping("/getCatalog2/{id}")
    public List<ProductCatalog2> listCatalog2(@PathVariable("id") String catalog1Id){
        return pmsCatalogService.listCatalog2(catalog1Id);
    }

    @GetMapping("/getCatalog3/{id}")
    public List<ProductCatalog3> listCatalog3(@PathVariable("id") String catalog2Id){
        return pmsCatalogService.listCatalog3(catalog2Id);
    }
}

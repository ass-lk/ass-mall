package com.ass.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.PmsProductInfo;
import com.ass.gmall.pojo.PmsProductSaleAttrValue;
import com.ass.gmall.pojo.PmsSkuInfo;
import com.ass.gmall.service.PmsProductInfoService;
import com.ass.gmall.service.PmsSkuService;
import com.ass.gmall.service.PmsSpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ItemController {

    @Reference
    private PmsSkuService pmsSkuService;
    @Reference
    private PmsSpuService pmsSpuService;

    @GetMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, ModelMap map){
        PmsSkuInfo skuInfo = pmsSkuService.getSkuInfoById(skuId);
        List<PmsProductSaleAttrValue> list = pmsSpuService.spuSaleAttrListCheckBySku(skuId);
        map.put("skuInfo",skuInfo);
        return "item";
    }
}

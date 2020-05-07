package com.ass.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ass.gmall.pojo.*;
import com.ass.gmall.service.PmsProductInfoService;
import com.ass.gmall.service.PmsSkuService;
import com.ass.gmall.service.PmsSpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Reference
    private PmsSkuService pmsSkuService;
    @Reference
    private PmsSpuService pmsSpuService;

    @GetMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, ModelMap map){
        //sku对象
        PmsSkuInfo pmsSkuInfo = pmsSkuService.getSkuInfoById(skuId);
        //销售属性列表
        List<PmsProductSaleAttr> spuSaleAttrListCheckBySku = pmsSpuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
        //查询当前sku的spu的其它的集合的hash表
        Map<String,String> skuSaleAttrHash = new HashMap<String,String>();
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        for (PmsSkuInfo skuInfo : pmsSkuInfos) {
            String k = "";
            String v = skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|" ;
            }
            skuSaleAttrHash.put(k,v);
        }
        //将sku的销售属性hash表放到页面
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        map.put("skuInfo",pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku",spuSaleAttrListCheckBySku);
        map.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);
        return "item";
    }
}

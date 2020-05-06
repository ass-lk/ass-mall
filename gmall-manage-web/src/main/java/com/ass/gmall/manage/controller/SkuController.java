package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.*;
import com.ass.gmall.service.PmsSkuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class SkuController {

    @Reference
    private PmsSkuService pmsSkuService;

    @PostMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){

        //将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        //处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if(StringUtils.isBlank(skuDefaultImg)){//没有设置,默认设置第一张页面为默认图片
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

        return pmsSkuService.saveSkuInfo(pmsSkuInfo);
    }
}

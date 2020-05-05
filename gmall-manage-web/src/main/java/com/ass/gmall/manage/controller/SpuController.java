package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.manage.utils.PmsUploadUtil;
import com.ass.gmall.pojo.PmsBaseSaleAttr;
import com.ass.gmall.pojo.PmsProductInfo;
import com.ass.gmall.service.PmsProductInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {

    @Reference
    private PmsProductInfoService pmsProductInfoService;

    @GetMapping("/spuList/{catalog3Id}")
    public List<PmsProductInfo> spuList(@PathVariable("catalog3Id") String catalog3Id){
        return pmsProductInfoService.subList(catalog3Id);
    }

    @GetMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        return pmsProductInfoService.baseSaleAttrList();
    }

    @PostMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo info){
        return pmsProductInfoService.addSub(info);
    }

    /**
     * 文件上传的方法
     * @param file
     * @return
     */
    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return null;
        }
        String url = PmsUploadUtil.uploadImage(file);
        return url;
    }
}

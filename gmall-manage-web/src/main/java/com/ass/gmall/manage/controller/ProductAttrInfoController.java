package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.ProductAttrInfo;
import com.ass.gmall.pojo.ProductAttrValue;
import com.ass.gmall.service.ProductAttrInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/attr")
public class ProductAttrInfoController {

    @Reference
    private ProductAttrInfoService productAttrInfoService;

    @GetMapping("/list/{id}")
    public List<ProductAttrInfo> listAttr(@PathVariable("id") String catalog3Id){
        return productAttrInfoService.getAttrInfo(catalog3Id);
    }

    @GetMapping("/listValue/{id}")
    public List<ProductAttrValue> listValue(@PathVariable("id") String infoId){
        return productAttrInfoService.getValue(infoId);
    }

    @GetMapping("/get/{id}")
    public ProductAttrInfo getAttr(@PathVariable("id") String id){
        return productAttrInfoService.getAttrInfoById(id);
    }

    @PostMapping("/addAttr")
    public String addAttr(@RequestBody ProductAttrInfo info){
        boolean b = productAttrInfoService.addAttrInfo(info);
        if(b){
            return "success";
        }
        return "fail";
    }

    @PutMapping("/updateAttr")
    public String updateAttr(@RequestBody ProductAttrInfo info){
        boolean b = productAttrInfoService.updateAttrInfo(info);
        if(b){
            return "success";
        }
        return "fail";
    }

    @DeleteMapping("/removeAttr/{id}")
    public String removeAttr(@PathVariable("id") String attrInfoId){
        boolean b = productAttrInfoService.removeAttrInfo(attrInfoId);
        if(b){
            return "success";
        }
        return "fail";
    }
}

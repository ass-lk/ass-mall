package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.ProductAttrValue;
import com.ass.gmall.service.PmsBaseAttrValueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/attrValue")
public class ProductAttrValueController {


    @Reference
    private PmsBaseAttrValueService pmsBaseAttrValueService;

    @GetMapping("/list/{id}")
    public List<ProductAttrValue> listAttrValue(@PathVariable("id") String infoId){
       return pmsBaseAttrValueService.listAttrValue(infoId);
    }

    @GetMapping("/get/{id}")
    public ProductAttrValue getAttrValue(@PathVariable("id") String valueId){
        return pmsBaseAttrValueService.getValue(valueId);
    }

    @PostMapping("/save")
    public String save(@RequestBody ProductAttrValue productAttrValue){
        boolean b = pmsBaseAttrValueService.addAttrValue(productAttrValue);
        if(b){
            return "success";
        }
        return "fail";
    }

}

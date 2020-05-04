package com.ass.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ass.gmall.pojo.ProductAttrValue;
import com.ass.gmall.service.ProductAttrValueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/attrValue")
public class ProductAttrValueController {


    @Reference
    private ProductAttrValueService productAttrValueService;

    @GetMapping("/list/{id}")
    public List<ProductAttrValue> listAttrValue(@PathVariable("id") String infoId){
       return productAttrValueService.listAttrValue(infoId);
    }

    @GetMapping("/get/{id}")
    public ProductAttrValue getAttrValue(@PathVariable("id") String valueId){
        return productAttrValueService.getValue(valueId);
    }

    @PostMapping("/save")
    public String save(@RequestBody ProductAttrValue productAttrValue){
        boolean b = productAttrValueService.addAttrValue(productAttrValue);
        if(b){
            return "success";
        }
        return "fail";
    }

}

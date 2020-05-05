package com.ass.gmall.test;

import com.ass.gmall.pojo.*;
import com.ass.gmall.service.ProductAttrInfoService;
import com.ass.gmall.service.ProductAttrValueService;
import com.ass.gmall.service.ProductCatalogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {

    @Autowired
    private ProductCatalogService productCatalogService;
    @Autowired
    private ProductAttrInfoService productAttrInfoService;
    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Test
    public void test01(){
        List<ProductCatalog1> catalog1s = productCatalogService.listCatalog();
        List<ProductCatalog2> productCatalog2s = productCatalogService.listCatalog2("2");
        List<ProductCatalog3> productCatalog3s = productCatalogService.listCatalog3("13");
        System.out.println(123);
    }

    @Test
    public void test02(){
        /*List<ProductAttrInfo> attrInfo = productAttrInfoService.getAttrInfo("1");
        System.out.println(attrInfo);*/
       /* boolean b = productAttrInfoService.addAttrInfo(new ProductAttrInfo(null, "测试测试", "61", null, null));
        Assert.assertEquals(true,b);*/
        //boolean b =  productAttrInfoService.updateAttrInfo(new ProductAttrInfo("44", "测试修改", "61", null, null));
        boolean b = productAttrInfoService.removeAttrInfo("44");
                Assert.assertEquals(true,b);
    }

    @Test
    public void test03(){
        List<ProductAttrValue> list = productAttrValueService.listAttrValue("25");
        System.out.println(list);
    }
}

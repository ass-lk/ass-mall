package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.ass.gmall.manage.mapper.PmsSkuImageMapper;
import com.ass.gmall.manage.mapper.PmsSkuInfoMapper;
import com.ass.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.ass.gmall.pojo.*;
import com.ass.gmall.service.PmsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PmsSkuServiceImpl implements PmsSkuService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;


    @Override
    public String saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        // 插入skuinfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();
        //插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }
        //插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        //插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insert(pmsSkuImage);
        }

        return "success";
    }

    @Override
    public PmsSkuInfo getSkuInfoById(String skuId) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(skuId);
        //查询所有的sku相关图片
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> skuImageList = pmsSkuImageMapper.select(pmsSkuImage);
        pmsSkuInfo.setSkuImageList(skuImageList);
        //设置所有的sku属性值
        PmsSkuAttrValue attrValue = new PmsSkuAttrValue();
        attrValue.setSkuId(skuId);
        List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuAttrValueMapper.select(attrValue);
        pmsSkuInfo.setSkuAttrValueList(pmsSkuAttrValueList);
       //设置所有的销售属性
        PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuSaleAttrValueMapper.select(pmsSkuSaleAttrValue);
        pmsSkuInfo.setSkuSaleAttrValueList(pmsSkuSaleAttrValueList);
        return pmsSkuInfo;
    }
}

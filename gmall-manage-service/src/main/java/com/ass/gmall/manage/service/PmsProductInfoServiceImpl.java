package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.*;
import com.ass.gmall.pojo.*;
import com.ass.gmall.service.PmsProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PmsProductInfoServiceImpl implements PmsProductInfoService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;


    @Override
    public List<PmsProductInfo> subList(String catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        example.createCriteria().andEqualTo("catalog3Id",catalog3Id);
        return pmsProductInfoMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public String addSub(PmsProductInfo info) {
        int i = pmsProductInfoMapper.insert(info);
        //插入属性值
        List<PmsProductSaleAttr> spuSaleAttrList = info.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            //设置商品id
            pmsProductSaleAttr.setProductId(info.getId());
            //插入数据
            pmsProductSaleAttrMapper.insert(pmsProductSaleAttr);
            //插入对应的属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(info.getId());
                pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getId());
                pmsProductSaleAttrValueMapper.insert(pmsProductSaleAttrValue);
            }
        }
        //保存图片
        List<PmsProductImage> imageList = info.getSpuImageList();
        for (PmsProductImage pmsProductImage : imageList) {
            pmsProductImage.setProductId(info.getId());
            pmsProductImageMapper.insert(pmsProductImage);
        }
        if (i > 0){
            return "success";
        }
        return "fail";
    }

    @Override
    public String updateSub(PmsProductInfo info) {
        int i = pmsProductInfoMapper.updateByPrimaryKey(info);
        if (i > 0){
            return "success";
        }
        return "fail";
    }

    @Override
    public PmsProductInfo getSub(String productId) {

        return pmsProductInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public String removeSub(String productId) {
        int i = pmsProductInfoMapper.deleteByPrimaryKey(productId);
        if (i > 0){
            return "success";
        }
        return "fail";
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}

package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.PmsProductImageMapper;
import com.ass.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.ass.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.ass.gmall.pojo.PmsProductImage;
import com.ass.gmall.pojo.PmsProductSaleAttr;
import com.ass.gmall.pojo.PmsProductSaleAttrValue;
import com.ass.gmall.service.PmsSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PmsSpuServiceImpl implements PmsSpuService {


    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        Example example = new Example(PmsProductSaleAttr.class);
        example.createCriteria().andEqualTo("productId",spuId);
        List<PmsProductSaleAttr> list = pmsProductSaleAttrMapper.selectByExample(example);
        for (PmsProductSaleAttr pmsProductSaleAttr : list) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            // 销售属性id用的是系统的字典表中id，不是销售属性表的主键
            pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrValue> select = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            pmsProductSaleAttr.setSpuSaleAttrValueList(select);
        }
        return list;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        Example example = new Example(PmsProductImage.class);
        example.createCriteria().andEqualTo("productId",spuId);
        return pmsProductImageMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductSaleAttrValue> spuSaleAttrListCheckBySku(String skuId) {
        return null;
    }
}

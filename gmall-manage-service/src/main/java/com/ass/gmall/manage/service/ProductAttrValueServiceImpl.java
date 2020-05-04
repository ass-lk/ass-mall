package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.ProductAttrValueMapper;
import com.ass.gmall.pojo.ProductAttrValue;
import com.ass.gmall.service.ProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ProductAttrValueServiceImpl implements ProductAttrValueService {

    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;

    /**
     * 根据属性id 查询对应的value值列表
     * @param infoId 属性id
     * @return value值列表
     */
    @Override
    public List<ProductAttrValue> listAttrValue(String infoId) {
        Example example = new Example(ProductAttrValue.class);
        example.createCriteria().andEqualTo("attrId",infoId);
        return productAttrValueMapper.selectByExample(example);
    }

    @Override
    public boolean addAttrValue(ProductAttrValue value) {
        return productAttrValueMapper.insert(value) > 0;
    }

    @Override
    public boolean updateAttrValue(ProductAttrValue value) {
        return productAttrValueMapper.updateByPrimaryKey(value) > 0;
    }

    @Override
    public boolean removeAttrValue(String valueId) {
        return productAttrValueMapper.deleteByPrimaryKey(valueId) > 0;
    }

    @Override
    public ProductAttrValue getValue(String valueId) {
        return productAttrValueMapper.selectByPrimaryKey(valueId);
    }
}

package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ass.gmall.manage.mapper.ProductAttrInfoMapper;
import com.ass.gmall.manage.mapper.ProductAttrValueMapper;
import com.ass.gmall.pojo.ProductAttrInfo;
import com.ass.gmall.pojo.ProductAttrValue;
import com.ass.gmall.service.PmsBaseAttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PmsBaseAttrInfoServiceImpl implements PmsBaseAttrInfoService {

    @Autowired
    private ProductAttrInfoMapper productAttrInfoMapper;
    @Autowired
    private ProductAttrValueMapper productAttrValueMapper;

    /**
     * 根据类目查询指定的属性列表信息
     * @param catelog3Id 三级类目id
     * @return
     */
    @Override
    public List<ProductAttrInfo> getAttrInfo(String catelog3Id) {
        Example example = new Example(ProductAttrInfo.class);
        example.createCriteria().andEqualTo("catalog3Id",catelog3Id);
        List<ProductAttrInfo> list = productAttrInfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ProductAttrValue> getValue(String infoId) {
        Example example = new Example(ProductAttrValue.class);
        example.createCriteria().andEqualTo("attrId",infoId);
        return productAttrValueMapper.selectByExample(example);
    }

    /**
     * 新增属性信息
     * @param info
     * @return
     */
    @Override
    @Transactional
    public boolean addAttrInfo(ProductAttrInfo info) {
        int i = productAttrInfoMapper.insertSelective(info);//插入数据
        //执行数据的插入操作
        List<ProductAttrValue> attrValueList = info.getAttrValueList();
        for (ProductAttrValue productAttrValue : attrValueList) {
            productAttrValue.setAttrId(info.getId());//设置所属于平台属性id
            productAttrValueMapper.insertSelective(productAttrValue);
            i++;
        }
        /*int i = 0;
        String id = info.getId();//获取id
        if(StringUtils.isBlank(id)){//表明是新增操作
             i = productAttrInfoMapper.insertSelective(info);//插入数据
            //执行数据的插入操作
            List<ProductAttrValue> attrValueList = info.getAttrValueList();
            for (ProductAttrValue productAttrValue : attrValueList) {
                productAttrValue.setAttrId(id);//设置所属于平台属性id
                productAttrValueMapper.insertSelective(productAttrValue);
                i++;
            }
            return i > 0;
        }else{
            //查询出当前所具有的属性列表
            Example example = new Example(ProductAttrValue.class);
            example.createCriteria().andEqualTo("attrId",id);
            List<ProductAttrValue> productAttrValues = productAttrValueMapper.selectByExample(example);
            if(!productAttrValues.isEmpty()){
                for (ProductAttrValue productAttrValue : productAttrValues) {
                    //删除所有数据
                    productAttrValueMapper.deleteByPrimaryKey(productAttrValue.getId());
                    i++;
                }
            }
        }*/

        return i > 0;
    }

    /**
     * 修改属性信息
     * @param info
     * @return
     */
    @Override
    public boolean updateAttrInfo(ProductAttrInfo info) {
        int i = productAttrInfoMapper.updateByPrimaryKey(info);
        return i > 0;
    }

    /**
     * 根据id删除指定的属性信息
     * @param infoId
     * @return
     */
    @Override
    public boolean removeAttrInfo(String infoId) {
        int i = productAttrInfoMapper.deleteByPrimaryKey(infoId);
        return i > 0;
    }

    /**
     * 根据主键id获取指定信息
     * @param id
     * @return
     */
    @Override
    public ProductAttrInfo getAttrInfoById(String id) {
        return productAttrInfoMapper.selectByPrimaryKey(id);
    }


}

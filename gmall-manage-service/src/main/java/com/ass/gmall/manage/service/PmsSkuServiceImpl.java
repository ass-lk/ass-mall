package com.ass.gmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.ass.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.ass.gmall.manage.mapper.PmsSkuImageMapper;
import com.ass.gmall.manage.mapper.PmsSkuInfoMapper;
import com.ass.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.ass.gmall.pojo.*;
import com.ass.gmall.service.PmsSkuService;
import com.ass.gmall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import springfox.documentation.spring.web.json.Json;

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
    @Autowired
    private RedisUtil redisUtil;

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


    public PmsSkuInfo getSkuInfoByIdFromDB(String skuId){

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
    @Override
    public PmsSkuInfo getSkuInfoById(String skuId) {
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        Jedis jedis = null;
        try {
            jedis = redisUtil.getJedis();
            String skuKey = "sku:" + skuId + ":info";//创建redis中的key
            String skuInfoJson = jedis.get(skuKey);
            if (StringUtils.isNotBlank(skuInfoJson)) {//命中缓存
                pmsSkuInfo = JSON.parseObject(skuInfoJson, PmsSkuInfo.class);
                jedis.close();
                return pmsSkuInfo;
            }else{//未命中缓存,去数据库中查询
                //设置分布式锁
                String OK = jedis.set("sku:" + skuId + ":lock", "1", "nx", "px", 10);
                //加锁操作
                if (StringUtils.isNotBlank(OK) && OK.equals("OK")) {
                    //设置成功,有权在10秒的过期时间内访问数据库
                    pmsSkuInfo = getSkuInfoByIdFromDB(skuId);
                    if (pmsSkuInfo != null) {
                        //在数据库中查询到相应的数据,将查询结构存入到redis缓存中
                        jedis.set("sku:" + skuId + ":info", JSON.toJSONString(pmsSkuInfo));
                    } else {
                        //数据库中不存在该sku信息
                        //为了防止缓存穿透,将null或者空字符串设置给Redis
                        jedis.setex("sku:" + skuId + ":info", 60 * 3, JSON.toJSONString(""));
                    }
                } else {//设置失败,即获取锁失败,进行自旋操作(该线程在睡眠几秒后,重新尝试访问本方法)
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return getSkuInfoByIdFromDB(skuId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            return pmsSkuInfo;
        }
    }


    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoMapper.selectSkuSaleAttrValueListBySpu(productId);
        return pmsSkuInfos;
    }
}

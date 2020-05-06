package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商品sku图片表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pms_sku_image")
public class PmsSkuImage implements Serializable {

    @Id
    @Column
    String id;//主键id
    @Column
    String skuId; //skuId
    @Column
    String imgName; //图片名称
    @Column
    String imgUrl;//图片路径
    @Column(name = "product_img_id")
    String spuImgId;//所属于的spuImg的id
    @Column
    String isDefault;//是否是默认的


}
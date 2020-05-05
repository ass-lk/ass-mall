package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商品图片表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pms_product_image")
public class PmsProductImage implements Serializable {

    @Column
    @Id
    private String id; //主键id
    @Column
    private String productId; //商品id
    @Column
    private String imgName;// 图片名称
    @Column
    private String imgUrl;//图片保存路径


}
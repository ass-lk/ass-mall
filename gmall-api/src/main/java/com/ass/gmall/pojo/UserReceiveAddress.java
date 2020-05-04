package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 会员收货地址表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ums_member_receive_address")
public class UserReceiveAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//主键id
    private String member_id;//会员id
    private String name;//收货人名称
    private String phone_number;//收货电话号码
    private Integer default_status;//是否为默认
    private String post_code;//邮政编码
    private String province;//省份/直辖市
    private String city;//城市
    private String region;//区
    private String detail_address;//详细地址(街道)
}



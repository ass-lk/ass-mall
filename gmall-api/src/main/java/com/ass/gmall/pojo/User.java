package com.ass.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ums_member")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//主键id
    private String memberLevelId;
    private String username;//用户名
    private String password;//用户密码
    private String nickname;//昵称
    private String phone;//手机号码
    private Integer status;// 帐号启用状态:0->禁用；1->启用
    private Date createTime;// 注册时间
    private String icon;//头像
    private Integer gender;// 性别：0->未知；1->男；2->女
    private Date birthday;//出生日期
    private String city;// 所住城市
    private String job;//  职业
    private String personalizedSignature;//个性签名
    private Integer sourceType;// 用户来源
    private Integer integration;// 积分
    private Integer growth;//成长值
    private Integer luckeyCount;// 剩余抽奖次数
    private Integer historyIntegration;//历史积分数量
}

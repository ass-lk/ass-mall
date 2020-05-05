package com.ass.gmall.model;

/**
 * 返回结果码抽象接口
 * 10000-- 通用错误代码
 * 22000-- 后台管理错误代码
 * 23000-- 搜索业务错误代码
 * 24000-- 购物车错误代码
 * 25000-- 登陆权限等错误
 */
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}

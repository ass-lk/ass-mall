package com.ass.gmall.exception;

import com.ass.gmall.model.ResultCode;

/**
 * 自定义异常抛出类
 */
public class ExceptionCast {

    //使用自定义方法抛出异常类
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}

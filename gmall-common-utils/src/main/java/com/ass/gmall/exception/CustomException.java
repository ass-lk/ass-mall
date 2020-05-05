package com.ass.gmall.exception;

import com.ass.gmall.model.ResultCode;

/**
 * 自定义的异常信息类,保存开发过程中可能会出现的异常信息
 */
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        //异常信息为错误代码 + 异常信息
        super("错误代码:" + resultCode.code() + "错误信息:" + resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return this.resultCode;
    }


}

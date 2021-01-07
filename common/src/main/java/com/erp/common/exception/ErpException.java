package com.erp.common.exception;

/**
 *  功能描述: 自定义异常枚举类
 *
 * @Author: cy
 * @Date: 2019-07-26 11:54
 * @Version 1.0
 **/
public enum ErpException {

    NORMAL("100000", "请求成功"),
    UnknownException("999999", "未知错误"),
    //参数异常
    ParamException("400000", "参数不完整"),
    //数据异常
    DataException("500000", "数据异常，请联系管理员"),
    //用户异常
    UserException("600000", "用户异常，请联系管理员"),
    //权限异常
    NopPrmissions("600001", "权限不足"),
    //操作异常
    OperateFail("700000", "操作失败(增删改查)");

    public String code;
    public String msg;

    ErpException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public ErpException code(String code) {
        this.code = code;
        return this;
    }
    public ErpException msg(String msg) {
        this.msg = msg;
        return this;
    }
}

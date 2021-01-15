package com.erp.common.entity;

import com.erp.common.exception.ErpException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回结果信息
 *
 * @author zhangby
 * @date 2017/11/30 下午7:09
 */
@ApiModel(value = "ResultPoJo", description = "返回数据")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class ResultPoJo<T> {

    @ApiModelProperty(value = "返回码：100100【正确】，其他错误", example = "100100 ")
    private String code;

    @ApiModelProperty(value = "返回信息", example = "成功！")
    private String msg;

    @ApiModelProperty(value = "返回结果", example = "{}")
    private T result;

    public ResultPoJo() {
        this.code = ErpException.NORMAL.getCode();
        this.msg = ErpException.NORMAL.getMsg();
    }

    public ResultPoJo(ErpException be) {
        this.code = be.getCode();
        this.msg = be.getMsg();
    }

    public ResultPoJo setResult(T obj) {
        this.result=obj;
        return this;
    }

}

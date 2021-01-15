package com.erp.main.controller;

import com.erp.common.entity.ResultPoJo;
import com.erp.common.exception.ErpException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "订单管理")
@RequestMapping("/order")
public class orderController {

    @PostMapping("/b")
    @ApiOperation(value = "输入id", notes = "客户管理")
    public ResultPoJo msg( String id) {
        ResultPoJo<String> re =new ResultPoJo<>().setResult(id);
        ResultPoJo<String> re1= new ResultPoJo<>(ErpException.OperateFail).setResult(id);
        return re;
    }

    @PostMapping("/a")
    @ApiOperation(value = "输入对象", notes = "客户管理" )
    public String a(@RequestBody ResultPoJo i) {
        return i.getResult().toString();
    }
}
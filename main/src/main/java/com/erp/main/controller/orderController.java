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

    @PostMapping("/msg")
    @ApiOperation(value = "添加客户", notes = "客户管理", produces = "application/json", response = ResultPoJo.class)
    public ResultPoJo msg(@RequestBody String request) {
        ResultPoJo re = ResultPoJo.resultOK(ErpException.NORMAL,request);
        return re;
    }

    @PostMapping("/a")
    @ApiOperation(value = "添加客户", notes = "客户管理")
    public String a() {
        return "aaa";
    }
}
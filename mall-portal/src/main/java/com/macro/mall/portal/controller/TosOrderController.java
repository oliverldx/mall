package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.TosOrderDetail;
import com.macro.mall.portal.service.TosOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客服中心管理Controller
 */
@Controller
@Api(tags = "TsCustomerServiceController", description = "客服中心管理")
@RequestMapping("/tosOrder")
public class TosOrderController {

    @Autowired
    TosOrderService tosOrderService;


    @ApiOperation("创建订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> get(@RequestBody TosOrderDetail tosOrderDetail) {
        if(tosOrderService.createTosOrder(tosOrderDetail)) {
            return  CommonResult.success(true,"创建订单成功");
        }else {
            return  CommonResult.failed("创建订单成功");
        }
    }


}

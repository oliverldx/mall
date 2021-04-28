package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TsCustomerServiceMapper;
import com.macro.mall.model.TsCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客服中心管理Controller
 */
@Controller
@Api(tags = "TsCustomerServiceController", description = "客服中心管理")
@RequestMapping("/tsCustomerService")
public class TsCustomerServiceController {

    @Autowired
    private TsCustomerServiceMapper tsCustomerServiceMapper;

    @ApiOperation("获取客服中心信息")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TsCustomerService> get(@PathVariable Long id) {
        TsCustomerService tsCustomerService = tsCustomerServiceMapper.selectByPrimaryKey(id);
        if(tsCustomerService == null) {
            tsCustomerService = new TsCustomerService();
        }
        return  CommonResult.success(tsCustomerService,"获取客服中心内容成功");
    }


}

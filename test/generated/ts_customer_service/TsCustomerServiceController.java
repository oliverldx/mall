package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TsCustomerServiceMapper;
import com.macro.mall.model.TsCustomerService;
import com.macro.mall.dto.TsCustomerServiceQueryParam;
import com.macro.mall.dao.TsCustomerServiceDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
* 客服中心管理Controller
*/
@Controller
@Api(tags = "TsCustomerServiceController", description = "客服中心管理")
@RequestMapping("/customerService")
public class TsCustomerServiceController {

    @Autowired
    private TsCustomerServiceMapper tsCustomerServiceMapper;
    @Autowired
    private TsCustomerServiceDao tsCustomerServiceDao;

    @ApiOperation("添加客服中心")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TsCustomerService tsCustomerService) {
        Date createDate = new Date();
        tsCustomerService.setCreateDate(createDate);
        tsCustomerService.setModifyDate(createDate);
        int count = tsCustomerServiceMapper.insert(tsCustomerService);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取客服中心列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TsCustomerService>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TsCustomerServiceQueryParam tsCustomerServiceQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TsCustomerService> tsCustomerServiceList = tsCustomerServiceDao.getList(tsCustomerServiceQueryParam);
        return  CommonResult.success(CommonPage.restPage(tsCustomerServiceList),"获取客服中心列表成功");
    }

     @ApiOperation("修改客服中心")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TsCustomerService tsCustomerService,
        BindingResult result) {
        tsCustomerService.setModifyDate(new Date());
        int count = 0;
        count = tsCustomerServiceMapper.updateByPrimaryKeySelective(tsCustomerService);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除客服中心")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tsCustomerServiceMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取客服中心")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TsCustomerService> getById(@PathVariable Long id) {
        TsCustomerService tsCustomerService = tsCustomerServiceMapper.selectByPrimaryKey(id);
        return CommonResult.success(tsCustomerService);
    }
}

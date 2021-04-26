package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TsContractMapper;
import com.macro.mall.model.TsContract;
import com.macro.mall.model.TsContractExample;
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
* 购买协议管理Controller
*/
@Controller
@Api(tags = "TsContractController", description = "购买协议管理")
@RequestMapping("/contract")
public class TsContractController {

    @Autowired
    private TsContractMapper tsContractMapper;

    @ApiOperation("添加购买协议")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TsContract tsContract) {
        Date createDate = new Date();
        tsContract.setCreateDate(createDate);
        tsContract.setModifyDate(createDate);
        int count = tsContractMapper.insert(tsContract);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取购买协议列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TsContract>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TsContractExample example = new TsContractExample();
        List<TsContract> tsContractList = tsContractMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(tsContractList),"获取购买协议列表成功");
    }

     @ApiOperation("修改购买协议")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TsContract tsContract,
        BindingResult result) {
        tsContract.setModifyDate(new Date());
        int count = 0;
        count = tsContractMapper.updateByPrimaryKeySelective(tsContract);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除购买协议")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tsContractMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取购买协议")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TsContract> getById(@PathVariable Long id) {
        TsContract tsContract = tsContractMapper.selectByPrimaryKey(id);
        return CommonResult.success(tsContract);
    }
}

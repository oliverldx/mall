package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsGroupSaleMapper;
import com.macro.mall.model.TrsGroupSale;
import com.macro.mall.dao.TrsGroupSaleDao;
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
* 课程活动管理Controller
*/
@Controller
@Api(tags = "TrsGroupSaleController", description = "课程活动管理")
@RequestMapping("/groupSale")
public class TrsGroupSaleController {

    @Autowired
    private TrsGroupSaleMapper trsGroupSaleMapper;
    @Autowired
    private TrsGroupSaleDao trsGroupSaleDao;

    @ApiOperation("添加课程活动")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsGroupSale trsGroupSale) {
        Date createDate = new Date();
        trsGroupSale.setCreateDate(createDate);
        trsGroupSale.setModifyDate(createDate);
        int count = trsGroupSaleMapper.insert(trsGroupSale);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改课程活动")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsGroupSale trsGroupSale,
            BindingResult result) {
        trsGroupSale.setModifyDate(new Date());
        int count = 0;
        count = trsGroupSaleMapper.updateByPrimaryKeySelective(trsGroupSale);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除课程活动")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = trsGroupSaleMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据id获取课程活动")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsGroupSale> getById(@PathVariable Long id) {
        TrsGroupSale trsGroupSale = trsGroupSaleMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsGroupSale);
    }

    @ApiOperation("根据activityId获取课程活动")
    @RequestMapping(value = "/getByActivityId/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsGroupSale> getByActivityId(@PathVariable Long activityId) {
        TrsGroupSale trsGroupSale = trsGroupSaleDao.getByActivityId(activityId);
        return CommonResult.success(trsGroupSale);
    }
}
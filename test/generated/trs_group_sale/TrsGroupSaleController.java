package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.TrsGroupSaleDao;
import com.macro.mall.dto.TrsGroupSaleQueryParam;
import com.macro.mall.mapper.TrsGroupSaleMapper;
import com.macro.mall.model.TrsGroupSale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
* 课程活动管理Controller
*/
@Controller
@Api(tags = "TrsGroupSaleController", description = "课程活动管理")
@RequestMapping("/group_sale")
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

    @ApiOperation("获取课程活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsGroupSale>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsGroupSaleQueryParam trsGroupSaleQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsGroupSale> trsGroupSaleList = trsGroupSaleDao.getList(trsGroupSaleQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsGroupSaleList),"获取课程活动列表成功");
    }

     @ApiOperation("修改课程活动")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsGroupSale trsGroupSale,
        BindingResult result) {
        trsGroupSale.setModifyDate(new Date());
        int count = 0;
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
}

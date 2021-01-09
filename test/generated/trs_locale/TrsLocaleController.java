package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsLocaleMapper;
import com.macro.mall.model.TrsLocale;
import com.macro.mall.dto.TrsLocaleQueryParam;
import com.macro.mall.dao.TrsLocaleDao;
import com.macro.mall.model.TrsLocaleExample;
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
* 现场管理Controller
*/
@Controller
@Api(tags = "TrsLocaleController", description = "现场管理")
@RequestMapping("/locale")
public class TrsLocaleController {

    @Autowired
    private TrsLocaleMapper trsLocaleMapper;
    @Autowired
    private TrsLocaleDao trsLocaleDao;

    @ApiOperation("添加现场")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsLocale trsLocale) {
        Date createDate = new Date();
        trsLocale.setCreateDate(createDate);
        trsLocale.setModifyDate(createDate);
        int count = trsLocaleMapper.insert(trsLocale);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取现场列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsLocale>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsLocaleQueryParam trsLocaleQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsLocale> trsLocaleList = trsLocaleDao.getList(trsLocaleQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsLocaleList),"获取现场列表成功");
    }

     @ApiOperation("修改现场")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsLocale trsLocale,
        BindingResult result) {
        trsLocale.setModifyDate(new Date());
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除现场")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取现场")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsLocale> getById(@PathVariable Long id) {
        TrsLocale trsLocale = trsLocaleMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsLocale);
    }
}
package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.TrsPagesDao;
import com.macro.mall.mapper.TrsPagesMapper;
import com.macro.mall.model.TrsPages;
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
* 页面管理Controller
*/
@Controller
@Api(tags = "TrsPagesController", description = "页面管理")
@RequestMapping("/pages")
public class TrsPagesController {

    @Autowired
    private TrsPagesMapper trsPagesMapper;
    @Autowired
    private TrsPagesDao trsPagesDao;

    @ApiOperation("添加页面")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsPages trsPages) {
        Date createDate = new Date();
        trsPages.setCreateDate(createDate);
        trsPages.setModifyDate(createDate);
        int count = trsPagesMapper.insert(trsPages);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

     @ApiOperation("修改页面")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsPages trsPages,
        BindingResult result) {
        trsPages.setModifyDate(new Date());
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除页面")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取页面")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsPages> getById(@PathVariable Long id) {
        TrsPages trsPages = trsPagesMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsPages);
    }

    @ApiOperation("根据activityId获取页面")
    @RequestMapping(value = "/getByActivityId/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsPages> getByActivityId(@PathVariable Long activityId) {
        TrsPages trsPages = trsPagesDao.getByActivityId(activityId);
        return CommonResult.success(trsPages);
    }
}

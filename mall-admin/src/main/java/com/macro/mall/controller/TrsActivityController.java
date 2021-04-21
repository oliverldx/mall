package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsActivityMapper;
import com.macro.mall.model.TrsActivity;
import com.macro.mall.model.TrsActivityExample;
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
* 活动管理Controller
*/
@Controller
@Api(tags = "TrsActivityController", description = "活动管理")
@RequestMapping("/activity")
public class TrsActivityController {

    @Autowired
    private TrsActivityMapper trsActivityMapper;

    @ApiOperation("添加活动")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsActivity trsActivity) {
        Date createDate = new Date();
        trsActivity.setCreateDate(createDate);
        trsActivity.setModifyDate(createDate);
        int count = trsActivityMapper.insert(trsActivity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsActivity>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TrsActivityExample example = new TrsActivityExample();
        List<TrsActivity> trsActivityList = trsActivityMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(trsActivityList),"获取活动列表成功");
    }

     @ApiOperation("修改活动")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsActivity trsActivity,
        BindingResult result) {
        trsActivity.setModifyDate(new Date());
        int count = 0;
        count = trsActivityMapper.updateByPrimaryKeySelective(trsActivity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除活动")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = trsActivityMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取活动")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsActivity> getById(@PathVariable Long id) {
        TrsActivity trsActivity = trsActivityMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsActivity);
    }
}

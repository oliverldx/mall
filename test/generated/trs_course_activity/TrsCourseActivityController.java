package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsCourseActivityMapper;
import com.macro.mall.model.TrsCourseActivity;
import com.macro.mall.dto.TrsCourseActivityQueryParam;
import com.macro.mall.dao.TrsCourseActivityDao;
import com.macro.mall.model.TrsCourseActivityExample;
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
@Api(tags = "TrsCourseActivityController", description = "课程活动管理")
@RequestMapping("/course_activity")
public class TrsCourseActivityController {

    @Autowired
    private TrsCourseActivityMapper trsCourseActivityMapper;
    @Autowired
    private TrsCourseActivityDao trsCourseActivityDao;

    @ApiOperation("添加课程活动")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsCourseActivity trsCourseActivity) {
        Date createDate = new Date();
        trsCourseActivity.setCreateDate(createDate);
        trsCourseActivity.setModifyDate(createDate);
        int count = trsCourseActivityMapper.insert(trsCourseActivity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取课程活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsCourseActivity>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsCourseActivityQueryParam trsCourseActivityQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsCourseActivity> trsCourseActivityList = trsCourseActivityDao.getList(trsCourseActivityQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsCourseActivityList),"获取课程活动列表成功");
    }

     @ApiOperation("修改课程活动")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsCourseActivity trsCourseActivity,
        BindingResult result) {
        trsCourseActivity.setModifyDate(new Date());
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
    public CommonResult<TrsCourseActivity> getById(@PathVariable Long id) {
        TrsCourseActivity trsCourseActivity = trsCourseActivityMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsCourseActivity);
    }
}

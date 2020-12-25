package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsCourseMapper;
import com.macro.mall.model.TrsCourse;
import com.macro.mall.model.TrsCourseExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 课程管理Controller
*/
@Controller
@Api(tags = "TrsCourseController", description = "课程管理")
@RequestMapping("/course")
public class TrsCourseController {

    @Autowired
    private TrsCourseMapper trsCourseMapper;

    @ApiOperation("添加课程")
    @RequestMapping(value = "/TODO-add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsCourse trsCourse) {
        int count = trsCourseMapper.insert(trsCourse);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取课程列表")
    @RequestMapping(value = "/TODO-list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsCourse>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TrsCourseExample example = new TrsCourseExample();
        List<TrsCourse> trsCourseList = trsCourseMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(trsCourseList),"获取课程列表成功");
    }

     @ApiOperation("修改课程")
     @RequestMapping(value = "/TODO-update", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult updateAttr(@RequestBody TrsCourse trsCourse) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除课程")
     @RequestMapping(value = "/TODO-delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }
}

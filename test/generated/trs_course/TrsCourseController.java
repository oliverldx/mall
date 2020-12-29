package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsCourseMapper;
import com.macro.mall.model.TrsCourse;
import com.macro.mall.dto.TrsCourseQueryParam;
import com.macro.mall.dao.TrsCourseDao;
import com.macro.mall.model.TrsCourseExample;
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
* 课程管理Controller
*/
@Controller
@Api(tags = "TrsCourseController", description = "课程管理")
@RequestMapping("/course")
public class TrsCourseController {

    @Autowired
    private TrsCourseMapper trsCourseMapper;
    @Autowired
    private TrsCourseDao trsCourseDao;

    @ApiOperation("添加课程")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsCourse trsCourse) {
        Date createDate = new Date();
        trsCourse.setCreateDate(createDate);
        trsCourse.setModifyDate(createDate);
        int count = trsCourseMapper.insert(trsCourse);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取课程列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsCourse>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsCourseQueryParam trsCourseQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsCourse> trsCourseList = trsCourseDao.getList(trsCourseQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsCourseList),"获取课程列表成功");
    }

     @ApiOperation("修改课程")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsCourse trsCourse,
        BindingResult result) {
        trsCourse.setModifyDate(new Date());
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除课程")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取课程")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsCourse> getById(@PathVariable Long id) {
        TrsCourse trsCourse = trsCourseMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsCourse);
    }
}

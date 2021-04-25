package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TosOrderCourseMapper;
import com.macro.mall.model.TosOrderCourse;
import com.macro.mall.dto.TosOrderCourseDto;
import com.macro.mall.dto.TosOrderCourseQueryParam;
import com.macro.mall.dao.TosOrderCourseDao;
import com.macro.mall.dto.TosOrderCourseSubListQueryParam;
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
* 订单课程信息管理Controller
*/
@Controller
@Api(tags = "TosOrderCourseController", description = "订单课程信息管理")
@RequestMapping("/orderCourse")
public class TosOrderCourseController {

    @Autowired
    private TosOrderCourseMapper tosOrderCourseMapper;
    @Autowired
    private TosOrderCourseDao tosOrderCourseDao;

    @ApiOperation("添加订单课程信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TosOrderCourse tosOrderCourse) {
        Date createDate = new Date();
        tosOrderCourse.setCreateDate(createDate);
        tosOrderCourse.setModifyDate(createDate);
        int count = tosOrderCourseMapper.insert(tosOrderCourse);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单课程信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosOrderCourseDto>>
        list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosOrderCourseQueryParam tosOrderCourseQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosOrderCourseDto> tosOrderCourseList = tosOrderCourseDao.getList(tosOrderCourseQueryParam);
        return  CommonResult.success(CommonPage.restPage(tosOrderCourseList),"获取订单课程信息列表成功");
    }

     @ApiOperation("修改订单课程信息")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TosOrderCourse tosOrderCourse,
        BindingResult result) {
        tosOrderCourse.setModifyDate(new Date());
        int count = 0;
        count = tosOrderCourseMapper.updateByPrimaryKeySelective(tosOrderCourse);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除订单课程信息")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tosOrderCourseMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取订单课程信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TosOrderCourse> getById(@PathVariable Long id) {
        TosOrderCourse tosOrderCourse = tosOrderCourseMapper.selectByPrimaryKey(id);
        return CommonResult.success(tosOrderCourse);
    }


    @ApiOperation("获取course列表")
    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosOrderCourseSubListQueryParam>> courseList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosOrderCourseSubListQueryParam tosOrderCourseSubListQueryParam,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosOrderCourseSubListQueryParam> courseList = tosOrderCourseDao.getCourseList(tosOrderCourseSubListQueryParam);
        return  CommonResult.success(CommonPage.restPage(courseList),"获取订单课程信息-course列表成功");
    }

    @ApiOperation("添加订单课程信息-course")
    @RequestMapping(value = "/addCourseList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addCourseList(@RequestParam("ids") List<Long> ids, @RequestParam("orderId") Long orderId) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        Date createDate = new Date();
        for (Long id : ids) {
            TosOrderCourse tosOrderCourse = new  TosOrderCourse();
            tosOrderCourse.setCreateDate(createDate);
            tosOrderCourse.setModifyDate(createDate);
                    tosOrderCourse.setTosOrderId(orderId);
                    tosOrderCourse.setTrsCourseId(orderId);
            count = tosOrderCourseMapper.insert(tosOrderCourse);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
        }

}

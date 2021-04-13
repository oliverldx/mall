package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsCourseMapper;
import com.macro.mall.model.TrsCourse;
import com.macro.mall.portal.dao.PortalCourseDao;
import com.macro.mall.portal.domain.ChooseCourse;
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
@RequestMapping("/trsCourse")
public class TrsCourseController {

    @Autowired
    private TrsCourseMapper trsCourseMapper;
    @Autowired
    private PortalCourseDao portalCourseDao;

    @ApiOperation("添加课程")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsCourse trsCourse) {
        int count = trsCourseMapper.insert(trsCourse);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取课程列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ChooseCourse>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ChooseCourse> chooseCourses = portalCourseDao.getChooseCourses();
        return  CommonResult.success(chooseCourses,"获取课程列表成功");
    }

    @ApiOperation("获取课程")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsCourse> get(@PathVariable Long id) {
        TrsCourse trsCourse = trsCourseMapper.selectByPrimaryKey(id);
        return  CommonResult.success(trsCourse,"获取课程内容成功");
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
}

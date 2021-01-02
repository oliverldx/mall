package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.TrsSchoolActivityDao;
import com.macro.mall.dto.TrsSchoolActivityQueryParam;
import com.macro.mall.mapper.TrsSchoolActivityMapper;
import com.macro.mall.model.TrsSchoolActivity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
* 机构活动管理Controller
*/
@Controller
@Api(tags = "TrsSchoolActivityController", description = "机构活动管理")
@RequestMapping("/school_activity")
public class TrsSchoolActivityController {

    @Autowired
    private TrsSchoolActivityMapper trsSchoolActivityMapper;
    @Autowired
    private TrsSchoolActivityDao trsSchoolActivityDao;

    @ApiOperation("添加机构活动")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsSchoolActivity trsSchoolActivity) {
        Date createDate = new Date();
        trsSchoolActivity.setCreateDate(createDate);
        trsSchoolActivity.setModifyDate(createDate);
        int count = trsSchoolActivityMapper.insert(trsSchoolActivity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取机构活动列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsSchoolActivity>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsSchoolActivityQueryParam trsSchoolActivityQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsSchoolActivity> trsSchoolActivityList = trsSchoolActivityDao.getList(trsSchoolActivityQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsSchoolActivityList),"获取机构活动列表成功");
    }

     @ApiOperation("修改机构活动")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsSchoolActivity trsSchoolActivity,
        BindingResult result) {
        trsSchoolActivity.setModifyDate(new Date());
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除机构活动")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取机构活动")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsSchoolActivity> getById(@PathVariable Long id) {
        TrsSchoolActivity trsSchoolActivity = trsSchoolActivityMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsSchoolActivity);
    }
}

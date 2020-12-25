package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsSchoolMapper;
import com.macro.mall.model.TrsSchool;
import com.macro.mall.model.TrsSchoolExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 培训机构管理Controller
*/
@Controller
@Api(tags = "TrsSchoolController", description = "培训机构管理")
@RequestMapping("/school")
public class TrsSchoolController {

    @Autowired
    private TrsSchoolMapper trsSchoolMapper;

    @ApiOperation("添加培训机构")
    @RequestMapping(value = "/TODO-add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsSchool trsSchool) {
        int count = trsSchoolMapper.insert(trsSchool);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取培训机构列表")
    @RequestMapping(value = "/TODO-list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsSchool>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TrsSchoolExample example = new TrsSchoolExample();
        List<TrsSchool> trsSchoolList = trsSchoolMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(trsSchoolList),"获取培训机构列表成功");
    }

     @ApiOperation("修改培训机构")
     @RequestMapping(value = "/TODO-update", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult updateAttr(@RequestBody TrsSchool trsSchool) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除培训机构")
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

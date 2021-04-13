package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsSchoolMapper;
import com.macro.mall.model.TrsSchool;
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
@Api(tags = "TrsSchoolController", description = "培训机构管理")
@RequestMapping("/trsSchool")
public class TrsSchoolController {

    @Autowired
    private TrsSchoolMapper trsSchoolMapper;


    @ApiOperation("添加培训机构")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsSchool trsSchool) {
        int count = trsSchoolMapper.insert(trsSchool);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取培训机构")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsSchool> get(@PathVariable Long id) {
        TrsSchool trsSchool = trsSchoolMapper.selectByPrimaryKey(id);
        return  CommonResult.success(trsSchool,"获取培训机构内容成功");
    }

    @ApiOperation("删除培训机构")
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

package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.OmsCartItemMapper;
import com.macro.mall.model.OmsCartItem;
import com.macro.mall.model.OmsCartItemExample;
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
    private OmsCartItemMapper omsCartItemMapper;

    @ApiOperation("添加课程")
    @RequestMapping(value = "/TODO-add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody OmsCartItem cartItem) {
        int count = omsCartItemMapper.insert(cartItem);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取课程列表")
    @RequestMapping(value = "/TODO-list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsCartItem>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        OmsCartItemExample example = new OmsCartItemExample();
        List<OmsCartItem> cartItemList = omsCartItemMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(cartItemList),"获取课程列表成功");
    }

    @ApiOperation("修改课程")
    @RequestMapping(value = "/TODO-update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAttr(@RequestBody OmsCartItem cartItem) {
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

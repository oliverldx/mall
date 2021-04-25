package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TosOrderMapper;
import com.macro.mall.model.TosOrder;
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
* 订单管理Controller
*/
@Controller
@Api(tags = "TosOrderController", description = "订单管理")
@RequestMapping("/order")
public class TosOrderController {

    @Autowired
    private TosOrderMapper tosOrderMapper;

    @ApiOperation("添加订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TosOrder tosOrder) {
        Date createDate = new Date();
        tosOrder.setCreateDate(createDate);
        tosOrder.setModifyDate(createDate);
        int count = tosOrderMapper.insert(tosOrder);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosOrder>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TosOrderExample example = new TosOrderExample();
        List<TosOrder> tosOrderList = tosOrderMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(tosOrderList),"获取订单列表成功");
    }

     @ApiOperation("修改订单")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TosOrder tosOrder,
        BindingResult result) {
        tosOrder.setModifyDate(new Date());
        int count = 0;
        count = tosOrderMapper.updateByPrimaryKeySelective(tosOrder);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除订单")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tosOrderMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取订单")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TosOrder> getById(@PathVariable Long id) {
        TosOrder tosOrder = tosOrderMapper.selectByPrimaryKey(id);
        return CommonResult.success(tosOrder);
    }
}

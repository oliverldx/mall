package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TosOrderGiftMapper;
import com.macro.mall.model.TosOrderGift;
import com.macro.mall.dto.TosOrderGiftDto;
import com.macro.mall.dto.TosOrderGiftQueryParam;
import com.macro.mall.dao.TosOrderGiftDao;
import com.macro.mall.dto.TosOrderGiftSubListQueryParam;
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
* 订单赠品信息管理Controller
*/
@Controller
@Api(tags = "TosOrderGiftController", description = "订单赠品信息管理")
@RequestMapping("/orderGift")
public class TosOrderGiftController {

    @Autowired
    private TosOrderGiftMapper tosOrderGiftMapper;
    @Autowired
    private TosOrderGiftDao tosOrderGiftDao;

    @ApiOperation("添加订单赠品信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TosOrderGift tosOrderGift) {
        Date createDate = new Date();
        tosOrderGift.setCreateDate(createDate);
        tosOrderGift.setModifyDate(createDate);
        int count = tosOrderGiftMapper.insert(tosOrderGift);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单赠品信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosOrderGiftDto>>
        list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosOrderGiftQueryParam tosOrderGiftQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosOrderGiftDto> tosOrderGiftList = tosOrderGiftDao.getList(tosOrderGiftQueryParam);
        return  CommonResult.success(CommonPage.restPage(tosOrderGiftList),"获取订单赠品信息列表成功");
    }

     @ApiOperation("修改订单赠品信息")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TosOrderGift tosOrderGift,
        BindingResult result) {
        tosOrderGift.setModifyDate(new Date());
        int count = 0;
        count = tosOrderGiftMapper.updateByPrimaryKeySelective(tosOrderGift);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除订单赠品信息")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tosOrderGiftMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取订单赠品信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TosOrderGift> getById(@PathVariable Long id) {
        TosOrderGift tosOrderGift = tosOrderGiftMapper.selectByPrimaryKey(id);
        return CommonResult.success(tosOrderGift);
    }


    @ApiOperation("获取gift列表")
    @RequestMapping(value = "/giftList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosOrderGiftSubListQueryParam>> giftList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosOrderGiftSubListQueryParam tosOrderGiftSubListQueryParam,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosOrderGiftSubListQueryParam> giftList = tosOrderGiftDao.getGiftList(tosOrderGiftSubListQueryParam);
        return  CommonResult.success(CommonPage.restPage(giftList),"获取订单赠品信息-gift列表成功");
    }

    @ApiOperation("添加订单赠品信息-gift")
    @RequestMapping(value = "/addGiftList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addGiftList(@RequestParam("ids") List<Long> ids, @RequestParam("orderId") Long orderId) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        Date createDate = new Date();
        for (Long id : ids) {
            TosOrderGift tosOrderGift = new  TosOrderGift();
            tosOrderGift.setCreateDate(createDate);
            tosOrderGift.setModifyDate(createDate);
                    tosOrderGift.setTosOrderId(orderId);
                    tosOrderGift.setTrsGiftId(orderId);
            count = tosOrderGiftMapper.insert(tosOrderGift);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
        }

}

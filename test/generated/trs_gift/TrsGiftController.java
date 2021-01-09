package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsGiftMapper;
import com.macro.mall.model.TrsGift;
import com.macro.mall.dto.TrsGiftQueryParam;
import com.macro.mall.dao.TrsGiftDao;
import com.macro.mall.model.TrsGiftExample;
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
* 赠品管理Controller
*/
@Controller
@Api(tags = "TrsGiftController", description = "赠品管理")
@RequestMapping("/gift")
public class TrsGiftController {

    @Autowired
    private TrsGiftMapper trsGiftMapper;
    @Autowired
    private TrsGiftDao trsGiftDao;

    @ApiOperation("添加赠品")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsGift trsGift) {
        Date createDate = new Date();
        trsGift.setCreateDate(createDate);
        trsGift.setModifyDate(createDate);
        int count = trsGiftMapper.insert(trsGift);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取赠品列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TrsGift>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TrsGiftQueryParam trsGiftQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrsGift> trsGiftList = trsGiftDao.getList(trsGiftQueryParam);
        return  CommonResult.success(CommonPage.restPage(trsGiftList),"获取赠品列表成功");
    }

     @ApiOperation("修改赠品")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsGift trsGift,
        BindingResult result) {
        trsGift.setModifyDate(new Date());
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除赠品")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取赠品")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsGift> getById(@PathVariable Long id) {
        TrsGift trsGift = trsGiftMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsGift);
    }
}

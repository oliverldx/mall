package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
* 赠品订单管理Controller
*/
@Controller
@Api(tags = "GiftOrderVoController", description = "赠品订单管理")
@RequestMapping("/orderVo")
public class GiftOrderVoController {

    @Autowired
    private GiftOrderVoMapper giftOrderVoMapper;

    @ApiOperation("添加赠品订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody GiftOrderVo giftOrderVo) {
        Date createDate = new Date();
        giftOrderVo.setCreateDate(createDate);
        giftOrderVo.setModifyDate(createDate);
        int count = giftOrderVoMapper.insert(giftOrderVo);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取赠品订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GiftOrderVo>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        GiftOrderVoExample example = new GiftOrderVoExample();
        List<GiftOrderVo> giftOrderVoList = giftOrderVoMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(giftOrderVoList),"获取赠品订单列表成功");
    }

     @ApiOperation("修改赠品订单")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody GiftOrderVo giftOrderVo,
        BindingResult result) {
        giftOrderVo.setModifyDate(new Date());
        int count = 0;
        count = giftOrderVoMapper.updateByPrimaryKeySelective(giftOrderVo);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除赠品订单")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = giftOrderVoMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取赠品订单")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<GiftOrderVo> getById(@PathVariable Long id) {
        GiftOrderVo giftOrderVo = giftOrderVoMapper.selectByPrimaryKey(id);
        return CommonResult.success(giftOrderVo);
    }
}

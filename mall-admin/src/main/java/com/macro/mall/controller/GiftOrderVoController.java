package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.TrsGiftOrderDao;
import com.macro.mall.dto.GiftOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 赠品订单管理Controller
*/
@Controller
@Api(tags = "GiftOrderVoController", description = "赠品订单管理")
@RequestMapping("/orderVo")
public class GiftOrderVoController {

    @Autowired
    private TrsGiftOrderDao trsGiftOrderDao;



    @ApiOperation("获取赠品订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<GiftOrderVo>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<GiftOrderVo> list = trsGiftOrderDao.getList();
        return  CommonResult.success(CommonPage.restPage(list),"获取赠品订单列表成功");
    }



    @ApiOperation("根据id获取赠品订单")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<GiftOrderVo> getById(@PathVariable Long id) {
        GiftOrderVo giftOrderVo = new GiftOrderVo();
        return CommonResult.success(giftOrderVo);
    }
}

package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.TusPromotionPosterDao;
import com.macro.mall.mapper.TusPromotionPosterMapper;
import com.macro.mall.model.TusPromotionPoster;
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
* 推广海报管理Controller
*/
@Controller
@Api(tags = "TusPromotionPosterController", description = "推广海报管理")
@RequestMapping("/promotionPoster")
public class TusPromotionPosterController {

    @Autowired
    private TusPromotionPosterMapper tusPromotionPosterMapper;
    @Autowired
    private TusPromotionPosterDao tusPromotionPosterDao;

    @ApiOperation("添加推广海报")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TusPromotionPoster tusPromotionPoster) {
        Date createDate = new Date();
//        tusPromotionPoster.setCreateDate(createDate);
//        tusPromotionPoster.setModifyDate(createDate);
        int count = tusPromotionPosterMapper.insert(tusPromotionPoster);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改推广海报")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@Validated @RequestBody TusPromotionPoster tusPromotionPoster,
            BindingResult result) {
//        tusPromotionPoster.setModifyDate(new Date());
        int count = 0;
        count = tusPromotionPosterMapper.updateByPrimaryKeySelective(tusPromotionPoster);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除推广海报")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tusPromotionPosterMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据id获取推广海报")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TusPromotionPoster> getById(@PathVariable Long id) {
        TusPromotionPoster tusPromotionPoster = tusPromotionPosterMapper.selectByPrimaryKey(id);
        return CommonResult.success(tusPromotionPoster);
    }

    @ApiOperation("根据userId获取推广海报")
    @RequestMapping(value = "/getByUserId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TusPromotionPoster> getByUserId(@PathVariable Long userId) {
        TusPromotionPoster tusPromotionPoster = tusPromotionPosterDao.getByUserId(userId);
        return CommonResult.success(tusPromotionPoster);
    }
}

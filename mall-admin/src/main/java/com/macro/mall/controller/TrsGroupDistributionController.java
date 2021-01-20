package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsGroupDistributionMapper;
import com.macro.mall.model.TrsGroupDistribution;
import com.macro.mall.dao.TrsGroupDistributionDao;
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
* 分销管理Controller
*/
@Controller
@Api(tags = "TrsGroupDistributionController", description = "分销管理")
@RequestMapping("/groupDistribution")
public class TrsGroupDistributionController {

    @Autowired
    private TrsGroupDistributionMapper trsGroupDistributionMapper;
    @Autowired
    private TrsGroupDistributionDao trsGroupDistributionDao;

    @ApiOperation("添加分销")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TrsGroupDistribution trsGroupDistribution) {
        Date createDate = new Date();
        trsGroupDistribution.setCreateDate(createDate);
        trsGroupDistribution.setModifyDate(createDate);
        int count = trsGroupDistributionMapper.insert(trsGroupDistribution);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改分销")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@Validated @RequestBody TrsGroupDistribution trsGroupDistribution,
            BindingResult result) {
        trsGroupDistribution.setModifyDate(new Date());
        int count = 0;
        count = trsGroupDistributionMapper.updateByPrimaryKeySelective(trsGroupDistribution);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除分销")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = trsGroupDistributionMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据id获取分销")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsGroupDistribution> getById(@PathVariable Long id) {
        TrsGroupDistribution trsGroupDistribution = trsGroupDistributionMapper.selectByPrimaryKey(id);
        return CommonResult.success(trsGroupDistribution);
    }

    @ApiOperation("根据activityId获取分销")
    @RequestMapping(value = "/getByActivityId/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TrsGroupDistribution> getByActivityId(@PathVariable Long activityId) {
        TrsGroupDistribution trsGroupDistribution = trsGroupDistributionDao.getByActivityId(activityId);
        return CommonResult.success(trsGroupDistribution);
    }
}

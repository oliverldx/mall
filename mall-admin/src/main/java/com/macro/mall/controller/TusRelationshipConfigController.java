package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TusRelationshipConfigMapper;
import com.macro.mall.model.TusRelationshipConfig;
import com.macro.mall.dto.TusRelationshipConfigQueryParam;
import com.macro.mall.dao.TusRelationshipConfigDao;
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
* 关系设置管理Controller
*/
@Controller
@Api(tags = "TusRelationshipConfigController", description = "关系设置管理")
@RequestMapping("/relationshipConfig")
public class TusRelationshipConfigController {

    @Autowired
    private TusRelationshipConfigMapper tusRelationshipConfigMapper;
    @Autowired
    private TusRelationshipConfigDao tusRelationshipConfigDao;

    @ApiOperation("添加关系设置")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TusRelationshipConfig tusRelationshipConfig) {
        Date createDate = new Date();
        tusRelationshipConfig.setCreateDate(createDate);
        tusRelationshipConfig.setModifyDate(createDate);
        int count = tusRelationshipConfigMapper.insert(tusRelationshipConfig);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取关系设置列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TusRelationshipConfig>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TusRelationshipConfigQueryParam tusRelationshipConfigQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TusRelationshipConfig> tusRelationshipConfigList = tusRelationshipConfigDao.getList(tusRelationshipConfigQueryParam);
        return  CommonResult.success(CommonPage.restPage(tusRelationshipConfigList),"获取关系设置列表成功");
    }

     @ApiOperation("修改关系设置")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TusRelationshipConfig tusRelationshipConfig,
        BindingResult result) {
        tusRelationshipConfig.setModifyDate(new Date());
        int count = 0;
        count = tusRelationshipConfigMapper.updateByPrimaryKeySelective(tusRelationshipConfig);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除关系设置")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tusRelationshipConfigMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取关系设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TusRelationshipConfig> getById(@PathVariable Long id) {
        TusRelationshipConfig tusRelationshipConfig = tusRelationshipConfigMapper.selectByPrimaryKey(id);
        return CommonResult.success(tusRelationshipConfig);
    }
}

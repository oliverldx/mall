package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TusUserMapper;
import com.macro.mall.model.TusUser;
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
* 用户管理Controller
*/
@Controller
@Api(tags = "TusUserController", description = "用户管理")
@RequestMapping("/user")
public class TusUserController {

    @Autowired
    private TusUserMapper tusUserMapper;

    @ApiOperation("添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TusUser tusUser) {
        Date createDate = new Date();
        tusUser.setCreateDate(createDate);
        tusUser.setModifyDate(createDate);
        int count = tusUserMapper.insert(tusUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TusUser>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        TusUserExample example = new TusUserExample();
        List<TusUser> tusUserList = tusUserMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(tusUserList),"获取用户列表成功");
    }

     @ApiOperation("修改用户")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TusUser tusUser,
        BindingResult result) {
        tusUser.setModifyDate(new Date());
        int count = 0;
        count = tusUserMapper.updateByPrimaryKeySelective(tusUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除用户")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tusUserMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TusUser> getById(@PathVariable Long id) {
        TusUser tusUser = tusUserMapper.selectByPrimaryKey(id);
        return CommonResult.success(tusUser);
    }
}

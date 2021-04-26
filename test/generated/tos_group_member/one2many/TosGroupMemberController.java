package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TosGroupMemberMapper;
import com.macro.mall.model.TosGroupMember;
import com.macro.mall.dto.TosGroupMemberDto;
import com.macro.mall.dto.TosGroupMemberQueryParam;
import com.macro.mall.dao.TosGroupMemberDao;
import com.macro.mall.dto.TosGroupMemberSubListQueryParam;
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
* 参团队员管理Controller
*/
@Controller
@Api(tags = "TosGroupMemberController", description = "参团队员管理")
@RequestMapping("/groupMember")
public class TosGroupMemberController {

    @Autowired
    private TosGroupMemberMapper tosGroupMemberMapper;
    @Autowired
    private TosGroupMemberDao tosGroupMemberDao;

    @ApiOperation("添加参团队员")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TosGroupMember tosGroupMember) {
        Date createDate = new Date();
        tosGroupMember.setCreateDate(createDate);
        tosGroupMember.setModifyDate(createDate);
        int count = tosGroupMemberMapper.insert(tosGroupMember);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取参团队员列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosGroupMemberDto>>
        list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosGroupMemberQueryParam tosGroupMemberQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosGroupMemberDto> tosGroupMemberList = tosGroupMemberDao.getList(tosGroupMemberQueryParam);
        return  CommonResult.success(CommonPage.restPage(tosGroupMemberList),"获取参团队员列表成功");
    }

     @ApiOperation("修改参团队员")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TosGroupMember tosGroupMember,
        BindingResult result) {
        tosGroupMember.setModifyDate(new Date());
        int count = 0;
        count = tosGroupMemberMapper.updateByPrimaryKeySelective(tosGroupMember);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除参团队员")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tosGroupMemberMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取参团队员")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TosGroupMember> getById(@PathVariable Long id) {
        TosGroupMember tosGroupMember = tosGroupMemberMapper.selectByPrimaryKey(id);
        return CommonResult.success(tosGroupMember);
    }


    @ApiOperation("获取user列表")
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TosGroupMemberSubListQueryParam>> userList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TosGroupMemberSubListQueryParam tosGroupMemberSubListQueryParam,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TosGroupMemberSubListQueryParam> userList = tosGroupMemberDao.getUserList(tosGroupMemberSubListQueryParam);
        return  CommonResult.success(CommonPage.restPage(userList),"获取参团队员-user列表成功");
    }

    @ApiOperation("添加参团队员-user")
    @RequestMapping(value = "/addUserList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addUserList(@RequestParam("ids") List<Long> ids, @RequestParam("userId") Long userId) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        Date createDate = new Date();
        for (Long id : ids) {
            TosGroupMember tosGroupMember = new  TosGroupMember();
            tosGroupMember.setCreateDate(createDate);
            tosGroupMember.setModifyDate(createDate);
                    tosGroupMember.setTosOrderId(userId);
                    tosGroupMember.setTusUserId(userId);
            count = tosGroupMemberMapper.insert(tosGroupMember);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
        }

}

package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.${tableName}Mapper;
import com.macro.mall.model.${tableName};
import com.macro.mall.model.${tableName}Example;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* ${chineseName}管理Controller
*/
@Controller
@Api(tags = "${tableName}Controller", description = "${chineseName}管理")
@RequestMapping("/${subName}")
public class ${tableName}Controller {

    @Autowired
    private ${tableName}Mapper ${tableName?uncap_first}Mapper;

    @ApiOperation("添加${chineseName}")
    @RequestMapping(value = "/TODO-add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody ${tableName} ${tableName?uncap_first}) {
        int count = ${tableName?uncap_first}Mapper.insert(${tableName?uncap_first});
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取${chineseName}列表")
    @RequestMapping(value = "/TODO-list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<${tableName}>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ${tableName}Example example = new ${tableName}Example();
        List<${tableName}> ${tableName?uncap_first}List = ${tableName?uncap_first}Mapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(${tableName?uncap_first}List),"获取${chineseName}列表成功");
    }

     @ApiOperation("修改${chineseName}")
     @RequestMapping(value = "/TODO-update", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult updateAttr(@RequestBody ${tableName} ${tableName?uncap_first}) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除${chineseName}")
     @RequestMapping(value = "/TODO-delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }
}

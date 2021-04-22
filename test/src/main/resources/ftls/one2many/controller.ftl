package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.${tableName}Mapper;
import com.macro.mall.model.${tableName};
<#if genDao?default("")?trim?length gt 1>
import com.macro.mall.dto.${tableName}Dto;
import com.macro.mall.dto.${tableName}QueryParam;
import com.macro.mall.dao.${tableName}Dao;
</#if>
<#if showSubList>
import com.macro.mall.dto.${tableName}SubListQueryParam;
</#if>
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
* ${chineseName}管理Controller
*/
@Controller
@Api(tags = "${tableName}Controller", description = "${chineseName}管理")
@RequestMapping("/${subName}")
public class ${tableName}Controller {

    @Autowired
    private ${tableName}Mapper ${tableName?uncap_first}Mapper;
<#if genDao?default("")?trim?length gt 1>
    @Autowired
    private ${tableName}Dao ${tableName?uncap_first}Dao;
</#if>

    @ApiOperation("添加${chineseName}")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody ${tableName} ${tableName?uncap_first}) {
        Date createDate = new Date();
        ${tableName?uncap_first}.setCreateDate(createDate);
        ${tableName?uncap_first}.setModifyDate(createDate);
        int count = ${tableName?uncap_first}Mapper.insert(${tableName?uncap_first});
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取${chineseName}列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
<#if genDao?default("")?trim?length gt 1>
    public CommonResult<CommonPage<${tableName}Dto>>
<#else >
    public CommonResult<CommonPage<${tableName}>>
</#if>
        list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
<#if genDao?default("")?trim?length gt 1>
        ${tableName}QueryParam ${tableName?uncap_first}QueryParam,
</#if>
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
<#if genDao?default("")?trim?length gt 1>
        List<${tableName}Dto> ${tableName?uncap_first}List = ${tableName?uncap_first}Dao.getList(${tableName?uncap_first}QueryParam);
<#else>
        ${tableName}Example example = new ${tableName}Example();
        List<${tableName}> ${tableName?uncap_first}List = ${tableName?uncap_first}Mapper.selectByExample(example);
</#if>
        return  CommonResult.success(CommonPage.restPage(${tableName?uncap_first}List),"获取${chineseName}列表成功");
    }

     @ApiOperation("修改${chineseName}")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody ${tableName} ${tableName?uncap_first},
        BindingResult result) {
        ${tableName?uncap_first}.setModifyDate(new Date());
        int count = 0;
        count = ${tableName?uncap_first}Mapper.updateByPrimaryKeySelective(${tableName?uncap_first});
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除${chineseName}")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = ${tableName?uncap_first}Mapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取${chineseName}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<${tableName}> getById(@PathVariable Long id) {
        ${tableName} ${tableName?uncap_first} = ${tableName?uncap_first}Mapper.selectByPrimaryKey(id);
        return CommonResult.success(${tableName?uncap_first});
    }


    <#if showSubList>
    @ApiOperation("获取${subListName?uncap_first}列表")
    @RequestMapping(value = "/${subListName?uncap_first}List", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<${tableName}SubListQueryParam>> ${subListName?uncap_first}List(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        ${tableName}SubListQueryParam ${tableName?uncap_first}SubListQueryParam,
    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<${tableName}SubListQueryParam> ${subListName?uncap_first}List = ${tableName?uncap_first}Dao.get${subListName}List(${tableName?uncap_first}SubListQueryParam);
        return  CommonResult.success(CommonPage.restPage(${subListName?uncap_first}List),"获取${chineseName}-${subListName?uncap_first}列表成功");
    }

    @ApiOperation("添加${chineseName}-${subListName?uncap_first}")
    @RequestMapping(value = "/add${subListName}List", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add${subListName}List(@RequestParam("ids") List<Long> ids, @RequestParam("${fkId}") Long ${fkId}) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        Date createDate = new Date();
        for (Long id : ids) {
            ${tableName} ${tableName?uncap_first} = new  ${tableName}();
            ${tableName?uncap_first}.setCreateDate(createDate);
            ${tableName?uncap_first}.setModifyDate(createDate);
            <#list subColumns as column>
                <#if column.code == fkId>
                    ${tableName?uncap_first}.set${column.name?cap_first}(${fkId});
                <#else >
                    ${tableName?uncap_first}.set${column.name?cap_first}(id);
                </#if>
            </#list>
            count = ${tableName?uncap_first}Mapper.insert(${tableName?uncap_first});
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
        }
    </#if>

}
package com.macro.mall.controller;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TusCapitalRecordMapper;
import com.macro.mall.model.TusCapitalRecord;
import com.macro.mall.dto.TusCapitalRecordQueryParam;
import com.macro.mall.dao.TusCapitalRecordDao;
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
* 资金记录管理Controller
*/
@Controller
@Api(tags = "TusCapitalRecordController", description = "资金记录管理")
@RequestMapping("/capitalRecord")
public class TusCapitalRecordController {

    @Autowired
    private TusCapitalRecordMapper tusCapitalRecordMapper;
    @Autowired
    private TusCapitalRecordDao tusCapitalRecordDao;

    @ApiOperation("添加资金记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody TusCapitalRecord tusCapitalRecord) {
        Date createDate = new Date();
        tusCapitalRecord.setCreateDate(createDate);
        tusCapitalRecord.setModifyDate(createDate);
        int count = tusCapitalRecordMapper.insert(tusCapitalRecord);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取资金记录列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TusCapitalRecord>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        TusCapitalRecordQueryParam tusCapitalRecordQueryParam,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<TusCapitalRecord> tusCapitalRecordList = tusCapitalRecordDao.getList(tusCapitalRecordQueryParam);
        return  CommonResult.success(CommonPage.restPage(tusCapitalRecordList),"获取资金记录列表成功");
    }

     @ApiOperation("修改资金记录")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody TusCapitalRecord tusCapitalRecord,
        BindingResult result) {
        tusCapitalRecord.setModifyDate(new Date());
        int count = 0;
        count = tusCapitalRecordMapper.updateByPrimaryKeySelective(tusCapitalRecord);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除资金记录")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = tusCapitalRecordMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取资金记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<TusCapitalRecord> getById(@PathVariable Long id) {
        TusCapitalRecord tusCapitalRecord = tusCapitalRecordMapper.selectByPrimaryKey(id);
        return CommonResult.success(tusCapitalRecord);
    }
}

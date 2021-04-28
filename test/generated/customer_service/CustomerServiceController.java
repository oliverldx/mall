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
* 客服中心管理Controller
*/
@Controller
@Api(tags = "CustomerServiceController", description = "客服中心管理")
@RequestMapping("/service")
public class CustomerServiceController {

    @Autowired
    private CustomerServiceMapper customerServiceMapper;

    @ApiOperation("添加客服中心")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody CustomerService customerService) {
        Date createDate = new Date();
        customerService.setCreateDate(createDate);
        customerService.setModifyDate(createDate);
        int count = customerServiceMapper.insert(customerService);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取客服中心列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CustomerService>> list(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CustomerServiceExample example = new CustomerServiceExample();
        List<CustomerService> customerServiceList = customerServiceMapper.selectByExample(example);
        return  CommonResult.success(CommonPage.restPage(customerServiceList),"获取客服中心列表成功");
    }

     @ApiOperation("修改客服中心")
     @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult update(@PathVariable Long id,@Validated @RequestBody CustomerService customerService,
        BindingResult result) {
        customerService.setModifyDate(new Date());
        int count = 0;
        count = customerServiceMapper.updateByPrimaryKeySelective(customerService);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

     @ApiOperation("删除客服中心")
     @RequestMapping(value = "/delete", method = RequestMethod.POST)
     @ResponseBody
     public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = 0;
        if(ids == null || ids.isEmpty()) {
            return CommonResult.failed();
        }
        for (Long id : ids) {
            count = customerServiceMapper.deleteByPrimaryKey(id);
        }
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
     }

    @ApiOperation("根据id获取客服中心")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CustomerService> getById(@PathVariable Long id) {
        CustomerService customerService = customerServiceMapper.selectByPrimaryKey(id);
        return CommonResult.success(customerService);
    }
}

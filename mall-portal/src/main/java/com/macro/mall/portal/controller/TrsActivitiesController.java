package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.dao.PortalActivitiesDao;
import com.macro.mall.portal.domain.Activities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 活动管理Controller
 */
@Controller
@Api(tags = "TrsActivitiesController", description = "活动管理")
@RequestMapping("/trsActivities")
public class TrsActivitiesController {

    @Autowired
    private PortalActivitiesDao portalActivitiesDao;



    @ApiOperation("活动首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Activities>> list(String id) {
        List<Activities> activities = portalActivitiesDao.getActivities(id);
        return  CommonResult.success(activities,"获取活动首页成功");
    }


}

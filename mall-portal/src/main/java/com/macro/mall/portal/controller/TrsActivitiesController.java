package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.TrsActivityMapper;
import com.macro.mall.mapper.TrsGiftMapper;
import com.macro.mall.mapper.TrsGroupSaleMapper;
import com.macro.mall.mapper.TrsPagesMapper;
import com.macro.mall.model.*;
import com.macro.mall.portal.dao.PortalActivitiesDao;
import com.macro.mall.portal.domain.Activities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动管理Controller
 */
@Controller
@Api(tags = "TrsActivitiesController", description = "活动管理")
@RequestMapping("/trsActivities")
public class TrsActivitiesController {

    @Autowired
    private PortalActivitiesDao portalActivitiesDao;
    @Autowired
    private TrsActivityMapper trsActivityMapper;
    @Autowired
    private TrsPagesMapper trsPagesMapper;
    @Autowired
    private TrsGiftMapper trsGiftMapper;
    @Autowired
    private TrsGroupSaleMapper trsGroupSaleMapper;


    @ApiOperation("活动首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Activities>> list(String id) {
        List<Activities> activities = portalActivitiesDao.getActivities(id);
        return  CommonResult.success(activities,"获取活动首页成功");
    }

    @ApiOperation("活动详情")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Map<String,Object>> getById(String id) {
        if(StringUtils.isNotBlank(id)) {
            Map<String,Object> res = new HashMap<String, Object>();
            Long activityId = Long.valueOf(id);
            TrsActivity trsActivity = trsActivityMapper.selectByPrimaryKey(activityId);
            res.put("trsActivity",trsActivity);
            TrsPagesExample trsPagesExample = new TrsPagesExample();
            trsPagesExample.createCriteria().andTrsActivityIdEqualTo(activityId);
            List<TrsPages> trsPages = trsPagesMapper.selectByExample(trsPagesExample);
            if(trsPages.size() > 0) {
                res.put("trsPages",trsPages.get(0));
            }
            TrsGiftExample trsGiftExample = new TrsGiftExample();
            trsGiftExample.createCriteria().andTrsActivityIdEqualTo(activityId);
            List<TrsGift> trsGifts = trsGiftMapper.selectByExample(trsGiftExample);
            if(trsGifts.size() > 0) {
                res.put("trsGifts",trsGifts);
            }
            TrsGroupSaleExample trsGroupSaleExample = new TrsGroupSaleExample();
            trsGroupSaleExample.createCriteria().andTrsActivityIdEqualTo(activityId);
            List<TrsGroupSale> trsGroupSales = trsGroupSaleMapper.selectByExample(trsGroupSaleExample);
            if(trsGroupSales.size() > 0) {
                res.put("trsGroupSales",trsGroupSales.get(0));
            }

            return  CommonResult.success(res,"获取活动详情成功");
        }
        return CommonResult.failed("获取活动详情失败-id 不能为空");
    }

    @ApiOperation("获取赠品列表")
    @RequestMapping(value = "/getGifts/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<TrsGift>> get(@PathVariable Long activityId) {
        TrsGiftExample trsGiftExample = new TrsGiftExample();
        trsGiftExample.createCriteria().andTrsActivityIdEqualTo(activityId);
        List<TrsGift> trsGifts = trsGiftMapper.selectByExample(trsGiftExample);
        return  CommonResult.success(trsGifts,"获取赠品列表成功");
    }


}

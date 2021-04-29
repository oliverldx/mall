package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.TosOrderDetail;
import com.macro.mall.portal.service.TosOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TosOrderServiceImpl implements TosOrderService {

    @Autowired
    TosOrderCourseMapper tosOrderCourseMapper;
    @Autowired
    TosOrderGiftMapper tosOrderGiftMapper;
    @Autowired
    TosOrderMapper tosOrderMapper;
    @Autowired
    TrsActivityMapper trsActivityMapper;
    @Autowired
    TrsGroupSaleMapper trsGroupSaleMapper;

    @Override
    @Transactional
    public boolean createTosOrder(TosOrderDetail tosOrderDetail) {
        TosOrder tosOrder = tosOrderDetail.getTosOrder();
        tosOrder.setOrderNo(UUID.randomUUID().toString().replaceAll("-",""));
        Date now = new Date();
        tosOrder.setOrderTime(now);
        tosOrder.setPayTime(now);
        tosOrder.setGroupTime(now);
        tosOrder.setModifyDate(now);
        tosOrder.setCreateDate(now);
        TrsGroupSaleExample trsGroupSaleExample = new TrsGroupSaleExample();
        trsGroupSaleExample.createCriteria().andTrsActivityIdEqualTo(tosOrder.getTrsActivityId());
        List<TrsGroupSale> trsGroupSales = trsGroupSaleMapper.selectByExample(trsGroupSaleExample);
        if(trsGroupSales != null && trsGroupSales.size() > 0) {
            tosOrder.setDistributionMoney(BigDecimal.valueOf(trsGroupSales.get(0).getGroupSale()));
        }
        int i = tosOrderMapper.insertSelective(tosOrder);
        if(i <= 0 ) {
            return false;
        }
        Long orderId = tosOrder.getId();
        List<TosOrderCourse> tosOrderCourses = tosOrderDetail.getTosOrderCourses();
        for(TosOrderCourse tosOrderCourse : tosOrderCourses) {
            tosOrderCourse.setTosOrderId(orderId);
            tosOrderCourse.setModifyDate(now);
            tosOrderCourse.setCreateDate(now);
            tosOrderCourseMapper.insert(tosOrderCourse);
        }
        List<TosOrderGift> tosOrderGifts = tosOrderDetail.getTosOrderGifts();
        for(TosOrderGift tosOrderGift : tosOrderGifts) {
            tosOrderGift.setTosOrderId(orderId);
            tosOrderGift.setModifyDate(now);
            tosOrderGift.setCreateDate(now);
            tosOrderGiftMapper.insert(tosOrderGift);
        }
        return true;
    }

    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    /*private String generateOrderNo(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType()));
        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }*/
}

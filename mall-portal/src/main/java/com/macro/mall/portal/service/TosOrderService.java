package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.TosOrderDetail;

public interface TosOrderService {

    /**
     * 创建订单
     * @param tosOrderDetail
     * @return
     */
    boolean createTosOrder(TosOrderDetail tosOrderDetail);
}

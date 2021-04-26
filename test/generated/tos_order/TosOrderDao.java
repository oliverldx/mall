package com.macro.mall.dao;


import com.macro.mall.dto.TosOrderQueryParam;
import com.macro.mall.model.TosOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 订单自定义查询Dao
*/
public interface TosOrderDao {

    /**
    * 条件查询订单
    */
    List<TosOrder> getList(@Param("queryParam") TosOrderQueryParam queryParam);

}

package com.macro.mall.dao;


import com.macro.mall.dto.TrsGroupSaleQueryParam;
import com.macro.mall.model.TrsGroupSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 课程活动自定义查询Dao
*/
public interface TrsGroupSaleDao {

    /**
    * 条件查询订单
    */
    List<TrsGroupSale> getList(@Param("queryParam") TrsGroupSaleQueryParam queryParam);

}

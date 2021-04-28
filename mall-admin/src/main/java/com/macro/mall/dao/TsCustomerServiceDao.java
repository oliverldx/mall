package com.macro.mall.dao;


import com.macro.mall.model.TsCustomerService;
import org.apache.ibatis.annotations.Param;

/**
* 客服中心自定义查询Dao
*/
public interface TsCustomerServiceDao {

    /**
    * 根据activityId获取客服中心
    */
    TsCustomerService getByActivityId(@Param("activityId") Long activityId);

}

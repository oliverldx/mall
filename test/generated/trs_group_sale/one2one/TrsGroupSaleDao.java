package com.macro.mall.dao;


import com.macro.mall.model.TrsGroupSale;
import org.apache.ibatis.annotations.Param;

/**
* 课程活动自定义查询Dao
*/
public interface TrsGroupSaleDao {

    /**
    * 根据activityId获取课程活动
    */
    TrsGroupSale getByActivityId(@Param("activityId") Long activityId);

}

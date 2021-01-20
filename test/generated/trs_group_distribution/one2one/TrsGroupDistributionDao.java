package com.macro.mall.dao;


import com.macro.mall.model.TrsGroupDistribution;
import org.apache.ibatis.annotations.Param;

/**
* 分销自定义查询Dao
*/
public interface TrsGroupDistributionDao {

    /**
    * 根据activityId获取分销
    */
    TrsGroupDistribution getByActivityId(@Param("activityId") Long activityId);

}

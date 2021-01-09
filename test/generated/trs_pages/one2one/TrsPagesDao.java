package com.macro.mall.dao;


import com.macro.mall.model.TrsPages;
import org.apache.ibatis.annotations.Param;

/**
* 页面自定义查询Dao
*/
public interface TrsPagesDao {

    /**
    * 根据activityId获取页面
    */
    TrsPages getByActivityId(@Param("activityId") Long activityId);

}
